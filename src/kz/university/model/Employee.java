package kz.university.model;

import kz.university.enums.UserRole;

public abstract class Employee extends User {
    private String firstName;
    private String lastName;
    private double salary;

    protected Employee(String id, String login, String password, UserRole role,
                       String firstName, String lastName, double salary) {
        super(id, login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
