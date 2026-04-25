package kz.university.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.university.enums.StudentYear;

public class Course implements Serializable {
    private String courseId;
    private String name;
    private int credits;
    private String major;
    private StudentYear targetYear;
    private List<Lesson> lessons = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(String courseId, String name, int credits, String major, StudentYear targetYear) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.major = major;
        this.targetYear = targetYear;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            teacher.addCourse(this);
        }
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Teacher> getTeachers() {
        return Collections.unmodifiableList(teachers);
    }

    public List<Lesson> getLessons() {
        return Collections.unmodifiableList(lessons);
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getMajor() {
        return major;
    }

    public StudentYear getTargetYear() {
        return targetYear;
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits, " + major + ", " + targetYear + ")";
    }
}
