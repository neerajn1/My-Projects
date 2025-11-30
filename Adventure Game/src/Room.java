import java.util.ArrayList;
public class Room {
    private String name;
    private String description;
    private ArrayList<String> items;
    private Monster monster;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.monster = null;
    }
    public String getDescription() {
        return description;
    }
    public void addItem(String item) {
        items.add(item);
    }
    public ArrayList<String> getItems() {
        return items;
    }
    public void setExits(Room north, Room south, Room east, Room west) {
        this.northExit = north;
        this.southExit = south;
        this.eastExit = east;
        this.westExit = west;
    }
    public Room getNorthExit() {
        return northExit;
    }
    public Room getSouthExit() {
        return southExit;
    }
    public Room getEastExit() {
        return eastExit;
    }
    public Room getWestExit() {
        return westExit;
    }
    public boolean hasMonster() {
        return monster != null;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    public Monster getMonster() {
        return monster;
    }
}

