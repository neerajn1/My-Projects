import java.util.*;

public class mainMap {
    public static void main(String[] args) {
        // HashMap has 6 entries featuring major country's capitals with map named mapList
        Map <String, String> mapList = new HashMap<>();
        mapList.put("The USA", "Washington DC");
        mapList.put("Canada", "Ottawa");
        mapList.put("Japan", "Tokyo");
        mapList.put("India", "New Delhi");
        mapList.put("UAE", "Abu Dhabi");
        mapList.put("Russia", "Moscow");

        // Outputting each country and its capital (in Java terms, key and value)
        //entrySet method returns the map's respective entries
        for (Map.Entry <String, String> entryList : mapList.entrySet()) {
            System.out.println("Country: " + entryList.getKey() + ", Capital: " + entryList.getValue());
        }
    }
}

