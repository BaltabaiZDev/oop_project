package university.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UniversityStorage {
    private static final List<User> USERS = new ArrayList<>();

    private UniversityStorage() {
    }

    public static void addUser(User user) {
        if (!USERS.contains(user)) {
            USERS.add(user);
        }
    }

    public static void removeUser(User user) {
        USERS.remove(user);
    }

    public static List<User> getUsers() {
        return Collections.unmodifiableList(USERS);
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (User user : USERS) {
            if (user instanceof Student student) {
                students.add(student);
            }
        }
        return students;
    }
}
