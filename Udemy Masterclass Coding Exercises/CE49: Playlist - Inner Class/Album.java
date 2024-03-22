// Basic solution
import java.util.ArrayList;
import java.util.LinkedList;
 
public class Album {
    private String name;
    private String artist;
    private SongList songs;
 
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }
 
    public boolean addSong(String title, double duration ) {
        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
 
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (songs.findSong(trackNumber) != null) {
            playlist.add(songs.songs.get(trackNumber-1));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songs.findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
        playlist.add(song);
        return true;
    }

    
    public static class SongList {
        private ArrayList<Song> songs;
        
        private SongList() {
            songs = new ArrayList<Song>();
        }
        
        private boolean add(Song songToAdd) {
            if (songs.contains(songToAdd)) {
                return false;
            }
            songs.add(songToAdd);
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
        
        private Song findSong(int trackNumber){
            int index = trackNumber-1;
            if (index >= 0 && index <= songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}


// Alternative solution using enhanced for loop
import java.util.ArrayList;
import java.util.LinkedList;
 
public class Album {
    private String name;
    private String artist;
    private SongList songs;
 
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }
 
    public boolean addSong(String title, double duration ) {
        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
 
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (songs.findSong(trackNumber) != null) {
            playlist.add(songs.songs.get(trackNumber-1));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songs.findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    public static class SongList {
        private ArrayList<Song> songs;
        
        private SongList() {
            songs = new ArrayList<Song>();
        }

        private boolean add(Song songToAdd) {
            if (songs.contains(songToAdd)) {
                return false;
            }
            songs.add(songToAdd);
            return true;
        }
        
        private Song findSong(String title) {
            for (Song song: songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber-1;
            if (index >= 0 && index <= songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}


// Alternative addSong() method using single line return statement
    public boolean addSong(String title, double duration ) {
        return songs.add(new Song(title, duration));
    }


// Alternative addToPlayList() method using variable song set to findSong(int)
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }


// Alternative addToPlayList() method without println
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songs.findSong(trackNumber);
        return song != null && playlist.add(song);
    }


// Alternative inner class add() method, use loop to check if equals instead of contains
        private boolean add(Song songToAdd) {
            for (Song song: songs) {
                if (song.equals(songToAdd)) {
                    return false;
                }
            }
            songs.add(songToAdd);
            return true;
        }


// Alternative inner class findSong() method use loop to check if equals instead of contains
        private Song findSong(int trackNumber){
            int index = trackNumber-1;
            for (Song song: songs) {
                if (index <= songs.size() && song.equals(songs.get(index))) {
                    return song;
                }
            }
            return null;
        }