package model;

/**
 * Created by Vlad on 5/1/2015.
 */
public class Account {

    private String name = "";
    private Password password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Account(String name, Password password) {

        this.name = name;
        this.password = password;
    }
}
