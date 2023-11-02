package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
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
    public interface Report {
        String generateReport(Set<Employee> employees);
    }

    public static void searchDept(String searchTerm, HashSet<Employee> employees) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().contains(searchTerm)) {
                searchResults.add(e);
            }
        }
        System.out.println("Results: " + searchResults);
    }

    public static void generateDepartmentReport(Set<Employee> employees) {
        Map<String, Integer> deptCount = new HashMap<>();
        for (Employee e : employees) {
            String dept = e.getDepartment();
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }
        System.out.println("Employees per Department:");
        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void generateEmployeeReport(Set<Employee> employees) {
        System.out.println("All employees:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());;
        }
    }

    public static void generateHierarchyReport(EmployeeNode ceo) {
        System.out.println("Hierarchy Report:");
        printHierarchy(ceo, 0);
    }

    public static void printHierarchy(EmployeeNode node, int level) {
        if (node != null) {
            Employee employee = node.getEmployee();
            System.out.println("  ".repeat(level) + employee.getName() + " - " + employee.getDepartment());

            for (EmployeeNode subordinate : node.getSubordinates()) {
                printHierarchy(subordinate, level + 1);
            }
        }
    }

    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();
        Employee employee001 = new Employee("Ann", 001, "Finance", "Accountant", 004, "2018-10-03", 75000);
        Employee employee002 = new Employee("Bob", 002, "HR", "Recruiter", 432, "2020-04-06", 60000);
        Employee employee003 = new Employee("Sam", 003, "Sales", "Sales rep", 328, "2023-08-04", 45000);
        Employee ceoEmployee = new Employee("Marie", 1, "Leadership", "CEO", 1, "2015-07-01", 400000);
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

        generateDepartmentReport(employees);
        generateEmployeeReport(employees);
        generateHierarchyReport(ceo);
    }
}