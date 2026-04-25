package kz.university.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.university.enums.StudentYear;
import kz.university.enums.UserRole;
import kz.university.exceptions.CreditLimitException;
import kz.university.exceptions.LowHIndexSupervisorException;
import kz.university.exceptions.TooManyFailsException;
import kz.university.interfaces.Messageable;
import kz.university.interfaces.PaperComparator;
import kz.university.interfaces.Researcher;

public class Student extends User implements Messageable, Researcher {
    private String firstName;
    private String lastName;
    private double gpa;
    private StudentYear year;
    private int failedCourses;
    private Researcher supervisor;
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();
    private int hIndex;

    public Student(String id, String login, String password, String firstName, String lastName, StudentYear year) {
        super(id, login, password, UserRole.STUDENT);
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.gpa = 0.0;
        this.hIndex = 0;
    }

    public Enrollment registerCourse(Course course) {
        if (failedCourses > 3) {
            throw new TooManyFailsException("Student cannot fail more than 3 times");
        }
        if (getTotalCredits() + course.getCredits() > 21) {
            throw new CreditLimitException("Student cannot register for more than 21 credits");
        }
        Enrollment enrollment = new Enrollment(this, course);
        enrollments.add(enrollment);
        course.addEnrollment(enrollment);
        return enrollment;
    }

    public List<Course> viewCourses() {
        List<Course> courses = new ArrayList<>();
        for (Enrollment e : enrollments) {
            courses.add(e.getCourse());
        }
        return courses;
    }

    public List<Mark> viewMarks() {
        List<Mark> marks = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getMark() != null) {
                marks.add(e.getMark());
            }
        }
        return marks;
    }

    public void viewTranscript() {
        System.out.println("Transcript of " + getFullName());
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }

    public void rateTeacher(Teacher teacher, double value) {
        teacher.setRating(value);
    }

    public void assignSupervisor(Researcher researcher) {
        if (year == StudentYear.FOURTH && researcher.getHIndex() < 3) {
            throw new LowHIndexSupervisorException("Supervisor h-index must be at least 3");
        }
        this.supervisor = researcher;
    }

    public int getTotalCredits() {
        int total = 0;
        for (Enrollment e : enrollments) {
            total += e.getCourse().getCredits();
        }
        return total;
    }

    public void addFailedCourse() {
        failedCourses++;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public StudentYear getYear() {
        return year;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("Student message: " + text);
    }

    @Override
    public void viewInbox() {
        System.out.println("Student inbox is empty");
    }

    @Override
    public int getHIndex() {
        return hIndex;
    }

    public void setHIndex(int hIndex) {
        this.hIndex = hIndex;
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
