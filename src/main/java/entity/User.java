package entity;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password", unique = true, updatable = false)
    private String password;
    @Column(name = "email", unique = true, updatable = false)
    private String email;
    @Transient
    private List<Period> periods;

    public User() {

    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.periods = new ArrayList<Period>();
    }

    private void createPeriod(String name, LocalDate startDte, LocalDate endDate){
        periods.add(new Period(name, startDte, endDate));
    }

    public void setPeriod(Period period) {
        periods.add(period);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", periods=" + periods +
                '}';
    }
}
