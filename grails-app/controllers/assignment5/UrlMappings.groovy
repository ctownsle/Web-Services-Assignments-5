package assignment5

class UrlMappings {

    static mappings = {
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        delete "/playlist/$id" (controller: 'playlist', action: 'delete')
        post "/playlist"(controller: 'playlist', action: "save")
        post "/playlist/$id/song" (controller: 'playlist', action: "addSong")
        get "/playlist/$id/song" (controller: 'playlist', action: "getSongs")
        delete "/playlist/$id/song/$songId" (controller: 'playlist', action: "deleteSong")
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
