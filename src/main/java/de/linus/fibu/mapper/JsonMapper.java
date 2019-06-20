package de.linus.fibu.mapper;

import java.io.File;
import java.util.ArrayList;

import de.linus.fibu.config.DBConfig;

public class JsonMapper {

    public DBConfig mapDBConfig(String filepath){
        //return new ObjectMapper().readValue(new File(filepath), DBConfig.class);
        ArrayList<String> testMonths = new ArrayList<>();
        testMonths.add("Gesamtes Erspartes");
        DBConfig dbConfig = new DBConfig("/home/linus/git/fibu_db/db/FIBU", testMonths);
        return dbConfig;
    }

}
