package kz.university.factory;

import kz.university.enums.ManagerType;
import kz.university.enums.StudentYear;
import kz.university.enums.TeacherTitle;
import kz.university.enums.UserRole;
import kz.university.model.Admin;
import kz.university.model.Manager;
import kz.university.model.ResearchEmployee;
import kz.university.model.Student;
import kz.university.model.Teacher;
import kz.university.model.User;
import kz.university.repository.UserRepository;

public class UserFactory {
    private UserRepository userRepository;

    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRole role) {
        switch (role) {
            case STUDENT:
                return new Student("S1", "student", "123", "Student", "User", StudentYear.FIRST);
            case TEACHER:
                return new Teacher("T1", "teacher", "123", "Teacher", "User", 300000, TeacherTitle.LECTOR, 2);
            case MANAGER:
                return new Manager("M1", "manager", "123", "Manager", "User", 400000, ManagerType.OR);
            case ADMIN:
                return new Admin("A1", "admin", "123", "Admin", "User", 500000, userRepository);
            case RESEARCHER:
                return new ResearchEmployee("R1", "researcher", "123", "Research", "User", 450000, 5);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
