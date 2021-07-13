import json
from pprint import pprint
import jinja2

env = jinja2.Environment(
    loader=jinja2.FileSystemLoader('templates'),
    autoescape=jinja2.select_autoescape(['xmi'])
)

configuration = {
    'window_size': 10,
    'window_shift': 10,
}


def render_usage_model_indirections(entries):
    return env.get_template('usage_model_indirections.xmi').render(entries=entries)


def create_indirections_usagemodel(abstract_representation, configuration):
    usage_scenarios = []

    for house in abstract_representation:
        house_id = house['house_id']

        for pid, plug_data in house['pmf_iat_per_plug'].items():
            usage_scenario = {
                'pid': pid,
                'plugId': plug_data['plug_id'],
                'houseId': house_id,
                'interarrivalTime': plug_data['iat']
            }
            usage_scenarios.append(usage_scenario)

    print(f"{len(usage_scenarios)} scenarios")
    with open('./out/generated_indirections.usagemodel', 'w') as f:
        f.write(render_usage_model_indirections(usage_scenarios))


def render_usage_model_baseline(entries):
    return env.get_template('usage_model_baseline.xmi').render(entries=entries)


def create_baseline_usagemodel(abstract_representation, configuration):
    window_size = configuration['window_size']
    window_shift = configuration['window_shift']

    usage_scenarios = []

    for house in abstract_representation:
        data_per_window = (window_size / house['average_iat']) * house['plug_ids']

        usage_scenario = {
            'house_id': house['house_id'],
            'interarrivaltime': window_shift,
            'data_per_window': data_per_window,
            'window_size': window_size,
            'number_of_elements_distribution': house['number_of_elements_distribution']
        }

        usage_scenarios.append(usage_scenario)

    print(f"{len(usage_scenarios)} scenarios")
    with open('./out/generated_baseline.usagemodel', 'w') as f:
        f.write(render_usage_model_baseline(usage_scenarios))


if __name__ == '__main__':
    with open('out/abstract_representation.json', 'r') as in_file:
        abstract_representation = json.load(in_file)

    print("--- indirections ---")
    create_indirections_usagemodel(abstract_representation, configuration)

    print("--- baseline ---")
    create_baseline_usagemodel(abstract_representation, configuration)
