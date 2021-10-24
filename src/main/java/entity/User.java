package entity;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {


    private long id;
    private String login;
    private String password;
    private String email;
    private Map<String, Period> periods;

    public User() {

    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.periods = new HashMap<>();
    }

    public void createPeriod(String name, LocalDate startDte, LocalDate endDate) {
        periods.put(name, new Period(this.id, name, startDte, endDate));
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Period> getPeriods() {
        return periods;
    }

    public void setPeriods(Map<String, Period> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
