import java.util.ArrayList;

public class PlayList {
  private ArrayList<Song> songs; // name of the list is Songs and Song is obj (actual song)
  private int size;

  public PlayList() {
    this.songs = new ArrayList<>();
    this.size = 0; // O input will make the list infinite
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void addSong(Song song) {
    if (size == 0 || songs.size() < size) {
      songs.add(song);
    } else {
      System.out.println("Playlist is full!");
    }
  }

  public boolean deleteSong(int list) {
    if (list >= 0 && list < songs.size()) {
      songs.remove(list);
      return true;
    } else {
      System.out.println("Error!");
      return false;
    }
  }

  public void viewPlayList() {
    if (songs.isEmpty()) {
      System.out.println("Playlist is empty!");
    } else {
      System.out.println("\nSongs in playlist:");
      for (int i = 0; i < songs.size(); i++) {
        System.out.println((i + 1) + ". " + songs.get(i).toString());
      }
    }
  }
}
