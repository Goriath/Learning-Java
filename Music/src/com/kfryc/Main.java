package com.kfryc;

import model.Artist;
import model.Datasource;
import model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);

        if(artists == null){
            System.out.println("No artists in database");;
            return;
        }

        for(Artist artist: artists){
            System.out.println("ID = " + artist.getId() + "  \tName = " + artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_ASC);

        for(String album :albumsForArtist){
            System.out.println(album);
        }


        List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_ASC);
        if(songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists){
            System.out.println("Artist: " + artist.getArtistName() +
                    " \tAlbum name: " + artist.getAlbumName() +
                     " \tTrack: " + artist.getTrack());
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtists();

        songArtists = datasource.querySongInfoView("Go Your Own Way");
        if(songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists){
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " \tAlbum name = " + artist.getArtistName() +
                    " \tTrack number = " + artist.getTrack());
        }

        datasource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);

        datasource.close();
    }
}
