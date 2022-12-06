package pl.sdutka.electronic.shop.database;

import pl.sdutka.electronic.shop.categories.Device;
import pl.sdutka.electronic.shop.categories.User;

import java.util.Arrays;

public class UserDB {

    private User[] users = new User[2];
    private static final UserDB instance = new UserDB();

    public UserDB(){
        this.users[0] = new User("admin", "eb0468abcd9f88e9844fd140fbb6acff", User.Role.ADMIN);
        this.users[1] = new User("janusz", "6fff9bb96e12805ea3ccb8ec27e8206f", User.Role.USER);
    }

    public User[] getUsers(){
        return users;
    }

    public User findByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User setUserAsAdmin(String login, String iD) {
        for(User user: this.users){
            if(user.getLogin().equals(login) && user.getiD().equals(iD)){
                user.setRole(User.Role.ADMIN);
            }
        }
        return null;
    }
    public void addNewUser(User user) {
        User[] newUser = new User[this.users.length + 1];
        for(int i = 0; i < this.users.length; i++) {
            newUser[i] = this.users[i];
        }
        newUser[newUser.length - 1] = user;
        this.users = newUser;
    }

    public static UserDB getInstance() {
        return instance;
    }
}
