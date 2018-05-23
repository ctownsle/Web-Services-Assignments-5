package assignment5

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Song {

    String title
    String artist

    static constraints = {
        title blank: false
        artist blank: false
    }

    static belongsTo = Playlist

}
