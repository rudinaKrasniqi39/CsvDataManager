package com.example.csvdatamanager.repository;

import com.example.csvdatamanager.model.CsvRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRecordRepository extends JpaRepository<CsvRecord, String> {
}
