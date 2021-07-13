import sys
from os.path import exists
import pandas as pd

import jinja2


def max_house(max_id):
    pass


def max_plug(max_id):
    pass


def filter_full_id(max):
    pass

env = jinja2.Environment(
    loader=jinja2.FileSystemLoader('templates'),
    autoescape=jinja2.select_autoescape(['xmi'])
)


def create_usage_model(entries):
    return env.get_template('usage_model.xmi').render(entries=entries)


def in_interval(start, end_exclusive):
    return lambda line: start <= int(line["timestamp"]) < end_exclusive


def createDoublePDF(distribution):
    return f'DoublePMF[{"".join((map(lambda it: f"({it[0]};{it[1]})", distribution.items())))}]'

def main(filters, input_filename):
    input = sys.argv[1]

    if not exists(input):
        print("Input file does not exist.")
        exit(1)

    data = pd.read_csv(input)

    data['pid'] = data['house_id'] * 10_000 + data['household_id'] * 100 + data['plug_id']

    usage_scenarios = []

    for pid in data['pid'].unique():
        data_for_pid = data[data['pid'] == pid]

        plug_id = list(data_for_pid['plug_id'])[0]
        house_id = list(data_for_pid['house_id'])[0]

        all_shifts = (data_for_pid['timestamp'] - data_for_pid['timestamp'].shift(1))[1:]

        value_counts = all_shifts.value_counts()
        distribution = value_counts / value_counts.sum()

        usage_scenarios.append({
            'pid': pid,
            'plugId': plug_id,
            'houseId': house_id,
            'interarrivalTime': createDoublePDF(distribution)
        })

    print(f"{len(usage_scenarios)} scenarios")
    with open('./generated.usagemodel', 'w') as f:
        f.write(create_usage_model(usage_scenarios))

filters = {
#    (0, 200): [max_house(2), max_plug(2)],
#    (200, 1000): [max_house(-1)]
    (0, 1000): [filter_full_id(4)]
}

if __name__ == "__main__":
    main(filters, sys.argv[1])
