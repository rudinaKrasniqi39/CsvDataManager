package main.java.com.example.csvdatamanager.service;

import main.java.com.example.csvdatamanager.exception.CsvRecordNotFoundException;
import main.java.com.example.csvdatamanager.model.CsvRecord;
import main.java.com.example.csvdatamanager.repository.CsvRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvService {
	private final CsvRecordRepository csvRecordRepository;

	public CsvService(CsvRecordRepository csvRecordRepository) {
		this.csvRecordRepository = csvRecordRepository;
	}

	public void uploadData(MultipartFile file) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
			List<CsvRecord> records = reader.lines()
					.skip(1)
					.map(line -> line.split(","))
					.map(data -> {
						CsvRecord record = new CsvRecord();
						record.setCode(data[0]);
						record.setName(data[1]);
						record.setDescription(data[2]);
						record.setDate(data[3]);
						return record;
					})
					.collect(Collectors.toList());

			csvRecordRepository.saveAll(records);
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
		}
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
