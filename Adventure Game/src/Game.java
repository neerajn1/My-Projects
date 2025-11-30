import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Game {
    private Player player;
    private ArrayList<Room> rooms;
    private Scanner scanner;
    private Random random;
    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        rooms = new ArrayList<>();
        setupRooms();
        player = new Player("Survivor", rooms.get(0), 100);
    }
    private void setupRooms() {
        Room startRoom = new Room("Wasteland Camp",
                "You wake and find yourself at the edge of a toxic wasteland. The air smells of chemicals, and the sky is a dull, sickly green.");
        startRoom.addItem("Makeshift Weapon");
        startRoom.addItem("Medkit");
        Room room2 = new Room("Abandoned Shack",
                "An old, crumbling shack with scattered supplies.");
        room2.addItem("Old Map");
        Room room3 = new Room("Radioactive Pit",
                "A deep pit filled with glowing green liquid. You can feel the radiation from here.");
        Room room4 = new Room("Ruined Overpass",
                "A collapsed overpass with rusted vehicles.");
        Room room5 = new Room("Marauder Hideout",
                "A gang of marauders is waiting here, ready to ambush anyone passing through.");
        room5.setMonster(new Monster("Marauder Leader", 100));
        ArrayList<Room> randomRooms = new ArrayList<>();
        randomRooms.add(room2);
        randomRooms.add(room3);
        randomRooms.add(room4);
        randomRooms.add(room5);
        Collections.shuffle(randomRooms);
        rooms.add(startRoom);
        rooms.addAll(randomRooms);
        setupExits();
    }
    private void setupExits() {
        Room startRoom = rooms.get(0);
        Room randomRoom1 = rooms.get(1);
        Room randomRoom2 = rooms.get(2);
        Room randomRoom3 = rooms.get(3);
        Room randomRoom4 = rooms.get(4);
        startRoom.setExits(randomRoom1, null, randomRoom2, randomRoom3);
        randomRoom1.setExits(randomRoom4, startRoom, null, null);
        randomRoom2.setExits(null, null, null, startRoom);
        randomRoom3.setExits(null, null, startRoom, null);
        randomRoom4.setExits(null, randomRoom1, null, null);
    }
    public void start() {
        System.out.println("Welcome to the toxic wasteland!");
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.println(player.getCurrentRoom().getDescription());
            System.out.println("What would you like to do?");
            System.out.println("1. Move North");
            System.out.println("2. Move South");
            System.out.println("3. Move East");
            System.out.println("4. Move West");
            System.out.println("5. Check Inventory");
            System.out.println("6. Pick up item");
            System.out.println("7. Quit");
            int choice = scanner.nextInt();
            handleUserChoice(choice);
            if (player.getCurrentRoom().hasMonster()) {
                startCombat(player.getCurrentRoom().getMonster());
            }
            if (player.getHealth() <= 0) {
                System.out.println("You have died in the wasteland! Starting over...");
                resetGame();
            }
        }
        System.out.println("Thanks for playing!");
    }
    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1: player.moveNorth(); break;
            case 2: player.moveSouth(); break;
            case 3: player.moveEast(); break;
            case 4: player.moveWest(); break;
            case 5: player.showInventory(); break;
            case 6: player.pickUpItem(); break;
            case 7: System.exit(0); break;
            default: System.out.println("Invalid choice.");
        }
    }
    private void startCombat(Monster monster) {
        System.out.println("The " + monster.getName() + " attacks you!");
        boolean isInCombat = true;
        while (isInCombat) {
            System.out.println("Your health: " + player.getHealth());
            System.out.println(monster.getName() + " health: " + monster.getHealth());
            System.out.println("1. Attack");
            System.out.println("2. Use Medkit");
            System.out.println("3. Run");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (player.hasItem("Makeshift Weapon")) {
                        int playerDamage = random.nextInt(10) + 10;
                        player.attack(monster, playerDamage);
                        System.out.println("You dealt " + playerDamage + " damage!");
                        if (monster.getHealth() <= 0) {
                            System.out.println("You defeated the " + monster.getName() + "!");
                            isInCombat = false;
                            showVictoryPrompt(); // Call to show victory prompt
                        } else {
                            int monsterDamage = random.nextInt(10) + 10;
                            monster.attack(player, monsterDamage);
                            System.out.println("The " + monster.getName() + " dealt " + monsterDamage + " damage!");
                        }
                    } else {
                        System.out.println("You don't have a weapon to fight the " + monster.getName() + "!");
                    }
                    break;
                case 2:
                    if (player.hasItem("Medkit")) {
                        player.useItem("Medkit");
                    } else {
                        System.out.println("You don't have any medkits to use!");
                    }
                    break;
                case 3:
                    System.out.println("You run away!");
                    isInCombat = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private void showVictoryPrompt() {
        System.out.println("Congratulations! You have cleared the area from the Marauder Leader!");
        System.out.println("Would you like to play again? (y/n)");
        char response = scanner.next().charAt(0);
        if (response == 'y' || response == 'Y') {
            resetGame();
        } else {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }
    private void resetGame() {
        player = new Player("Survivor", rooms.get(0), 100);
        start();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}




