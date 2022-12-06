package pl.sdutka.electronic.shop.categories;

import javax.management.relation.Role;
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
        return new StringBuilder().append("User")
                .append("login='")
                .append(login)
                .append('\'')
                .append(", password='")
                .append(password)
                .append('\'')
                .append(", role=")
                .append(role)
                .append(", iD='")
                .append(iD)
                .append('\'').toString();
    }
}
