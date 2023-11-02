package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void searchDept(String searchTerm, HashSet<Employee> employees) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().contains(searchTerm)) {
                searchResults.add(e);
            }
        }
        System.out.println("Results: " + searchResults);
    }
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();
        Employee employee001 = new Employee("Ann", 001, "Finance", "Accountant", 004, "2018-10-03", 75000);
        Employee employee002 = new Employee("Bob", 002, "HR", "Recruiter", 432, "2020-04-06", 60000);
        Employee employee003 = new Employee("Sam", 003, "Sales", "Sales rep", 328, "2023-08-04", 45000);
        Employee ceoEmployee = new Employee("Marie", 1, "CEO", "CEO", 1, "2015-07-01", 400000);
        Employee ctoEmployee = new Employee("Liz", 4, "Finance", "CTO", 1, "2017-05-03", 100000);
        Employee hrHeadEmployee = new Employee("Tom", 432, "HR", "Head of HR", 1, "2022-09-08", 90000);
        Employee salesDirectorEmployee = new Employee("Frank", 328, "Sales", "Sales Director", 1, "2016-03-14", 150000);

        employees.add(employee001);
        employees.add(employee002);
        employees.add(employee003);
        employees.add(ceoEmployee);
        employees.add(ctoEmployee);
        employees.add(hrHeadEmployee);
        employees.add(salesDirectorEmployee);

        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        EmployeeNode ceo = new EmployeeNode(ceoEmployee);
        EmployeeNode manager1 = new EmployeeNode(ctoEmployee);
        EmployeeNode manager2 = new EmployeeNode(hrHeadEmployee);
        EmployeeNode manager3 = new EmployeeNode(salesDirectorEmployee);
        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        ceo.addSubordinate(manager3);
        manager1.addSubordinate(new EmployeeNode(employee001));
        manager2.addSubordinate(new EmployeeNode(employee002));
        manager3.addSubordinate(new EmployeeNode(employee003));

        ReportGenerator reportGenerator = new ReportGenerator();
        System.out.println(reportGenerator.generateDepartmentReport(employees));
        System.out.println(reportGenerator.generateEmployeeReport(employees));
        System.out.println(reportGenerator.generateHierarchyReport(ceo, 0));
    }
}