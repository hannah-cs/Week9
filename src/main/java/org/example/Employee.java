package org.example;

import java.util.HashSet;

public class Employee {
    private String name;
    private int id;
    private String department;
    private String jobTitle;
    private int managerId;

    public Employee(String name, int id, String department, String jobTitle, int managerId) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.managerId = managerId;
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

    public Employee() {
    }

    private static HashSet<Employee> employees = new HashSet<>();

    @Override
    public String toString(){
        return "Employee "+id+": "+name+" - "+jobTitle+" in "+department+" department. Reports to "+managerId;
    }

    public void search(HashSet<Employee> employees, String searchTerm){
        HashSet<Employee> searchResults = new HashSet<>();
        for (Employee e : employees){
            if (e.getName().contains(searchTerm)){
                searchResults.add(e);
            }
            if (e.getId() == Integer.parseInt(searchTerm)){
                searchResults.add(e);
            }
            if (e.getDepartment().contains(searchTerm)){
                searchResults.add(e);
            }
            if (e.getJobTitle().contains(searchTerm)){
                searchResults.add(e);
            }
            if (e.getManagerId() == Integer.parseInt(searchTerm)){
                searchResults.add(e);
            }
        }
        System.out.println("Search results: "+searchResults);
    }
}