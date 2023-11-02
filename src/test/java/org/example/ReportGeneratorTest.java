package org.example;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class ReportGeneratorTest {
    @Test
    public void testGenerateReport() {
       // testGenerateReport();
    }

    @Test
    public void testGenerateDepartmentReport() {
        ReportGenerator reportGenerator = new ReportGenerator();
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Employee", 1, "Dept", "Job", 002, "2018-10-03", 1000));
        employees.add(new Employee("Employee 2", 2, "Dept", "Job", 002, "2018-10-03", 1000));

        String report = reportGenerator.generateDepartmentReport(employees);
        String expectedResult = "Employees per Department:\n"+"Dept: 2\n";
        assertEquals(expectedResult, report);
    }

    @Test
    public void testGenerateEmployeeReport() {
        ReportGenerator reportGenerator = new ReportGenerator();
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Employee", 1, "Dept", "Job", 2, "2018-10-03", 1000));
        employees.add(new Employee("Employee 2", 2, "Dept", "Job", 2, "2018-10-03", 1000));

        String report = reportGenerator.generateEmployeeReport(employees);
        String expectedResult = "All employees:\n"+
                "Employee 1: Employee - Job in Dept department. Reports to 2. Hired on Wed Oct 03 00:00:00 CEST 2018 annual salary €1000\n"+
                "Employee 2: Employee 2 - Job in Dept department. Reports to 2. Hired on Wed Oct 03 00:00:00 CEST 2018 annual salary €1000\n";
        assertEquals(expectedResult, report);
    }

    @Test
    public void testGenerateHierarchyReport() {
        ReportGenerator reportGenerator = new ReportGenerator();
        Set<Employee> employees = new HashSet<>();
        Employee employee1 = new Employee("Employee", 1, "Dept", "Job", 2, "2018-10-03", 1000);
        Employee employee2 = new Employee("Employee 2", 2, "Dept", "Job", 2, "2018-10-03", 1000);
        employees.add(employee1);
        employees.add(employee2);

        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        EmployeeNode emp = new EmployeeNode(employee1);
        EmployeeNode emp2 = new EmployeeNode(employee2);

        emp.addSubordinate(emp2);

        String report = reportGenerator.generateHierarchyReport(emp, 0);
        String expectedResult = "Employee - Job, Dept\n"+"Employee 2 - Job, Dept";
    }
}