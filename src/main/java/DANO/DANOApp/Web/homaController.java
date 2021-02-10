package DANO.DANOApp.Web;

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

	@RequestMapping("/video")
	public String video(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getVideo(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
	}

    @RequestMapping("/web")
    public String web(@RequestParam("data") String url) {

        String html = servicesHomeVar.getFrame(url);
        linksServices.insertLink(url, new Date(System.currentTimeMillis()));

        return html;
    }

    @RequestMapping("/home")
    public String home() {

        String html = servicesHomeVar.getHome();

        return html;
    }

    @RequestMapping("/prueba")
    public String prueba(){
        List<Links> links = (List<Links>) linksServices.getAllFromLink();
        return links.toString();
    }

    @RequestMapping("/spAlbum")
    public String spotifyAlbum(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifyAlbum(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }

    @RequestMapping("/spSong")
    public String spotifySong(@RequestParam("data") String itemid) {

        String html = servicesHomeVar.getSpotifySong(itemid);
        linksServices.insertLink(itemid, new Date(System.currentTimeMillis()));

        return html;
    }

}