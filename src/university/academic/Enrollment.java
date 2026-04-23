package university.academic;

import university.core.Student;
import university.enums.EnrollmentStatus;

public class Enrollment {
    private final Student student;
    private final Course course;
    private EnrollmentStatus status;
    private double att1;
    private double att2;
    private double finalExam;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.status = EnrollmentStatus.PENDING;
    }

    public double getTotal() {
        return att1 + att2 + finalExam;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public double getAtt1() {
        return att1;
    }

    public void setAtt1(double att1) {
        this.att1 = att1;
    }

    public double getAtt2() {
        return att2;
    }

    public void setAtt2(double att2) {
        this.att2 = att2;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student.getFullName() +
                ", course=" + course.getName() +
                ", status=" + status +
                ", total=" + getTotal() +
                '}';
    }
}
