package bo;

import db.UserDB;

import java.util.Collection;

public class User {
    private String username;
    private String password;

    static public Collection searchUser(String group){
        return UserDB.searchUser(group);
    }

    protected User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  username +  ", " + password;
    }
}
