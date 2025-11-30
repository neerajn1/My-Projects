public class Song {
  private String name;
  private String artist;

  public Song(String name, String artist) {
    this.name = name;
    this.artist = artist;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Artist: " + artist;
  }
}
