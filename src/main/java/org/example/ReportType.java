package org.example;

public enum ReportType {
    EMPLOYEE("Employee report"), DEPARTMENT("Department report"), HIERARCHY("Hierarchy report");
    private final String displayName;
    ReportType(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}