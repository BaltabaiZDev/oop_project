package kz.university;

import java.time.LocalDate;
import kz.university.enums.LessonType;
import kz.university.enums.ManagerType;
import kz.university.enums.StudentYear;
import kz.university.enums.TeacherTitle;
import kz.university.enums.UserRole;
import kz.university.exceptions.LowHIndexSupervisorException;
import kz.university.exceptions.NotResearcherException;
import kz.university.factory.UserFactory;
import kz.university.model.AcademicReport;
import kz.university.model.Admin;
import kz.university.model.Course;
import kz.university.model.Enrollment;
import kz.university.model.Lesson;
import kz.university.model.Manager;
import kz.university.model.Mark;
import kz.university.model.News;
import kz.university.model.ResearchEmployee;
import kz.university.model.ResearchPaper;
import kz.university.model.ResearchProject;
import kz.university.model.Student;
import kz.university.model.Teacher;
import kz.university.repository.UserRepository;
import kz.university.service.AuthenticationService;
import kz.university.service.CitationComparator;
import kz.university.service.DateComparator;
import kz.university.service.PagesComparator;
import kz.university.service.ResearchService;
import kz.university.storage.FileStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Research-Oriented University System Demo ===");

        FileStorage storage = new FileStorage("users.dat");
        UserRepository userRepository = new UserRepository(storage);
        UserFactory userFactory = new UserFactory(userRepository);

        AuthenticationService auth = AuthenticationService.getInstance();
        auth.setUserRepository(userRepository);

        Student student = new Student("S100", "student", "123", "Ali", "Student", StudentYear.FOURTH);
        Teacher teacher = new Teacher("T100", "teacher", "123", "Dana", "Teacher", 350000, TeacherTitle.PROFESSOR, 7);
        Manager manager = new Manager("M100", "manager", "123", "Murat", "Manager", 450000, ManagerType.OR);
        Admin admin = new Admin("A100", "admin", "123", "Aigerim", "Admin", 500000, userRepository);
        ResearchEmployee researcher = new ResearchEmployee("R100", "researcher", "123", "Serik", "Researcher", 420000, 5);

        admin.addUser(student);
        admin.addUser(teacher);
        admin.addUser(manager);
        admin.addUser(admin);
        admin.addUser(researcher);

        auth.authenticate("student", "123");

        Course oop = new Course("C100", "Object Oriented Programming", 6, "Computer Science", StudentYear.FOURTH);
        oop.addLesson(new Lesson("L1", "Classes and Objects", LocalDate.of(2026, 4, 20), LessonType.LECTURE));
        oop.addLesson(new Lesson("L2", "UML Practice", LocalDate.of(2026, 4, 22), LessonType.PRACTICE));

        manager.addCourseForRegistration(oop);
        manager.assignTeacher(oop, teacher);

        Enrollment enrollment = student.registerCourse(oop);
        manager.approveRegistration(enrollment);
        teacher.putMark(enrollment, new Mark(25, 25, 35));

        student.viewTranscript();
        student.rateTeacher(teacher, 4.8);
        System.out.println("Teacher rating: " + teacher.getRating());

        AcademicReport report = manager.createAcademicReport();
        report.print();

        ResearchPaper p1 = new ResearchPaper("P1", "AI in Education", "IEEE Access", "10.1109/ACCESS.2026.000001", 10, 45, LocalDate.of(2026, 2, 15));
        ResearchPaper p2 = new ResearchPaper("P2", "Cybersecurity in University Systems", "Springer Journal", "10.1007/S001.2025.000002", 16, 20, LocalDate.of(2025, 11, 10));

        teacher.publishPaper(p1);
        researcher.publishPaper(p2);
        student.publishPaper(p1);

        ResearchProject project = new ResearchProject("RP1", "Smart Campus", "ACTIVE");
        teacher.joinProject(project);
        researcher.joinProject(project);
        project.addPaper(p1);
        project.addPaper(p2);

        ResearchService researchService = new ResearchService();
        researchService.addResearcher(student);
        researchService.addResearcher(teacher);
        researchService.addResearcher(researcher);

        researchService.assignSupervisor(student, teacher);
        System.out.println("Supervisor assigned successfully");

        System.out.println("\n--- Teacher papers sorted by citations ---");
        teacher.printPapers(new CitationComparator());

        System.out.println("\n--- All papers sorted by date ---");
        researchService.printAllPapers(new DateComparator());

        System.out.println("\n--- All papers sorted by pages ---");
        researchService.printAllPapers(new PagesComparator());

        System.out.println("\n--- Top cited researcher ---");
        System.out.println(researchService.printTopCitedResearcher());

        manager.manageNews(new News("Exam week", "Final exam will start next week."));

        System.out.println("\n--- Custom exception examples ---");
        try {
            ResearchEmployee weakResearcher = new ResearchEmployee("R200", "weak", "123", "Weak", "Researcher", 200000, 1);
            researchService.assignSupervisor(student, weakResearcher);
        } catch (LowHIndexSupervisorException e) {
            System.out.println("LowHIndexSupervisorException: " + e.getMessage());
        }

        try {
            project.addParticipant(null);
        } catch (NotResearcherException e) {
            System.out.println("NotResearcherException: " + e.getMessage());
        }

        userRepository.saveToFile();
        System.out.println("\nUsers serialized to users.dat");

        System.out.println("\nFactory example: " + userFactory.createUser(UserRole.STUDENT));
        System.out.println("=== Demo finished ===");
    }
}
