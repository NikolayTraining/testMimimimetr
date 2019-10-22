package db.pojo;

import java.util.Date;

public class UserDate {
    private int id;
    private String login;
    private String password;
    private Boolean enabled;
    private String role;

    public UserDate(){}

    public UserDate(int id) {
        this.id = id;
    }

    public UserDate(String login) {
        this.login = login;
    }

    public UserDate(int id, String login, String password, Boolean enabled, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }


    @Override
    public String toString() {
        return "UserDate{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {

        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getRole() {
        return role;
    }


}
