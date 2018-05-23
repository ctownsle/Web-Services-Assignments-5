package assignment5

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*

@Transactional
class SongController extends RestfulController {
    static responseFormats = ['json']
    SongController() {
        super(Song)
    }

    def index(){
        render Song.findAll() as JSON
    }


}
