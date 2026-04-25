package kz.university.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.university.enums.TeacherTitle;
import kz.university.enums.UserRole;
import kz.university.interfaces.Messageable;
import kz.university.interfaces.PaperComparator;
import kz.university.interfaces.Ratable;
import kz.university.interfaces.Researcher;

public class Teacher extends Employee implements Ratable, Messageable, Researcher {
    private TeacherTitle title;
    private double rating;
    private List<Course> courses = new ArrayList<>();
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();
    private int hIndex;

    public Teacher(String id, String login, String password, String firstName, String lastName,
                   double salary, TeacherTitle title, int hIndex) {
        super(id, login, password, UserRole.TEACHER, firstName, lastName, salary);
        this.title = title;
        this.hIndex = title == TeacherTitle.PROFESSOR && hIndex < 3 ? 3 : hIndex;
    }

    public List<Course> viewCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void manageCourse(Course course) {
        System.out.println(getFullName() + " manages course: " + course.getName());
    }

    public void putMark(Enrollment enrollment, Mark mark) {
        enrollment.setMark(mark);
        System.out.println("Mark was put: " + mark);
    }

    public List<Student> viewStudents(Course course) {
        List<Student> students = new ArrayList<>();
        for (Enrollment e : course.getEnrollments()) {
            students.add(e.getStudent());
        }
        return students;
    }

    public TeacherTitle getTitle() {
        return title;
    }

    public boolean isProfessor() {
        return title == TeacherTitle.PROFESSOR;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void setRating(double value) {
        this.rating = value;
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("Teacher message: " + text);
    }

    @Override
    public void viewInbox() {
        System.out.println("Teacher inbox is empty");
    }

    @Override
    public int getHIndex() {
        return hIndex;
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return Collections.unmodifiableList(researchPapers);
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return Collections.unmodifiableList(researchProjects);
    }

    @Override
    public void publishPaper(ResearchPaper paper) {
        if (!researchPapers.contains(paper)) {
            researchPapers.add(paper);
        }
        paper.addAuthor(this);
    }

    @Override
    public void joinProject(ResearchProject project) {
        if (!researchProjects.contains(project)) {
            researchProjects.add(project);
        }
        project.addParticipant(this);
    }

    @Override
    public void printPapers(PaperComparator comparator) {
        List<ResearchPaper> sorted = new ArrayList<>(researchPapers);
        sorted.sort(comparator);
        for (ResearchPaper paper : sorted) {
            paper.print();
        }
    }
}
