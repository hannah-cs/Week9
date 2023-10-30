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

        //CRUD operations:
        Employee newEmployee = new Employee("Liz", 004, "Customer Support", "Support rep", 567);
        //create
        employeeMap.put(004, newEmployee);
        System.out.println(employeeMap);
        //retrieve
        System.out.println(employeeMap.get(004));
        //update
        newEmployee.setName("Elizabeth");
        System.out.println(employeeMap);
        //delete
        employeeMap.remove(004);
        System.out.println(employeeMap);
    }
}