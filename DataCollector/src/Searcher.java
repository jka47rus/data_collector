package src;

import java.io.File;
import java.util.*;

public class Searcher {

    static List<String> jsonPaths = new ArrayList<>();
    static List<String> csvPaths = new ArrayList<>();

    public static List<String> getJsonFile(File folder) {

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getJsonFile(file);
                    } else if (file.getName().toLowerCase().endsWith(".json")) {
                        jsonPaths.add(String.valueOf(file));
                    }
                }
            }
        }
//        jsonPaths.forEach(System.out::println);

        return jsonPaths;
    }


    public static List<String> getCsvFile(File folder) {

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getCsvFile(file);
                    } else if (file.getName().toLowerCase().endsWith(".csv")
                    ) {
                        csvPaths.add(String.valueOf(file));

                    }
                }
            }
        }
//        csvPaths.forEach(System.out::println);

        return csvPaths;
    }


}
