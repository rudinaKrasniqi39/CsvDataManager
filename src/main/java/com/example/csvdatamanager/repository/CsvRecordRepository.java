package main.java.com.example.csvdatamanager.repository;

import main.java.com.example.csvdatamanager.model.CsvRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRecordRepository extends JpaRepository<CsvRecord, String> {
}
