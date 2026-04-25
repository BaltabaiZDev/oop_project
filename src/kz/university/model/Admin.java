package kz.university.model;

import kz.university.enums.UserRole;
import kz.university.interfaces.Messageable;
import kz.university.repository.UserRepository;

public class Admin extends Employee implements Messageable {
    private transient UserRepository userRepository;

    public Admin(String id, String login, String password, String firstName, String lastName,
                 double salary, UserRepository userRepository) {
        super(id, login, password, UserRole.ADMIN, firstName, lastName, salary);
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user.getId());
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void viewLogs() {
        System.out.println("System logs: no errors");
    }

    public void manageSystemConfig() {
        System.out.println("System config was updated");
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("Admin message: " + text);
    }

    @Override
    public void viewInbox() {
        System.out.println("Admin inbox is empty");
    }
}
