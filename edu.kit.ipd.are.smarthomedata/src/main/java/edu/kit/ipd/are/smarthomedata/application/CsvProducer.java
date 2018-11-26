package edu.kit.ipd.are.smarthomedata.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.kit.ipd.are.smarthomedata.analysis.EmitOnChangeFilter;
import edu.kit.ipd.are.smarthomedata.analysis.MedianAllPlugs;
import edu.kit.ipd.are.smarthomedata.analysis.OutlierCalculation;
import edu.kit.ipd.are.smarthomedata.analysis.PlugMedianProcessor;
import edu.kit.ipd.are.smarthomedata.dto.PlugIdentifier;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;

public class CsvProducer {
//	private static final String IN_FILE = "C:\\work\\docker\\ten_minutes.csv";
	private static final String IN_FILE = "C:\\work\\docker\\one_hour_mittags.csv";
	// id,timestamp,value,property,plug_id,household_id,house_id
	// 0 id
	// 1 timestamp
	// 2 value
	// 3 property (1 = load)
	// 4 plug_id
	// 5 household_id
	// 6 house_id

//	private static final long PLUG_ID = 10L;
//	private static final long HOUSEHOLD_ID = 2L;
	private static final long HOUSE_ID = 7L;
	private static final long HOUSEHOLD_ID = 10L;
	private static final long PLUG_ID = 1L;

	public static void main(String[] args) {
		var eocf = new EmitOnChangeFilter(System.out::println);
		
		OutlierCalculation oc = new OutlierCalculation(eocf);
		MedianAllPlugs map = new MedianAllPlugs(oc);
/*		MedianAllPlugs map = new MedianAllPlugs(it -> {
			if (it.value != 0.f) {
				System.out.println(it);
			}
		});*/

		PlugIdentifier pi = new PlugIdentifier(PLUG_ID, HOUSEHOLD_ID, HOUSE_ID);
		PlugMedianProcessor pmp = new PlugMedianProcessor((it) -> true, 360, 10, map.andThen(oc));
//		PlugMedianProcessor pmp = new PlugMedianProcessor((it) -> it.houseId == HOUSE_ID, 1000, 1000, System.out::println);
//		PlugMedianProcessor pmp = new PlugMedianProcessor(pi::equals, 1, 1, null);

		Long timestamp = 0L;
		
		try (BufferedReader br = new BufferedReader(new FileReader(IN_FILE))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("id,timestamp,value,property,plug_id,household_id,house_id")) {
					continue;
				}

				SmartMeterReading smr = SmartMeterReading.fromCsvString(line);
				if (smr.property != ReadingType.LOAD) {
					continue;
				}
				if (smr.timestamp != timestamp) {
//					System.out.println("NEW TIMESTAMP: " + smr.timestamp + " (was " + timestamp + ")");
					timestamp = smr.timestamp;
				}
				pmp.accept(smr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}