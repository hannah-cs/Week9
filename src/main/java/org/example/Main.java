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
        employees.add(new Employee("Ann", 001, "Finance", "Accountant", 004, "2018-10-03", 75000));
        employees.add(new Employee("Bob", 002, "HR", "Recruiter", 432, "2020-04-06", 60000));
        employees.add(new Employee("Sam", 003, "Sales", "Sales rep", 328, "2023-08-04", 45000));
        System.out.println(employees);

        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println(employeeMap);

        // CRUD operations:
        Employee newEmployee = new Employee("Liz", 004, "Finance", "CTO", 1, "2017-05-03", 100000);
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

        // organisational tree
        EmployeeNode ceo = new EmployeeNode(new Employee("Marie", 1, "Leadership", "CEO", 1, "2015-07-01", 400000));
        EmployeeNode manager1 = new EmployeeNode(new Employee("Liz", 4, "Finance", "CTO", 1, "2017-05-03", 100000));
        EmployeeNode manager2 = new EmployeeNode(new Employee("Tom", 432, "HR", "Head of HR", 1,  "2022-09-08", 90000));
        EmployeeNode manager3 = new EmployeeNode(new Employee("Frank", 328, "Sales", "Sales Director", 1, "2016-03-14", 150000));
        EmployeeNode employee001 = new EmployeeNode(employeeMap.get(1));
        EmployeeNode employee002 = new EmployeeNode(employeeMap.get(2));
        EmployeeNode employee003 = new EmployeeNode(employeeMap.get(3));

        // Build the organization hierarchy
        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        ceo.addSubordinate(manager3);
        manager1.addSubordinate(employee001);
        manager2.addSubordinate(employee002);
        manager3.addSubordinate(employee003);
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