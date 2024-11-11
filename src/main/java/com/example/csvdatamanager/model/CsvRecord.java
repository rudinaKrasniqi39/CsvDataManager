package com.example.csvdatamanager.model;

import java.util.Date;

public class CsvRecord {
    private String code;
    private String source;
    private String codeListCode;
    private String displayValue;
    private String longDescription;
    private Date fromDate;
    private Date toDate;
    private int sortingPriority;

    public  CsvRecord(){}

    public CsvRecord(String code, String source, String codeListCode, String displayValue, String longDescription, Date fromDate, Date toDate, int sortingPriority) {
        this.code = code;
        this.source = source;
        this.codeListCode = codeListCode;
        this.displayValue = displayValue;
        this.longDescription = longDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.sortingPriority = sortingPriority;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(int sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}