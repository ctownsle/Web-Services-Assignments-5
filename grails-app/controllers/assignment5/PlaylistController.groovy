package assignment5

import com.fasterxml.jackson.databind.ObjectMapper
import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*

@Transactional
class PlaylistController extends RestfulController {
    static responseFormats = ['json']
    PlaylistController() {
        super(Playlist)
    }

    def index(){
        render Playlist.findAll() as JSON
    }

    def save(){
        def mapper = new ObjectMapper()
        def playlist = mapper.readValue(request.reader.text, Playlist.class)

        if(Playlist.find(playlist) == null){
            playlist.save(failOnError: true)
            render playlist as JSON
        } else {
            render "Playlist already exists"
        }
    }

    def delete(){
        def playlist = Playlist.get(params.id)

        playlist.delete(failOnError: true)

        render "Playlist Deleted Successfully"
    }

    def getSongs(){
        def playlist = Playlist.get(params.id)

        render playlist.songs as JSON
    }

    def addSong(){
        def mapper = new ObjectMapper()
        def playlist = Playlist.get(params.id)

        def songId = mapper.readValue(request.reader.text, SongIdHolder.class)
//        println(songId)
        def song = Song.get(songId.id)

        playlist.addToSongs(song).save(failOnError: true)

        render "Song Successfully Added To Playlist"
    }

    def deleteSong(){
        def playlist = Playlist.get(params.id)
        def song = Song.get(params.songId)

        playlist.removeFromSongs(song)

        render "Song Deleted From Playlist Successfully"

    }
}
