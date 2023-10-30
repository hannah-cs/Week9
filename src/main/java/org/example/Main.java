package org.example;
import java.util.HashSet;
import java.util.HashMap;

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
    }
}