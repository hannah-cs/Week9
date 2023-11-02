package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Employee {
    private String name;
    private int id;
    private String department;
    private String jobTitle;
    private int managerId;
    private Date hireDate;
    private int salary;

    public Employee(String name, int id, String department, String jobTitle, int managerId, String hireDateString, int salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
        this.salary = salary;
        try {
            this.hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {
    }
    private static HashSet<Employee> employees = new HashSet<>();

    @Override
    public String toString(){
        return "Employee "+id+": "+name+" - "+jobTitle+" in "+department+" department. Reports to "+managerId+". Hired on "+hireDate+" annual salary €"+salary;
    }
}

class EmployeeNode {
    private Employee employee;
    private EmployeeNode manager;
    private List<EmployeeNode> subordinates;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
        this.manager = null;
        this.subordinates = new ArrayList<>();
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getManager() {
        return manager;
    }

    public List<EmployeeNode> getSubordinates() {
        return subordinates;
    }

    public void setManager(EmployeeNode manager) {
        this.manager = manager;
    }

    public void addSubordinate(EmployeeNode subordinate) {
        subordinates.add(subordinate);
        subordinate.setManager(this);
    }
}