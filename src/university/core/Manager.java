package university.core;

import university.academic.Course;
import university.academic.Enrollment;
import university.enums.EnrollmentStatus;
import university.enums.ManagerType;
import university.interfaces.Messageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Employee implements Messageable {
    private ManagerType type;
    private final List<Course> managedCourses = new ArrayList<>();
    private final List<String> news = new ArrayList<>();
    private final List<String> inbox = new ArrayList<>();

    public Manager(String id, String login, String password, String firstName, String lastName, double salary,
                   ManagerType type) {
        super(id, login, password, firstName, lastName, salary);
        this.type = type;
    }

    public Course createCourse(String courseId, String name, int credits, String description) {
        Course course = new Course(courseId, name, credits, description);
        managedCourses.add(course);
        return course;
    }

    public void manageCourseContent(Course course, String newDescription) {
        course.setDescription(newDescription);
        if (!managedCourses.contains(course)) {
            managedCourses.add(course);
        }
    }

    public void assignTeacher(Course course, Teacher teacher) {
        teacher.assignCourse(course);
        if (!managedCourses.contains(course)) {
            managedCourses.add(course);
        }
    }

    public void approveRegistration(Enrollment enrollment) {
        enrollment.setStatus(EnrollmentStatus.APPROVED);
    }

    public String createAcademicReport() {
        int courseCount = managedCourses.size();
        int approvedEnrollments = 0;
        for (Student student : UniversityStorage.getStudents()) {
            for (Enrollment enrollment : student.getEnrollments()) {
                if (enrollment.getStatus() == EnrollmentStatus.APPROVED) {
                    approvedEnrollments++;
                }
            }
        }
        return "Academic report: courses=" + courseCount + ", approvedEnrollments=" + approvedEnrollments;
    }

    public void manageNews(String text) {
        news.add(text);
    }

    public List<String> viewEmployeeRequests() {
        return List.of("Vacation request", "Schedule change request");
    }

    public ManagerType getType() {
        return type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public List<Course> getManagedCourses() {
        return Collections.unmodifiableList(managedCourses);
    }

    public List<String> getNews() {
        return Collections.unmodifiableList(news);
    }

    @Override
    public void sendMessage(String text) {
        inbox.add("Manager message from " + getFullName() + ": " + text);
    }

    @Override
    public List<String> viewInbox() {
        return Collections.unmodifiableList(inbox);
    }
}
