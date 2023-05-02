package src;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParserCsv {


    public ParserCsv(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    private String name;
    private Date date;


    public static List<ParserCsv> getInfoFromCsvFile(List<String> pathCsv) {
        List<ParserCsv> stations = new ArrayList<>();
        try {

            for (String path : pathCsv) {
                List<String> lines = Files.readAllLines(Paths.get(path));
                for (String line : lines) {
                    String[] fragments = line.split(",");
                    if (fragments.length != 2) {
                        System.out.println("Wrong line: " + line);
                        continue;
                    }
                    String dateFormat = "dd.MM.yyyy";
                    if (fragments[1].matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4}")) {
                        stations.add(new ParserCsv(fragments[0], (new SimpleDateFormat(dateFormat)).parse(fragments[1])));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        stations.forEach(System.out::println);
        return stations;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return name + " - " +
                (new SimpleDateFormat("dd.MM.yyyy")).format(date);
    }

}
