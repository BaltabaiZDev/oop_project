package university.core;

public abstract class Employee extends User {
    private String firstName;
    private String lastName;
    private double salary;

    protected Employee(String id, String login, String password, String firstName, String lastName, double salary) {
        super(id, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
