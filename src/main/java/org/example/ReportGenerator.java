package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReportGenerator implements Report{
    private EmployeeNode ceoNode;
    private ReportType reportType;

    public ReportGenerator(ReportType reportType) {
        this.reportType = reportType;
    }

    public ReportGenerator(){}

    @Override
    public String generateReport(Set<Employee> employees) {
        switch (reportType) {
            case EMPLOYEE:
                return generateEmployeeReport(employees);
            case DEPARTMENT:
                return generateDepartmentReport(employees);
            case HIERARCHY:
                return generateHierarchyReport(ceoNode, 0);
            default:
                return "Invalid report type";
        }
    }

    public String generateDepartmentReport(Set<Employee> employees) {
        Map<String, Integer> deptCount = new HashMap<>();
        for (Employee e : employees) {
            String dept = e.getDepartment();
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }

        StringBuilder result = new StringBuilder("Employees per Department:\n");
        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    public String generateEmployeeReport(Set<Employee> employees) {
        StringBuilder result = new StringBuilder("All employees:\n");
        for (Employee employee : employees) {
            result.append(employee.toString()).append("\n");
        }
        return result.toString();
    }

    public String generateHierarchyReport(EmployeeNode ceoNode, int level) {
        StringBuilder report = new StringBuilder();
        if (ceoNode != null) {
            Employee employee = ceoNode.getEmployee();
            report.append("  ".repeat(level))
                    .append(employee.getName())
                    .append(" - ")
                    .append(employee.getJobTitle())
                    .append(", ")
                    .append(employee.getDepartment())
                    .append("\n");

            for (EmployeeNode subordinate : ceoNode.getSubordinates()) {
                report.append(generateHierarchyReport(subordinate, level + 1));
            }
        }
        return report.toString();
    }
}