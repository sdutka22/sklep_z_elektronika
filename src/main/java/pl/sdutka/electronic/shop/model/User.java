package pl.sdutka.electronic.shop.model;

import java.util.UUID;

public class User {
    private String login;
    private String password;
    private Role role = Role.USER;
    private String iD = UUID.randomUUID().toString();

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(){}

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
    public enum Role {
        ADMIN,
        USER
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("login")
                .append("\t")
                .append("password")
                .append("\t")
                .append("\t")
                .append("\t")
                .append("\t")
                .append("\t")
                .append("\t")
                .append("\t")
                .append("role")
                .append("\t")
                .append("User ID")
                .append("\t")
                .append("\n")
                .append(login)
                .append("\t")
                .append(password)
                .append("\t")
                .append(role)
                .append("\t")
                .append(iD).toString();
    }
}
