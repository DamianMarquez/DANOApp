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
    public List<Links> getOneFromLink(String url){
        List<Links> links = (List<Links>) repository.getOneFromLink(url);
        return links;
    }

    @Override
    public List<Links> getAllFromLink(){
        List<Links> links = (List<Links>) repository.getAllFromLink();
        return links;
     
    }

    @Override
    public void insertLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("url_completa") String url_completa,boolean esCreadorDeURL){
        List<Links> lista = this.getOneFromLink(url);

        System.out.println(lista);
        if(lista.size()==0){
            repository.insertLink(url, aud_date,1, url_completa);
        }else{
            if(!esCreadorDeURL){
                this.updateLink(url, aud_date, lista.get(0).getContador()+1, lista.get(0).getUrl_completa());
            }
        }
    }

    @Override
    public String insertLinkWeb(@Param("url") String url, @Param("aud_date") Date aud_date,
            @Param("url_completa") String url_completa, boolean esCreadorDeURL) {
        List<Links> lista = this.getOneFromLink(url);

        System.out.println(lista);
        if (lista.size() == 0) {
            repository.insertLink(url, aud_date, 1, url_completa);
        } else {
            if (!esCreadorDeURL) {
                this.updateLink(url, aud_date, lista.get(0).getContador() + 1, lista.get(0).getUrl_completa());
            }
        }

        return lista.get(0).getUrl_completa();
    }


    @Override
    public void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date,
            @Param("contador") Integer contador,@Param("url_completa") String url_completa) {
        repository.updateLink(url, aud_date, contador, url_completa);
    }

    
}
