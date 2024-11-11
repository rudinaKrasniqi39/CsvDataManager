package com.example.csvdatamanager.controller;

import com.example.csvdatamanager.model.CsvRecord;
import com.example.csvdatamanager.service.CsvService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class CsvController {
    private final CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) {
        csvService.uploadData(file);
        return ResponseEntity.ok("Data uploaded successfully");
    }

    @GetMapping("/records")
    public List<CsvRecord> getAllRecords() {
        return csvService.getAllRecords();
    }

    @GetMapping("/record/{code}")
    public CsvRecord getRecordByCode(@PathVariable String code) {
        return csvService.getRecordByCode(code);
    }

    @DeleteMapping("/records")
    public ResponseEntity<String> deleteAllRecords() {
        csvService.deleteAllRecords();
        return ResponseEntity.ok("All records deleted successfully");
    }
}