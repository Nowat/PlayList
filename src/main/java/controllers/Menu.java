package controllers;

import controllers.Playlist;
import models.Song;

import java.io.*;
import java.util.Scanner;

public class Menu
{

    private Scanner scan = new Scanner(System.in);
    private Playlist playlist = new Playlist();


    public int showMenu()
    {
        int selection;

        System.out.print("\nCo chcesz zrobic?"
                + "\n1- Dodaj nazwe piosenki albo filmu"+ "\n2- Pokaz playliste"
                + " \n3- Wyjscie" + "\nWybrano: ");
        selection = scan.nextInt();
        System.out.print("\n");

        return selection;
    }


    public void runMenu()
    {

        int selection = showMenu();

        switch (selection) {
            case 1:
                addSong();
                savePlaylist();
                runMenu();
                break;
            case 2:
                viewPlaylist();
                runMenu();
                break;

            default:
                System.out.println("\nThat is not a valid selection!\n");
                runMenu();
        }

    }


    public void addSong()
    {
        Song newSong = new Song(null, null);
        newSong.setSongsName(scan.nextLine());
        System.out.print("Wpisz nazwe piosenki: ");
        newSong.setSongsName(scan.nextLine());

        playlist.addSong(newSong);
    }


    public void viewPlaylist()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylista pusta!");
        }
        else
        {
            for(int i = 0; i < playlist.getPlaylistSize(); i++)
            {
                System.out.print("\n#" + (i+1) + " ");
                System.out.print(""+ playlist.getSongsName(i) + " - ");

            }
            System.out.print("\n");
        }
    }
    public void savePlaylist()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist");

            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Brak pliku");
        }
        catch(IOException ioException)
        {
            System.out.println("");
        }

    }
    public void loadPlaylist()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("playlist");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (Playlist)objectInputStream.readObject();

            objectInputStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Brak pliku");
        }
        catch(IOException ioException)
        {
            System.out.println("IO zly");
        }

        catch(ClassNotFoundException cnfException)
        {
            System.out.println("To nie playlista.");
        }

    }




}