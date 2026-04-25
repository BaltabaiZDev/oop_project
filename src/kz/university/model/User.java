package kz.university.model;

import java.io.Serializable;
import java.util.Objects;
import kz.university.enums.UserRole;

public abstract class User implements Serializable {
    private String id;
    private String login;
    private String password;
    private UserRole role;

    protected User(String id, String login, String password, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public boolean login() {
        return true;
    }

    public void logout() {
        System.out.println(login + " logged out");
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return role + "{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
