package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("Ann", 001, "Finance", "Accountant", 123));
        employees.add(new Employee("Bob", 002, "HR", "Recruiter", 234));
        employees.add(new Employee("Sam", 003, "Sales", "Sales rep", 345));
        System.out.println(employees);

        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println(employeeMap);

        // CRUD operations:
        Employee newEmployee = new Employee("Liz", 004, "Finance", "CTO", 567);
        employees.add(newEmployee);
        // Create
        employeeMap.put(004, newEmployee);
        System.out.println(employeeMap);
        // Retrieve
        System.out.println(employeeMap.get(004));
        // Update
        newEmployee.setName("Elizabeth");
        System.out.println(employeeMap);
        // Delete
        employeeMap.remove(004);
        System.out.println(employeeMap);

        // Search by department
        searchDept("Finance", employees);

        //dept report
        departmentReport(employees);
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

    public static void departmentReport(Set<Employee> employees) {
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

}