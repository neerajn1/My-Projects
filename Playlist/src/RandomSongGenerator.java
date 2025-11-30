import java.util.Random;

public class RandomSongGenerator {
  private static final String[] listSongs = {
    "A by B",
    "A by B",
    "A by B",
    "A by B",
    "A by B",
    "A by B",
    "A by B",
  };

  public static String getRandomSong() {
    if (listSongs.length == 0) {
      return "Null";
  }

  Random choose  = new Random();
  int chooseIndex = choose.nextInt(listSongs.length);
  return listSongs[chooseIndex];
 }
}