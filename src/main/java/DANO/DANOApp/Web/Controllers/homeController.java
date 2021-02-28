package DANO.DANOApp.Web.Controllers;

import DANO.DANOApp.Web.AccesoADB.Links.ILinksServices;
import DANO.DANOApp.Web.AccesoADB.Links.Links;

import org.springframework.web.bind.annotation.RestController;


import DANO.DANOApp.Web.Services.*;
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
        Links link = linksServices.insertLinkCompleta(url);        
        return link.getUrl();
    }

    // ARMADO DE PAGINA DE YOUTUBE
    @RequestMapping("/video")
    public String video(@RequestParam("data") String itemid) {
        Links link = linksServices.insertLinkId("/video?data=" + itemid);
        String html = servicesHomeVar.getVideo(itemid);
        return html;
    }

    // ARMADI DE POGINA GENERICA WEB
    @RequestMapping("/web")
    public String web(@RequestParam("data") String url) {
        Links link = linksServices.insertLinkId("/web?data=" + url);
        String html = servicesHomeVar.getFrame(link.getUrl_completa());       
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
        Links link = linksServices.insertLinkId("/spAlbum?data=" + itemid);
        String html = servicesHomeVar.getSpotifyAlbum(itemid);        
        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - CANCION
    @RequestMapping("/spSong")
    public String spotifySong(@RequestParam("data") String itemid) {
        Links link = linksServices.insertLinkId("/spSong?data=" + itemid);
        String html = servicesHomeVar.getSpotifySong(itemid);
        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - SHOW DE PODCAST
    @RequestMapping("/spShow")
    public String spotifyShow(@RequestParam("data") String itemid) {
        Links link = linksServices.insertLinkId("/spShow?data=" + itemid);
        String html = servicesHomeVar.getSpotifyShow(itemid);
        return html;
    }

    // ARMADO DE PAGINA DE SPOTIFY - EPISODIO DEL PODCAST
    @RequestMapping("/spShowEpisode")
    public String spotifyShowEpisode(@RequestParam("data") String itemid) {
        Links link = linksServices.insertLinkId("/spShowEpisode?data=" + itemid);
        String html = servicesHomeVar.getSpotifyShowEpisode(itemid);
        return html;
    }

}