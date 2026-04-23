package university.core;

import university.academic.Course;
import university.academic.Enrollment;
import university.enums.StudentYear;
import university.interfaces.Messageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends User implements Messageable {
    private String firstName;
    private String lastName;
    private double gpa;
    private StudentYear year;
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final List<String> inbox = new ArrayList<>();

    public Student(String id, String login, String password, String firstName, String lastName, double gpa, StudentYear year) {
        super(id, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.year = year;
    }

    public Enrollment registerCourse(Course course) {
        Enrollment enrollment = new Enrollment(this, course);
        enrollments.add(enrollment);
        return enrollment;
    }

    public List<Enrollment> viewTranscript() {
        return Collections.unmodifiableList(enrollments);
    }

    public List<Double> viewGrades() {
        List<Double> grades = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            grades.add(enrollment.getTotal());
        }
        return grades;
    }

    public void rateTeacher(Teacher teacher, double value) {
        teacher.setRating(value);
    }

    @Override
    public void sendMessage(String text) {
        inbox.add("Sent by student " + getFullName() + ": " + text);
    }

    @Override
    public List<String> viewInbox() {
        return Collections.unmodifiableList(inbox);
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public StudentYear getYear() {
        return year;
    }

    public void setYear(StudentYear year) {
        this.year = year;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }
}
