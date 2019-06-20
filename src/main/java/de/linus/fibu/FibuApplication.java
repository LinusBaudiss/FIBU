package de.linus.fibu;

import de.linus.fibu.config.DBConfig;
import de.linus.fibu.mapper.JsonMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import de.linus.fibu.dao.Queries;

@SpringBootApplication
public class FibuApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FibuApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        DBConfig dbConfig = new JsonMapper().mapDBConfig("db_conf.json");
        List<String> months = dbConfig.getMonths();
        try {
            int in = Integer.parseInt(args[0]);
            if (in > months.size()) {
                throw new RuntimeException("Input Nummer zu gross!");
            }
            String[] tableinfo = parseInput(months.get(in - 1));
            double betrag = new Queries(dbConfig.getDbpath(),dbConfig.getUser(), dbConfig.getPassword()).selectTable(tableinfo);
            System.out.println(months.get(in - 1) + ": " + betrag);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input in der main args notwendig!");
            System.out.println("Moegliche Inputs:");
            for (int i = 0; i < months.size(); i++) {
                int num = i + 1;
                System.out.println("[" + num + "] " + months.get(i));
            }
        }
    }

    private String[] parseInput(String cbstring) {
        String[] out = cbstring.split(" ");
        if (out[0].equals("Sonderzahlungen")) {
            out[0] = out[0].substring(0, out[0].length() - 2);
        }
        return out;
    }
}
