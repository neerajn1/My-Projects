import java.util.Scanner;

public class TestPlayList {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Playlist App!");

    PlayListControl playlistControl = new PlayListControl();

    playlistControl.setPlayListSize();
    playlistControl.managePlayList();

    System.out.println("Thanks for using...");

    input.close();

    
  }
}