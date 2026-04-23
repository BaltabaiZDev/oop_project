package university.core;

import java.util.Objects;

public abstract class User {
    private final String id;
    private String login;
    private String password;
    private boolean loggedIn;

    protected User(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public boolean login(String login, String password) {
        this.loggedIn = Objects.equals(this.login, login) && Objects.equals(this.password, password);
        return this.loggedIn;
    }

    public void logout() {
        this.loggedIn = false;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
