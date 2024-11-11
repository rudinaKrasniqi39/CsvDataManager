package com.example.csvdatamanager.service;

import com.example.csvdatamanager.exception.CsvRecordNotFoundException;
import com.example.csvdatamanager.model.CsvRecord;
import com.example.csvdatamanager.repository.CsvRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CsvService {
	private final CsvRecordRepository csvRecordRepository;
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);

	public CsvService(CsvRecordRepository csvRecordRepository) {
		this.csvRecordRepository = csvRecordRepository;
	}

	public void uploadData(MultipartFile file) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
			List<CsvRecord> records = reader.lines()
					.skip(1)
					.map(line -> {
						String[] data = line.split(",");
						CsvRecord record = new CsvRecord();
						record.setSource(removeQutationsFromString(data[0]));
						record.setCodeListCode(removeQutationsFromString(data[1]));
						record.setCode(removeQutationsFromString(data[2]));
						record.setDisplayValue(removeQutationsFromString(data[3]));
						record.setLongDescription(removeQutationsFromString(data[4]));
						record.setFromDate(convertDateFromCsv(removeQutationsFromString(data[5])));
						record.setToDate(convertDateFromCsv(removeQutationsFromString(data[6])));
						record.setSortingPriority(convertToIntFromCsv(removeQutationsFromString(data[7])));
						return record;
					})
					.collect(Collectors.toList());

			csvRecordRepository.saveAll(records);
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
		}
	}

	private String removeQutationsFromString(String str){
		return  str.replace("\"", "");
	}
	private Date convertDateFromCsv(String csvValue){
        try {
			if(csvValue != null && !csvValue.isEmpty()){
				return formatter.parse(csvValue);
			}
            return null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

	private int convertToIntFromCsv(String csvValue){
		if(csvValue != null && !csvValue.isEmpty()) {
			return Integer.parseInt(csvValue);
		}
		return 0;
	}

	public List<CsvRecord> getAllRecords() {
		return csvRecordRepository.findAll();
	}

	public CsvRecord getRecordByCode(String code) {
		return csvRecordRepository.findById(code)
				.orElseThrow(() -> new CsvRecordNotFoundException("Record not found for code: " + code));
	}

	public void deleteAllRecords() {
		csvRecordRepository.deleteAll();
	}
}