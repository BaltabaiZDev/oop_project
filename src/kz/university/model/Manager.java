package kz.university.model;

import java.util.ArrayList;
import java.util.List;
import kz.university.enums.ManagerType;
import kz.university.enums.UserRole;
import kz.university.interfaces.Messageable;

public class Manager extends Employee implements Messageable {
    private ManagerType type;
    private List<Course> managedCourses = new ArrayList<>();

    public Manager(String id, String login, String password, String firstName, String lastName,
                   double salary, ManagerType type) {
        super(id, login, password, UserRole.MANAGER, firstName, lastName, salary);
        this.type = type;
    }

    public void approveRegistration(Enrollment enrollment) {
        enrollment.approve();
    }

    public void addCourseForRegistration(Course course) {
        if (!managedCourses.contains(course)) {
            managedCourses.add(course);
        }
    }

    public void assignTeacher(Course course, Teacher teacher) {
        course.addTeacher(teacher);
    }

    public AcademicReport createAcademicReport() {
        List<Enrollment> all = new ArrayList<>();
        for (Course course : managedCourses) {
            all.addAll(course.getEnrollments());
        }
        AcademicReport report = new AcademicReport();
        report.generate(all);
        return report;
    }

    public void manageNews(News news) {
        news.publish();
    }

    public ManagerType getType() {
        return type;
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("Manager message: " + text);
    }

    @Override
    public void viewInbox() {
        System.out.println("Manager inbox is empty");
    }
}
