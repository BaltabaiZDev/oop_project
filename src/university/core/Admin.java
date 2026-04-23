package university.core;

import java.util.List;

public class Admin extends Employee {
    public Admin(String id, String login, String password, String firstName, String lastName, double salary) {
        super(id, login, password, firstName, lastName, salary);
    }

    public void addUser(User user) {
        UniversityStorage.addUser(user);
    }

    public void removeUser(User user) {
        UniversityStorage.removeUser(user);
    }

    public void updateUser(User user) {
        // Simplified: in-memory storage updates same object by reference.
        if (!UniversityStorage.getUsers().contains(user)) {
            UniversityStorage.addUser(user);
        }
    }

    public List<String> viewLogs() {
        return List.of("[INFO] System started", "[INFO] User list checked");
    }

    public String manageSystemConfig() {
        return "System configuration updated";
    }
}
