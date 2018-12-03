package edu.kit.ipd.are.smarthomedata.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading;
import edu.kit.ipd.are.smarthomedata.dto.SmartMeterReading.ReadingType;


// CSV --> t: readings
public class AppCsvProducer {
	public static void main(String[] args) {
		System.out.println("Starting CsvProducer");
		CloseableProducer<SmartMeterReading> smrProducer = KafkaConnection
				.getProducerForTopic(Constants.SMART_METER_READINGS_TOPIC, SmartMeterReading::serialize);


		long startTime = System.currentTimeMillis() / 1000L;
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("id,timestamp,value,property,plug_id,household_id,house_id")) {
					continue;
				}
				
				SmartMeterReading smr = SmartMeterReading.fromCsvString(line);
				
				if (smr.property != ReadingType.LOAD) {
					continue;
				}
				while ((System.currentTimeMillis() / 1000L) - startTime < smr.timestamp) {
					System.out.println("Waiting for " + smr.timestamp + ", currently at " + ((System.currentTimeMillis() / 1000L) - startTime));
					Thread.sleep(1000L);
				}
				smr.origin = System.currentTimeMillis();

				smrProducer.accept(smr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		} catch (IOException e) {
			e.printStackTrace(System.out);
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
	}}