package assignment5

import grails.test.hibernate.HibernateSpec

class SongSpec extends HibernateSpec  {

    void 'test domain class validation'(){
        when: 'A domain class is saved with invalid data'
        Song s = new Song(title: '', artist: '')
        s.save()

        then: 'KMS'
        s.hasErrors()
        s.errors.getFieldError('title')
        s.errors.getFieldError('artist')
        Song.count() == 0

        when: 'Valid domain'
        s.title = 'jeff'
        s.artist = 'name'
        s.save()

        then: 'Successful save'
        Song.count() == 1
    }
}
