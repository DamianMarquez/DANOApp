package DANO.DANOApp.Web.AccesoADB.Links;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class LinksServices implements ILinksServices {

    @Autowired
    private LinksRepository repository;


    @Override
    public List<Links> getOneFromLink(String url_completa){
        List<Links> links = (List<Links>) repository.getOneFromLink(url_completa);
        return links;
    }

    @Override
    public List<Links> getOneFromLinkId(String url) {
        List<Links> links = (List<Links>) repository.getOneFromLinkId(url);
        return links;
    }

    @Override
    public List<Links> getAllFromLink(){
        List<Links> links = (List<Links>) repository.getAllFromLink();
        return links;
     
    }
/*
    @Override
    public Links insertLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("url_completa") String url_completa,boolean esCreadorDeURL,
            @Param("tipo") Integer tipo){
        List<Links> lista = this.getOneFromLink(url);
        
        if(lista.size()==0){
            repository.insertLink(url, aud_date,1, url_completa,tipo);
            return this.getOneFromLink(url).get(0);
        }else{
            if(!esCreadorDeURL){
                this.updateLink(url, aud_date, lista.get(0).getContador()+1, lista.get(0).getUrl_completa());
                return lista.get(0);
            }
            ret,urn null;
        }
    }

*/

    @Override
    public Links insertLinkCompleta(@Param("url") String url) {

        List<Links> lista = this.getOneFromLink(url);
        Date aud_date = new Date(System.currentTimeMillis());

        if (lista.size() == 0) {
            String [] resultado = getPrincipalPage(url);
            if(resultado == null){
                repository.insertLink("", aud_date, 1, url, 1);
            }else{
                repository.insertLink(resultado[1], aud_date, 1, url, Integer.parseInt(resultado[0]));
            }
            lista = this.getOneFromLink(url);
            resultado = getPrincipalPage(url);
            repository.updateLink(resultado[1], aud_date, 1, url);
            return this.getOneFromLink(url).get(0);
        } else {
                this.updateLink(lista.get(0).getUrl(), aud_date, lista.get(0).getContador() + 1, lista.get(0).getUrl_completa());
                return lista.get(0);
        }
    }

    @Override
    public Links insertLinkId(@Param("url") String url) {

        List<Links> lista = this.getOneFromLinkId(url);
        Date aud_date = new Date(System.currentTimeMillis());
        if (lista.size() == 0) {
            return null;
        } else {
            this.updateLink(lista.get(0).getUrl(), aud_date, lista.get(0).getContador() + 1,
                    lista.get(0).getUrl_completa());
            return lista.get(0);
        }
    }
    

    @Override
    public void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date,
            @Param("contador") Integer contador,@Param("url_completa") String url_completa) {
        repository.updateLink(url, aud_date, contador, url_completa);
    }


    private String[] getPrincipalPage(String link) {

        String [] resultado = new String[2];
        String[] temporal;
        String id2;

        if (link.contains("www.youtube.com")) {
            temporal = link.split("v=");
            id2 = temporal[1].split("&")[0];
            resultado[0]="2";
            resultado[1] = "/video?data=" + id2;
            return resultado;
        }
        if (link.contains("https://open.spotify.com/album")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("album")[1].split("/")[1];
            resultado[0] = "3";
            resultado[1] = "/spAlbum?data=" + id2;
            return resultado;
        }
        if (link.contains("https://open.spotify.com/track")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("track")[1].split("/")[1];
            resultado[0] = "4";
            resultado[1] = "/spSong?data=" + id2;
            return resultado;
        }
        if (link.contains("https://open.spotify.com/show")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("show")[1].split("/")[1];
            resultado[0] = "5";
            resultado[1] = "/spShow?data=" + id2;
            return resultado;
        }
        if (link.contains("https://open.spotify.com/episode")) {
            temporal = link.split("\\?");
            id2 = temporal[0].split("episode")[1].split("/")[1];
            resultado[0] = "6";
            resultado[1] = "/spShowEpisode?data=" + id2;
            return resultado;
        }
        List<Links> lista = repository.getOneFromLink(link);

        if (lista.size() == 0) {
            return null;
        }
        resultado[0] = "1";
        resultado[1] = "/web?data=w" + lista.get(0).getId();
        return resultado;
    }
    
}
