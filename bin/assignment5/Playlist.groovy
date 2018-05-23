package assignment5

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Playlist {

    String name

    static constraints = {
        name blank:false
    }

    static hasMany = [songs: Song]
}
