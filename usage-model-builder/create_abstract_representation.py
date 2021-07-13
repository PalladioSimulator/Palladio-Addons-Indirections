import json
import sys
from os.path import exists
from collections import defaultdict
import pandas as pd
from create_double_pmf import create_double_pmf


def windows(shift, size, maximum):
    return [(it, it + size) for it in range(0, maximum + 1, shift)]


def data_in_window(data, window):
    return data[(window[0] <= data['timestamp']) & (data['timestamp'] < window[1])]


def create_abstract_representation(data):
    data['pid'] = data['house_id'] * 10_000 + data['household_id'] * 100 + data['plug_id']

    data_per_houseid = defaultdict(lambda: defaultdict(int))
    pmfs_per_houseid = defaultdict(dict)
    for pid in data['pid'].unique():
        data_for_pid = data[data['pid'] == pid]

        plug_id = list(data_for_pid['plug_id'])[0]
        house_id = list(data_for_pid['house_id'])[0]

        all_shifts = (data_for_pid['timestamp'] - data_for_pid['timestamp'].shift(1))[1:]

        value_counts = all_shifts.value_counts()

        distribution = value_counts / value_counts.sum()
        pmfs_per_houseid[house_id][int(pid)] = create_double_pmf(distribution)

        for k, v in dict(value_counts).items():
            data_per_houseid[house_id][k] += v

    distribution_per_house_id = {}
    for house_id, entries in data_per_houseid.items():
        total = sum(entries.values())
        distribution_per_house_id[house_id] = {k: v/total for k, v in entries.items()}

    pmf_per_house_id = {}
    for house_id, entries in distribution_per_house_id.items():
        pmf_per_house_id[house_id] = create_double_pmf(entries)

    average_iat_per_house_id = {}
    for house_id, entries in distribution_per_house_id.items():
        average_iat_per_house_id[house_id] = sum([k*v for k, v in entries.items()])

    plug_ids = list(data.apply(lambda x: (int(x['house_id']), int(x['household_id']), int(x['plug_id'])), axis=1).unique())
    plug_ids_per_house_id = pd.DataFrame(plug_ids, columns=['house_id', 'household_id', 'plug_id']).groupby('house_id')
    plug_id_counts_per_house_id = plug_ids_per_house_id.count()['plug_id']

    house_ids = list(plug_ids_per_house_id.indices.keys())

    number_of_houses = len(house_ids)
    mean_plugs_per_house = plug_ids_per_house_id.count()['plug_id'].mean()

    houses_out = []
    for house_id in house_ids:
        house_description = {
            "house_id": house_id,
            "plug_ids": int(plug_id_counts_per_house_id[house_id]),
            "pmf_iat": pmf_per_house_id[house_id],
            "average_iat": average_iat_per_house_id[house_id],
            "pmf_iat_per_plug": pmfs_per_houseid[house_id]
        }

        houses_out.append(house_description)

    return houses_out


if __name__ == "__main__":
    in_filename = sys.argv[1]
    if not exists(in_filename):
        print("Input file does not exist.")
        exit(1)

    data = pd.read_csv(in_filename)
    abstract = create_abstract_representation(data)
    with open('abstract_representation.json', 'w') as output_json:
        json.dump(abstract, output_json, indent=4)
