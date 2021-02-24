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
    public void insertLink(@Param("url") String url, @Param("aud_date") Date aud_date){
        List<Links> lista = this.getOneFromLink(url);
        if(lista.size()==0){
            repository.insertLink(url, aud_date,1);
        }else{
            this.updateLink(url, aud_date, lista.get(0).getContador()+1);
        }
    }


    @Override
    public void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date,
            @Param("contador") Integer contador) {
        repository.updateLink(url, aud_date, contador);
    }

    
}
