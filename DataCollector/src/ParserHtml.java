package src;

import java.util.*;

public class ParserHtml {

    private Map<String, String> numberLine;
    //private Map<String, ArrayList<String>> stations;
    private Map<String, String> stations;

    String line;
    String station;

    public ParserHtml() {
        numberLine = new LinkedHashMap<>();
        stations = new LinkedHashMap<>();
    }


//    public String getLine() {
//        for (Map.Entry<String, ArrayList<String>> entry : stations.entrySet()) {
//            line = "Линия № " + entry.getKey();
//        }
//        return line;
//    }

        public String getLine() {
        for (Map.Entry<String, String> entry : stations.entrySet()) {

                System.out.println(line = "Линия № " + entry.getKey());}

        return line;
    }

//    public String getStation() {
//        for (Map.Entry<String, ArrayList<String>> entry : stations.entrySet()) {
//            for(String s : entry.getValue()){
//            //station = String.valueOf(entry.getValue());
//
//            System.out.println(s);}
//        }
//
//        return station;
//    }

        public String getStation() {
        for (Map.Entry<String, String> entry : stations.entrySet()) {
            //entry.getValue();
            //station = String.valueOf(entry.getValue());
            System.out.println(entry.getValue());
            }


        return station;
    }


    public void addStation(String line, String station) {
//        ArrayList<String> stat = new ArrayList<>();
//        stat.add(station);
            stations.put(line, station);
//        for (Map.Entry<String, String> entry : stations.entrySet()) {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }
    }


    public void addLine(String number, String line) {
        numberLine.put(number, line);

    }

//    public Map<String, ArrayList<String>> getAllStations() {
//
//        for (Map.Entry<String, ArrayList<String>> entry : stations.entrySet()) {
//            System.out.println("Линия № " + entry.getKey() + ": " + "\n"
//                    + entry.getValue());
//        }
//        return stations;
//    }

    public List < String> getAllStations(){
    List <String> stat = new ArrayList<>();
        for (Map.Entry<String, String> entry : stations.entrySet()) {

                stat.add(entry.getValue());
            System.out.println("Линия № " + entry.getKey() + ": " + "\n"
                    + entry.getValue());

        }
        return stat;
        }




    public Map<String, String> getAllLines() {

        for (Map.Entry<String, String> entry : numberLine.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return numberLine;
    }

}
