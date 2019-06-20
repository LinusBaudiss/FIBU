package de.linus.fibu.config;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DBConfig {

    @JsonProperty
    private String dbpath;
    @JsonProperty
    private String user;
    @JsonProperty
    private String password;
    @JsonProperty
    private List<String> months;

    public String getDbpath() {
        return dbpath;
    }

    public void setDbpath(String dbpath) {
        this.dbpath = dbpath;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

}
