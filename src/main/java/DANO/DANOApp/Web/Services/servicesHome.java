package DANO.DANOApp.Web.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DANO.DANOApp.Web.AccesoADB.Links.Links;
import DANO.DANOApp.Web.AccesoADB.Links.LinksRepository;

@Service
public class servicesHome {

    
    @Autowired
    private LinksRepository repository;
    
    /**********************************************
     * METODOS PUBLICOS
     **********************************************/

    public String getHome() {
        String html = getHeader("Sitio de Home") + getBottom();
        return html;
    }

    public String getVideo(String id) {
        return getHeader("Sitio de video") + armarYouTube(id) + getYappa() + getBottom();
    }

    public String getFrame(String link) {
        String html = getHeader("Sitio de WebPage") + armarIFrame(link);
        return html;
    }

    public String getSpotifyAlbum(String id) {
        return getHeader("Sitio de Spotify Album") + armarSpotifyAlbum(id) + getYappa() + getBottom();
    }

    public String getSpotifySong(String id) {
        return getHeader("Sitio de Spotify Song") + armarSpotifySong(id) + getYappa() + getBottom();
    }

    public String getSpotifyShow(String id) {
        return getHeader("Sitio de Spotify Song") + armarSpotifyShow(id) + getYappa() + getBottom();
    }

    public String getSpotifyShowEpisode(String id) {
        return getHeader("Sitio de Spotify Song") + armarSpotifyShowEpisode(id) + getYappa() + getBottom();
    }

    /*
    public String getPrincipalPage(Link link) {

        String[] temporal;
        String id2;

        if (link.contains("www.youtube.com")) {
            temporal = link.split("v=");
            id2 = temporal[1].split("&")[0];
            return "/video?data=" +id2;
        }
        if (link.contains("https://open.spotify.com/album")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("album")[1].split("/")[1];
            return "/spAlbum?data=" + id2;
        }
        if (link.contains("https://open.spotify.com/track")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("track")[1].split("/")[1];
            return "/spSong?data=" + id2;
        }
        if (link.contains("https://open.spotify.com/show")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("show")[1].split("/")[1];
            return "/spShow?data=" + id2;
        }
        if (link.contains("https://open.spotify.com/episode")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("episode")[1].split("/")[1];
            return "/spShowEpisode?data=" + id2;
        }

        temporal = link.split("//");
                
        String urlWeb =  "/web?data=" + temporal[1];

        List<Links> lista = repository.getOneFromLink(urlWeb);

        if(lista.size() == 0){
            return null;
        }
        return "/web?data=" + lista.get(0).getId();
    }
    */

    /**********************************************
     * METODOS PRIVADOS
     **********************************************/

    private String armarYouTube(String id) {
        String html = getYoutube(id, "800", "415");
        return html;
    }

    private String armarIFrame(String link) {
        return "<div><iframe width=\"100%\" height=\"86%\" src=\"" + link + "\" frameborder=\"0\" ></iframe></div>"
                + getYappa() + getBottom();

    }

    private String getYoutube(String id, String width, String height) {
        String codigoVideo = id;
        // width 800
        // height 415
        return "<iframe width=\" " + width + " \" height=\" " + height + "\" src=\"https://www.youtube.com/embed/"
                + codigoVideo
                + "\" frameborder=\"0\"        allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\"        allowfullscreen></iframe></div>  ";
    }

    private String getHeader(String titulo) {
        return "<head>  <title>" + titulo
                + "</title>  <meta charset=\"utf-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script></head><body><div class=\"container\" style=\"display:inline;text-align: center\"><div ><div>";
    }

    private String getBottom() {

        String modal = "<input type=\"image\" width=\"45\" height=\"45\" data-toggle=\"modal\" data-target=\"#myHelpModal\" src=\"/images/help.png\"></input></div><div><div class=\"modal fade\" id=\"myHelpModal\" role=\"dialog\"><div class=\"modal-dialog modal-lg\"><div class=\"modal-content\"><div class=\"modal-header\"> <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button><h4 class=\"modal-title\">How to use</h4></div><div class=\"modal-body\"><h1>Copy the link of the YouTube video, Spotify Album or Song or Podcast or Episode, or just a WebPage URL into the Link Input and press Go</h1></div><div class=\"modal-footer\"> <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button></div></div></div></div></div>";

        return armarInput() + modal
                + "<script src=\"/js/jquery.js\"></script> <script src=\"/js/javascript.js\"></script> </body></html>";
    }

    private String getYappa() {
        return "<!-- Trigger the modal with a button -->  <input type=\"image\"  data-toggle=\"modal\" data-target=\"#myModal\" src=\"/images/yappa-logo.png\"  />  <!-- Modal -->  <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">    <div class=\"modal-dialog modal-lg\">      <div class=\"modal-content\">"
                + "<div class=\"modal-header\">          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>          <h4 class=\"modal-title\">Send your Yap</h4>        </div>        <div class=\"modal-body\">     <div id=\"yappa-comments-frame\" data-disable-ads=\"false\" style=\"margin:0;width:100%;height:630\"></div>    <script type=\"text/javascript\" src=\"https://comments.yappaapp.com/embed/yappa-comments.js\"></script>        </div>        <div class=\"modal-footer\">          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>        </div>      </div>    </div>  </div></div></div>";
    }

    private String armarInput() {
        return "<div style=\"text-align: center\"><label for=\"name\">URL del Link:</label> <input type=\"text\" id=\"url\" name=\"url\" required > <button id=\"btnEnviar\">Go</button><button id=\"btnHome\">Home</button>";
    }

    private String armarSpotifyAlbum(String id) {
        String codigoAlbum = id;
        return "<iframe width=\" 300  \" height=\" 380 \" src=\"https://open.spotify.com/embed/album/" + codigoAlbum
                + "\" frameborder=\"0\"        allowtransparency=\"true\" allow=\"encrypted-media\"></iframe>";
    }

    private String armarSpotifySong(String id) {
        String codigoSong = id;
        return "<iframe width=\" 300  \" height=\" 380 \" src=\"https://open.spotify.com/embed/track/" + codigoSong
                + "\" frameborder=\"0\"        allowtransparency=\"true\" allow=\"encrypted-media\"></iframe>";
    }

    private String armarSpotifyShow(String id) {
        String codigoSong = id;
        return "<iframe width=\" 100%  \" height=\" 232 \" src=\"https://open.spotify.com/embed-podcast/show/"
                + codigoSong
                + "\" frameborder=\"0\"        allowtransparency=\"true\" allow=\"encrypted-media\"></iframe>";
    }

    private String armarSpotifyShowEpisode(String id) {
        String codigoSong = id;
        return "<iframe width=\" 100%  \" height=\" 232 \" src=\"https://open.spotify.com/embed-podcast/episode/"
                + codigoSong
                + "\" frameborder=\"0\"        allowtransparency=\"true\" allow=\"encrypted-media\"></iframe>";
    }

}
