package university.demo;

import university.academic.Course;
import university.academic.Enrollment;
import university.academic.Lesson;
import university.core.*;
import university.enums.*;
import university.research.ResearchPaper;
import university.research.ResearchProject;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("A1", "admin", "1234", "System", "Admin", 500000);
        Manager manager = new Manager("M1", "manager", "1234", "Dana", "Nur", 400000, ManagerType.DEAN);
        Teacher teacher = new Teacher("T1", "teacher", "1234", "Aruzhan", "Bek", 350000, TeacherTitle.LECTOR);
        Student student = new Student("S1", "student", "1234", "Ali", "Serik", 3.6, StudentYear.SECOND);
        Researcher researcher = new Researcher("R1", "researcher", "1234", "Timur", "Askar", 450000, 7);

        admin.addUser(manager);
        admin.addUser(teacher);
        admin.addUser(student);
        admin.addUser(researcher);

        Course oop = manager.createCourse("CS101", "OOP", 5, "Object-oriented programming basics");
        manager.manageCourseContent(oop, "Updated OOP course content");
        manager.assignTeacher(oop, teacher);
        oop.addLesson(new Lesson("L1", "Classes and Objects", LocalDate.now(), LessonType.LECTURE));
        oop.addLesson(new Lesson("L2", "Inheritance", LocalDate.now().plusDays(1), LessonType.PRACTICE));

        Enrollment enrollment = student.registerCourse(oop);
        manager.approveRegistration(enrollment);
        teacher.enterGrades(enrollment, 25, 27, 40);
        student.rateTeacher(teacher, 4.8);

        ResearchProject project = new ResearchProject("P1", "AI in Education", "Active");
        ResearchPaper paper = new ResearchPaper(
                "RP1",
                "Adaptive Learning Models",
                "Education Journal",
                "10.1000/xyz123",
                12,
                15,
                LocalDate.now()
        );
        researcher.joinProject(project);
        researcher.publishPaper(paper);
        project.addPaper(paper);

        System.out.println(manager.createAcademicReport());
        System.out.println("Student transcript: " + student.viewTranscript());
        System.out.println("Teacher students in OOP: " + teacher.viewStudents(oop));
        System.out.println("Teacher rating: " + teacher.getRating());
        paper.print();
        System.out.println("Researcher papers: " + researcher.viewOwnPapers());
        System.out.println(admin.viewLogs());
    }
}
