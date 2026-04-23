package university.core;

import university.academic.Course;
import university.academic.Enrollment;
import university.enums.TeacherTitle;
import university.interfaces.Messageable;
import university.interfaces.Ratable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teacher extends Employee implements Ratable, Messageable {
    private TeacherTitle title;
    private double rating;
    private final List<Course> assignedCourses = new ArrayList<>();
    private final List<String> inbox = new ArrayList<>();

    public Teacher(String id, String login, String password, String firstName, String lastName, double salary,
                   TeacherTitle title) {
        super(id, login, password, firstName, lastName, salary);
        this.title = title;
    }

    public List<Course> viewAssignedCourses() {
        return Collections.unmodifiableList(assignedCourses);
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            course.addTeacher(this);
        }
    }

    public void enterGrades(Enrollment enrollment, double att1, double att2, double finalExam) {
        enrollment.setAtt1(att1);
        enrollment.setAtt2(att2);
        enrollment.setFinalExam(finalExam);
    }

    public List<Student> viewStudents(Course course) {
        List<Student> students = new ArrayList<>();
        for (Enrollment enrollment : courseEnrollments(course)) {
            students.add(enrollment.getStudent());
        }
        return students;
    }

    private List<Enrollment> courseEnrollments(Course course) {
        List<Enrollment> result = new ArrayList<>();
        for (Student student : UniversityStorage.getStudents()) {
            for (Enrollment enrollment : student.getEnrollments()) {
                if (enrollment.getCourse().equals(course)) {
                    result.add(enrollment);
                }
            }
        }
        return result;
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void setRating(double value) {
        if (value < 0 || value > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.rating = value;
    }

    @Override
    public void sendMessage(String text) {
        inbox.add("Teacher message from " + getFullName() + ": " + text);
    }

    @Override
    public List<String> viewInbox() {
        return Collections.unmodifiableList(inbox);
    }
}
