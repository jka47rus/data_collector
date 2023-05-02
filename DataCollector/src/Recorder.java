package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Recorder {
    public static void writeJason(String fileName, Map<String, String> lnSt) throws IOException {

        JSONObject lines = new JSONObject();
        JSONArray stationss = new JSONArray();

        JSONObject stationObject = new JSONObject();
        stationObject.put("stations", lines);



        for (Map.Entry<String, String> entry : lnSt.entrySet()) {
            lines.put(entry.getKey(), stationss);
            stationss.add(entry.getValue());
        }



       // stationss.add(stations);
//        for (String entry : stations) {
//            stationss.add(entry);
//        }

        //lines.put(line, stationss);

        Files.write(Paths.get(fileName), stationObject.toJSONString().getBytes());
    }
}
