package de.linus.fibu.mapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import de.linus.fibu.config.DBConfig;

public class JsonMapper {

    private static final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    public DBConfig mapDBConfig(String filepath){
        try {
            return new ObjectMapper().readValue(new File(filepath), DBConfig.class);
        }
        catch(IOException e){
            logger.error("Error while reading the following file " + filepath, e);
            return null;
        }
    }

}
