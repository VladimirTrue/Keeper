package entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String login;
    private String password;
    private String email;
    private List<Period> periods;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.periods = new ArrayList<Period>();
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
}
