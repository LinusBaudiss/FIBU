package de.linus.fibu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.linus.fibu.dao.Queries;

@SpringBootApplication
public class FibuApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FibuApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        String[] months = {"Gesamtes Erspartes", "September 2018", "Oktober 2018", "November 2018", "Dezember 2018",
                "Sonderzahlungen 2018", "Januar 2019", "Februar 2019", "Maerz 2019", "April 2019", "Mai 2019",
                "Sonderzahlungen 2019"};
        String dbpath = System.getProperty("user.home") + "/git/fibu_db/db/FIBU";
        try {
            int in = Integer.parseInt(args[0]);
            if (in > months.length) {
                throw new RuntimeException("Input Nummer zu gross!");
            }
            String[] tableinfo = parseInput(months[in - 1]);
            double betrag = new Queries(dbpath).selectTable(tableinfo);
            System.out.println(months[in - 1] + ": " + betrag);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input in der main args notwendig!");
            System.out.println("Moegliche Inputs:");
            for (int i = 0; i < months.length; i++) {
                int num = i + 1;
                System.out.println("[" + num + "] " + months[i]);
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
