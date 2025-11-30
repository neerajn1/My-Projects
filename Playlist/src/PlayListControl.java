import java.util.Scanner;
//contains many methods that coordinate with the PlayList class

public class PlayListControl {
  private PlayList playlist;
  private Scanner input;

  public PlayListControl() {
    this.playlist = new PlayList();
    this.input = new Scanner(System.in);
  }

  public void setPlayListSize() {
    System.out.println("Enter the size of the playlist (type 0 if unlimited)");
    int size = input.nextInt();
    input.nextLine();
    playlist.setSize(size);
    System.out.println("Playlist size set to " + (size == 0 ? "Unlimited" : size)); // ? is a short hand way for an if-else statement
  }

  public void managePlayList() {
    boolean quit = false;
    while (!quit) {
      System.out.println("\nChoices:");
      System.out.println("1. View Playlist");
      System.out.println("2. Add Song");
      System.out.println("3. Delete Song");
      System.out.println("4. Random Song Picker");
      System.out.println("5. Exit");

      System.out.print("Type your choice >");
      int choice = input.nextInt();
      input.nextLine();

      if (choice == 1) {
        playlist.viewPlayList();
      } else if (choice == 2) {
        addSong();
      } else if (choice == 3) {
        deleteSong();
      } else if (choice == 4) {
        randomSongPicker();
      } else if (choice == 5) {
        quit = true;
        System.out.println("Exiting...");
      } else {
        System.out.println("Error!");
      }
    }
  }

  private void addSong() {
    System.out.print("Type the song name > ");
    String name = input.nextLine();

    System.out.print("Type the artist name > ");
    String artist = input.nextLine();

    playlist.addSong(new Song(name, artist));
    System.out.print("Song added!");
  }

  private void deleteSong() {
    System.out.println("Type the number in the list of the song to delete > ");
    int list = input.nextInt();
    input.nextLine();

    if (list == 0) {
      System.out.println("Cancelled...");
    } else if (playlist.deleteSong(list - 1)) {
      System.out.println("Song deleted...");
    } else {
      System.out.println("Error (wrong number inputted)");
    }
  }

  private void randomSongPicker() {
    String randomSong = RandomSongGenerator.getRandomSong();
    System.out.println("Randomly picked song: " + randomSong);
    System.out.print("Add this song to the playlist? type yes or no): ");

    String response = input.next().toLowerCase();
    input.nextLine();

    if (response.equals("yes")) {
      String[] songInfo = randomSong.split(" by ");
      if (songInfo.length == 2) {
        playlist.addSong(new Song(songInfo[0], songInfo[1]));
        System.out.println("Song added to the playlist!");
      } else {
        System.out.println("Not added. Add both the name and artist when prompted");
      }
    } else {
      System.out.println("Song not added to the playlist.");
    }
  }
}
