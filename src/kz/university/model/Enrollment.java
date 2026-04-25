package kz.university.model;

import java.io.Serializable;
import kz.university.enums.EnrollmentStatus;

public class Enrollment implements Serializable {
    private EnrollmentStatus status;
    private Student student;
    private Course course;
    private Mark mark;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.status = EnrollmentStatus.PENDING;
    }

    public void approve() {
        status = EnrollmentStatus.APPROVED;
    }

    public void complete() {
        status = mark != null && mark.isPassed()
                ? EnrollmentStatus.COMPLETED
                : EnrollmentStatus.FAILED;
    }

    public double getTotal() {
        return mark == null ? 0 : mark.getTotal();
    }

    public void setMark(Mark mark) {
        this.mark = mark;
        complete();
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return student.getFullName() + " -> " + course.getName() + " | " + status + " | total=" + getTotal();
    }
}
