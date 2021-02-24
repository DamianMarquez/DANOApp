package DANO.DANOApp.Web;

import DANO.DANOApp.Web.AccesoADB.Links.*;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class homaController {

    @Autowired
    ILinksServices linksServices;

    @Autowired
    servicesHome servicesHomeVar;

    @Autowired
    public void setLinksServices(ILinksServices linksServices) {
        this.linksServices = linksServices;
    }


    //HOME DE LA WEB PAGE
    @RequestMapping("/")
    public String homeIndex() {
        return home();
    }

    // HOME DE LA WEB PAGE
    @RequestMapping("/home")
    public String home() {

        String html = servicesHomeVar.getHome();

        return html;
    }


    //ARMADO DE PAGINA DE YOUTUBE
	@RequestMapping("/video")
	public String video(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getVideo(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
	}

    //ARMADI DE POGINA GENERICA WEB
    @RequestMapping("/web")
    public String web(@RequestParam("data") String url) {

        String html = servicesHomeVar.getFrame(url);
        linksServices.insertLink(url, new Date(System.currentTimeMillis()));

        return html;
    }


    // PAGINA PARA PROBAR
    @RequestMapping("/prueba")
    public String prueba(){
        List<Links> links = (List<Links>) linksServices.getAllFromLink();
        return links.toString();
    }


    //ARMADO DE PAGINA DE SPOTIFY - ALBUM
    @RequestMapping("/spAlbum")
    public String spotifyAlbum(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyAlbum(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - CANCION
    @RequestMapping("/spSong")
    public String spotifySong(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifySong(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - SHOW DE PODCAST
    @RequestMapping("/spShow")
    public String spotifyShow(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyShow(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - EPISODIO DEL PODCAST
    @RequestMapping("/spShowEpisode")
    public String spotifyShowEpisode(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyShowEpisode(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }
    

}