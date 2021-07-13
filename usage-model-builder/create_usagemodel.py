import json
from pprint import pprint

configuration = {
    'window_size': 10,
    'window_shift': 10,

}


def create_usagemodel(abstract_representation, configuration):
    window_size = configuration['window_size']
    window_shift = configuration['window_shift']

    usage_scenarios = []

    for house in abstract_representation:
        data_per_window = (window_size / house['average_iat']) * house['plug_ids']

        usage_scenario = {
            'interarrivaltime': window_shift,
            'data_per_window': data_per_window
        }

        usage_scenarios.append(usage_scenario)

    return usage_scenarios


if __name__ == '__main__':
    with open('abstract_representation.json', 'r') as in_file:
        abstract_representation = json.load(in_file)

    pprint(create_usagemodel(abstract_representation, configuration))
