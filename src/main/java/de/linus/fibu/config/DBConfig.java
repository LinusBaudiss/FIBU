package de.linus.fibu.config;

import java.util.ArrayList;
import java.util.List;

public class DBConfig {

    //@JsonProperty
    private String dbpath;
    //@JsonProperty
    private List<String> months;

    public DBConfig(String dbpath, ArrayList<String> months) {
        this.dbpath = dbpath;
        this.months = months;
    }

    public String getDbpath() {
        return dbpath;
    }

    public void setDbpath(String dbpath) {
        this.dbpath = dbpath;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<String> months) {
        this.months = months;
    }

}
