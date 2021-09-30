import json
import sys
from os.path import exists
from collections import defaultdict, Counter
import pandas as pd
from create_double_pmf import create_double_pmf

configuration = {
    'window_size': 10,
    'window_shift': 10,
}


# windows up to the last window that includes maximum
def windows(shift, size, maximum):
    return [(it, it + size) for it in range(0, maximum + 1, shift)]


def window_contains(window):
    window_start, window_end = window
    return lambda x: (window_start <= x['timestamp']) and (x['timestamp'] < window_end)


def data_in_window(data, window):
    return data[(window[0] <= data['timestamp']) & (data['timestamp'] < window[1])]


def create_abstract_representation(data, configuration):
    # calculate a unique identifier
    data['pid'] = data['house_id'] * 10_000 + data['household_id'] * 100 + data['plug_id']

    # data sorted by house_id, which is the top level in the hierarchy we need for model generation
    house_id_to_data = defaultdict(lambda: defaultdict(int))

    # information for each plug inside a house:
    #  plug_id: plug_id
    #  iat: interarrival time of data
    house_id_to_plug_id_to_data = defaultdict(dict)

    # find all unique values for the plug id and then work with all data associated with this pid
    #
    # the data has the following structure:
    # id,timestamp,value,property,plug_id,household_id,house_id
    # + the derived column "pid"
    for pid in data['pid'].unique():
        data_for_current_pid = data[data['pid'] == pid]

        # 0 = any index, since all have the same value (pid implies plug_id and house_id)
        plug_id = list(data_for_current_pid['plug_id'])[0]
        house_id = list(data_for_current_pid['house_id'])[0]

        # assumes that the data is ordered. we want to derive the number of times the interval between two values
        # by the same pid is 0, 1, 2, ...
        all_shifts = (data_for_current_pid['timestamp'] - data_for_current_pid['timestamp'].shift(1))[1:]
        value_counts = all_shifts.value_counts()
        distribution = value_counts / value_counts.sum()

        # the data that is needed for model generation for the current pid
        model_data_for_current_pid = {
            'plug_id': plug_id,
            'iat': create_double_pmf(distribution)
        }

        house_id_to_plug_id_to_data[house_id][int(pid)] = model_data_for_current_pid

        for k, v in dict(value_counts).items():
            house_id_to_data[house_id][k] += v

    distribution_per_house_id = {}
    for house_id, entries in house_id_to_data.items():
        total = sum(entries.values())
        distribution_per_house_id[house_id] = {k: v/total for k, v in entries.items()}

    pmf_per_house_id = {}
    for house_id, entries in distribution_per_house_id.items():
        pmf_per_house_id[house_id] = create_double_pmf(entries)

    average_iat_per_house_id = {}
    for house_id, entries in distribution_per_house_id.items():
        average_iat_per_house_id[house_id] = sum([k*v for k, v in entries.items()])

    def create_id_tuple_for_row(x):
        return int(x['house_id']), int(x['household_id']), int(x['plug_id'])

    all_unique_plug_ids = list(data.apply(create_id_tuple_for_row, axis=1).unique())

    # statistical data: which plug_id occur with which house_id, how many plug_id for a house_id
    house_id_to_plug_ids = pd.DataFrame(all_unique_plug_ids, columns=['house_id', 'household_id', 'plug_id']).groupby('house_id')
    house_id_to_plug_id_counts = house_id_to_plug_ids.count()['plug_id']

    # all (unique) house_id
    house_ids = list(house_id_to_plug_ids.indices.keys())

    # generate distribution about windows
    maximum_timestamp = data['timestamp'].max()
    all_windows = windows(configuration['window_shift'], configuration['window_size'], maximum_timestamp)
    all_windows.pop()
    house_id_to_window_data_counts = defaultdict(list)
    for window in all_windows:
        data_for_window = data[data.apply(window_contains(window), axis=1)]
        for current_house_id in house_ids:
            data_for_house = data_for_window[data_for_window['house_id'] == current_house_id]
            number_of_elements = data_for_house.count()['id']
            house_id_to_window_data_counts[current_house_id].append(number_of_elements)

    house_id_to_window_data_counts_distribution = dict()
    house_id_to_window_data_counts_distribution_pmf = dict()
    for house_id in house_ids:
        counts = house_id_to_window_data_counts[house_id]
        distribution = {k: v / len(counts) for k, v in Counter(counts).items()}
        house_id_to_window_data_counts_distribution[house_id] = distribution
        house_id_to_window_data_counts_distribution_pmf[house_id] = create_double_pmf(distribution)

    # the final data that is used for model generation
    houses_out = []
    for house_id in house_ids:
        house_description = {
            "house_id": int(house_id),
            "plug_ids": int(house_id_to_plug_id_counts[house_id]),
            "pmf_iat": pmf_per_house_id[house_id],
            "average_iat": average_iat_per_house_id[house_id],
            "pmf_iat_per_plug": house_id_to_plug_id_to_data[house_id],
            "window_size": configuration["window_size"],
            "window_shift": configuration["window_shift"],
            "number_of_elements_distribution": house_id_to_window_data_counts_distribution_pmf[house_id]
        }

        houses_out.append(house_description)

    return houses_out


if __name__ == "__main__":
    in_filename = sys.argv[1]
    if not exists(in_filename):
        print("Input file does not exist.")
        exit(1)

    data = pd.read_csv(in_filename)
    abstract = create_abstract_representation(data, configuration)
    with open('out/abstract_representation.json', 'w') as output_json:
        json.dump(abstract, output_json, indent=4)
