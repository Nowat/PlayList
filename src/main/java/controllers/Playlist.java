package controllers;

import models.Song;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {
    private ArrayList<Song> playlist;

// Tworzy playliste
    public Playlist(){
        playlist = new ArrayList<>();
    }
    //Dodaje piosenke do playlisty
    public void addSong(Song song){
        playlist.add(song);
    }
    public int getPlaylistSize()
    {
        return playlist.size();
    }
    public String getArtist(int index)
    {
        return playlist.get(index).getArtist();
    }
    public String getSongsName(int index)
    {
        return playlist.get(index).getSongsName();
    }

}
