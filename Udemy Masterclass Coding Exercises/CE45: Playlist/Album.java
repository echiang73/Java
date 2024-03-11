// Basic solution
import java.util.ArrayList;
import java.util.LinkedList;
 
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
 
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }
 
    public boolean addSong(String title, double duration ) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
 
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
         if (trackNumber >= 1) {
            playlist.add(songs.get(trackNumber - 1));
            return true;
        }
        return false;
    }
 
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song == null) {
            return false;
        }
        playlist.add(song);
        return true;
    }
 
    private Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }
        }
        return null;
    }
}