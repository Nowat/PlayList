package models;

public class Song {
    private String songsName;
    private String artist;

    public Song(String songsName, String artist) {
        this.songsName = songsName;
        this.artist = artist;
    }

    public String getSongsName() {
        return songsName;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
