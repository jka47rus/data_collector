package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class ParserJson {


    public static void getInfoFromJsonFile(List<String> pathJson) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray array = new JSONArray();
            for (String path : pathJson) {
                array.add(parser.parse(new FileReader(path)));
            }
            for (int j = 0; j < array.size(); j++) {
                for (int i = 0; i < (((JSONArray) array.get(j)).size()); i++) {
                    JSONObject jsonObject =
                            (JSONObject) (((JSONArray) array.get(j)).get(i));

                    String name = (String) jsonObject.get("station_name");
                    String depth = (String) jsonObject.get("depth");
                    System.out.println("Name: " + name);
                    System.out.println("Depth: " + depth);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


//    public static String getJsonFile(String path) {
//        StringBuilder builder = new StringBuilder();
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(path));
//            lines.forEach(line -> builder.append(line));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return builder.toString();
//
//    }
}
