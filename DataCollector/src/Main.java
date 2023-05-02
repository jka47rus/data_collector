package src;

import com.sun.jdi.Value;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> stati = new LinkedHashMap<>();


//      Поиск JSON файла
        String folderPath =
                "C:/Java projects/java_basics/FilesAndNetwork" +
                        "/DataCollector" +
                        "/data/stations-data/";

        File file = new File(folderPath);
        ParserHtml info = new ParserHtml();

//      JSON Parser станция и глубина
//      ParserJson.getInfoFromJsonFile(Searcher.getJsonFile(file));

//      CSV Parser станция и год открытия
//      ParserCsv.getInfoFromCsvFile(Searcher.getCsvFile(file));


//      HTML Parser
        String readHtml = parseHtmlFile("data/code.html");
        Document doc = Jsoup.parse(readHtml);

//      Парсинг линий
        Elements lines = doc.select("span.js-metro-line");
        for (Element ln : lines) {
            String number = ln.attr("data-line");
            String line = ln.text();
            info.addLine(number, line);
        }
//        info.getAllLines();

//      Парсинг станций
        Elements stations = doc.select("div.js-metro-stations");
        for (Element ch : stations) {
            String number = ch.attr("data-line");
            String station = ch.tagName("p.single-station").text();

            String[] words = station.split("[0-9]{1,2}");

            for (String word : words) {
                if(word.contains("\s")){
                    stati.put(number, word.replaceAll("[.]", "")
                            .trim());
//                    info.addStation(number, word.replaceAll("[.]", "")
//                            .trim())
                    ;}
            }

            for(Map.Entry<String, String> entry : stati.entrySet()){
                System.out.println(entry.getKey() + "---" + entry.getValue());
            }


      //      Recorder.writeJason("map.json", stati);
           // info.addStation(number, station);
        }


        //info.getAllStations();


//      Запись в файл
 //       Recorder.writeJason("map.json", info.getLine(), info.getAllStations());

    }



    public static String parseHtmlFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }

}
