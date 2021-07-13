import sys

import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression
from glob import glob


def collect_data(folders, csv_filename, column_name_x, column_name_y):
    df = None
    for f in folders:
        print(f"Parsing {f}\\{csv_filename}")
        nextdata = pd.read_csv(f"{f}\\{csv_filename}",
                               sep=";",
                               usecols=[column_name_x, column_name_y],
                               dtype={column_name_x: 'Int64',
                                      column_name_y: 'Int64'})
        if df is None:
            df = nextdata
        else:
            df = df.append(nextdata)

    return df


def linear_regression(folders, filename, column_name_x, column_name_y):
    data = collect_data(folders, filename, column_name_x, column_name_y)

    X, y = np.array(data[column_name_x]).reshape(-1, 1), data[column_name_y]

    model = LinearRegression()
    model.fit(X, y)

    return model


def fit_models(folders):
    each_plug_model = linear_regression(folders, "each-plug-aggregated.csv", "Number of Elements", "Diff (ms)")
    all_plugs_model = linear_regression(folders, "all-plugs.csv", "Number of Values", "Diff (ms)")
    outlier_model = linear_regression(folders, "outlier.csv", "Overall Reading Count", "Diff (ms)")

    return each_plug_model, all_plugs_model, outlier_model


def format_model(model, variable_name):
    return f"{model.intercept_:.2f} + {model.coef_[0]:.2f} * {variable_name}"


base_folders = [
    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_135807",
    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_140503",
    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_142910",
    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_143546",
    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_144443",
#    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_145002",
#    r"C:\Work\git\ICPE\Palladio-Addons-Indirections-Example-ICPE\docker\out\2021-06-29_145551"
]

if (__name__ == '__main__') and not sys.flags.inspect:
    if len(sys.argv) <= 1:
        folders = base_folders
        print("No folders provided, using:")
        for f in base_folders:
            print(f"  {f}")
        print()
    else:
        folders = sys.argv[1:]

    ep, ap, ol = fit_models(folders)

    print()

    ep_f = format_model(ep, "partitionedReadingWindows.INNER_ELEMENTS.NUMBER_OF_ELEMENTS")
    ep_bl_f = format_model(ep, "readings.NUMBER_OF_ELEMENTS")
    print(f"each-plug-aggregated:")
    print(f"    smarthomedata.repository:")
    print(f"        MedianEachPlug.partitionedReadingWindows.IA: Max({ep_f}, 0.0)")
    print(f"    baseline.repository:")
    print(f"        MedianEachPlug.acceptPartitionedReadingWindows.IA: Max({ep_bl_f}, 0.0)")
    print()

    ap_f = format_model(ap, "medianWindow.INNER_ELEMENTS.NUMBER_OF_ELEMENTS")
    ap_bl_f = format_model(ap, "readings.NUMBER_OF_ELEMENTS")
    print(f"all-plugs:")
    print(f"    smarthomedata.repository:")
    print(f"        AverageAllMedians.medianWindow.IA: Max({ap_f}, 0.0)")
    print(f"    baseline.repository:")
    print(f"        AverageAllMedians.acceptMedianWindow.IA: Max({ap_bl_f}, 0.0)")
    print()

    ol_f = format_model(ol, "averageAndHouseMedian.medianWindowPerHouse.INNER_ELEMENTS.NUMBER_OF_ELEMENTS")
    ol_f_group = format_model(ol, "averageAndHouseMedianGroup.medianWindowPerHouseGroup.INNER_ELEMENTS.NUMBER_OF_ELEMENTS")
    ol_bl_f = format_model(ol, "readings.NUMBER_OF_ELEMENTS")
    print(f"outlier:")
    print(f"    smarthomedata.repository:")
    print(f"        OutlierCalculation.averageAndHouseMedian.IA: Max({ol_f}, 0.0)")
    print(f"        OutlierCalculationFromGroup.averageAndHouseMedianGroup.IA: Max({ol_f_group}, 0.0)")
    print(f"    baseline.repository:")
    print(f"        OutlierCalculation.acceptAverageAndHouseMedianGroup.IA: Max({ol_bl_f}, 0.0)")
    print(f"        OutlierCalculation.acceptMedianWindowPerHouse.IA: Max({ol_bl_f}, 0.0)")
