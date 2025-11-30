import java.util.ArrayList;
public class Player {
    private String name;
    private Room currentRoom;
    private ArrayList<String> inventory;
    private int health;
    public Player(String name, Room startingRoom, int health) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    public void attack(Monster monster, int damage) {
        monster.takeDamage(damage);
    }
    public void moveNorth() {
        if (currentRoom.getNorthExit() != null) {
            currentRoom = currentRoom.getNorthExit();
            System.out.println("You moved north.");
        } else {
            System.out.println("You can't go that way.");
        }
    }
    public void moveSouth() {
        if (currentRoom.getSouthExit() != null) {
            currentRoom = currentRoom.getSouthExit();
            System.out.println("You moved south.");
        } else {
            System.out.println("You can't go that way.");
        }
    }
    public void moveEast() {
        if (currentRoom.getEastExit() != null) {
            currentRoom = currentRoom.getEastExit();
            System.out.println("You moved east.");
        } else {
            System.out.println("You can't go that way.");
        }
    }
    public void moveWest() {
        if (currentRoom.getWestExit() != null) {
            currentRoom = currentRoom.getWestExit();
            System.out.println("You moved west.");
        } else {
            System.out.println("You can't go that way.");
        }
    }
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + inventory);
        }
    }
    public void pickUpItem() {
        if (currentRoom.getItems().isEmpty()) {
            System.out.println("There's nothing to pick up here.");
        } else {
            String item = currentRoom.getItems().remove(0);
            inventory.add(item);
            System.out.println("You picked up: " + item);
        }
    }
    public boolean hasItem(String item) {
        return inventory.contains(item);
    }
    public void useItem(String item) {
        if (inventory.contains(item)) {
            if (item.equals("Medkit")) {
                health += 20;
                if (health > 100) {
                    health = 100;
                }
                inventory.remove(item);
                System.out.println("You used the medkit and healed 20 health points.");
            } else {
                System.out.println("You can't use that item.");
            }
        } else {
            System.out.println("You don't have a " + item + " to use.");
        }
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
}


