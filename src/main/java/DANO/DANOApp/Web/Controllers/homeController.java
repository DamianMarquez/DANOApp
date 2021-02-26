package DANO.DANOApp.Web.Controllers;

import DANO.DANOApp.Web.AccesoADB.Links.ILinksServices;
import DANO.DANOApp.Web.AccesoADB.Links.Links;

import org.springframework.web.bind.annotation.RestController;


import DANO.DANOApp.Web.Services.*;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class homeController {

    @Autowired
    ILinksServices linksServices;

    @Autowired
    servicesHome servicesHomeVar;

    @Autowired
    public void setLinksServices(ILinksServices linksServices) {
        this.linksServices = linksServices;
    }

    // HOME DE LA WEB PAGE
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

    // ARMADO DE PAGINA DE YOUTUBE
    @RequestMapping("/makeURL")
    public String makeURL(@RequestParam("data") String url) {
        String html = servicesHomeVar.getPrincipalPage(url);
        System.out.println("URL: " + url);
        linksServices.insertLink(html, new Date(System.currentTimeMillis()), url, true);
        return html;
    }

    // ARMADO DE PAGINA DE YOUTUBE
    @RequestMapping("/video")
    public String video(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getVideo(itemid);
        linksServices.insertLink("/video?data=" + itemid, new Date(System.currentTimeMillis()), itemid, false);
        System.out.println(itemid);

        return html;
    }

    // ARMADI DE POGINA GENERICA WEB
    @RequestMapping("/web")
    public String web(@RequestParam("data") String url) {

        String url_completa = linksServices.insertLinkWeb("/web?data=" + url, new Date(System.currentTimeMillis()), url, false);
        String html = servicesHomeVar.getFrame(url_completa);
        

        return html;
    }

    // PAGINA PARA PROBAR
    @RequestMapping("/prueba")
    public String prueba() {
        List<Links> links = (List<Links>) linksServices.getAllFromLink();
        return links.toString();
    }

    // ARMADO DE PAGINA DE SPOTIFY - ALBUM
    @RequestMapping("/spAlbum")
    public String spotifyAlbum(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyAlbum(itemid);
        linksServices.insertLink("/spAlbum?data=" + itemid, new Date(System.currentTimeMillis()), itemid, false);

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - CANCION
    @RequestMapping("/spSong")
    public String spotifySong(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifySong(itemid);
        linksServices.insertLink("/spSong?data=" + itemid, new Date(System.currentTimeMillis()), itemid, false);

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - SHOW DE PODCAST
    @RequestMapping("/spShow")
    public String spotifyShow(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyShow(itemid);
        linksServices.insertLink("/spShow?data=" + itemid, new Date(System.currentTimeMillis()), itemid, false);

        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - EPISODIO DEL PODCAST
    @RequestMapping("/spShowEpisode")
    public String spotifyShowEpisode(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyShowEpisode(itemid);
        linksServices.insertLink("/spShowEpisode?data=" + itemid, new Date(System.currentTimeMillis()), itemid, false);

        return html;
    }

}