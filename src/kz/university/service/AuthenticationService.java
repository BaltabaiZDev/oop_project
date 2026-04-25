package kz.university.service;

import kz.university.exceptions.AuthenticationException;
import kz.university.model.User;
import kz.university.repository.UserRepository;

public class AuthenticationService {
    private static AuthenticationService instance;
    private UserRepository userRepository;

    private AuthenticationService() {
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            instance = new AuthenticationService();
        }
        return instance;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String login, String password) {
        if (userRepository == null) {
            throw new AuthenticationException("UserRepository is not configured");
        }
        for (User user : userRepository.findAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Authenticated: " + user);
                return user;
            }
        }
        throw new AuthenticationException("Wrong login or password");
    }
}
