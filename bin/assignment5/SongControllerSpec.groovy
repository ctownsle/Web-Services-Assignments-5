package assignment5

import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import grails.plugin.json.view.mvc.JsonViewResolver

class SongControllerSpec extends HibernateSpec implements ControllerUnitTest<SongController> {

   static doWithSpring = {
       jsonSmartViewResolver(JsonViewResolver)
   }

    void setup() {

        Song.saveAll(
                 new Song(title: 'Jeff', artist: 'Jeff'),
                 new Song(title: 'nameJeff', artist: 'Jeffname')
        )

    }

    void 'test the search action finds results'() {
        when: 'A query is executed that finds results'
        controller.save()

        then: 'The response is correct'
        response.json.size() == 1
    }
}