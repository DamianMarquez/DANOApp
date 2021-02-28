package DANO.DANOApp.Web.AccesoADB.Links;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ILinksServices {
    
    List<Links> getOneFromLink(String url);

    List<Links> getOneFromLinkId(@Param("url") String url);

    List<Links> getAllFromLink();
    
//    Links insertLink(@Param("url") String url, @Param("aud_date") Date aud_date,@Param("url_completa") String url_completa,
            //boolean esCreadorDeURL,@Param("tipo") Integer tipo);

    Links insertLinkCompleta(@Param("url") String url);

    Links insertLinkId(@Param("url") String url);
    

    void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("contador") Integer contador,
            @Param("url_completa") String url_completa);

            /*
    Links insertLinkWeb(@Param("url") String url, @Param("aud_date") Date aud_date,@Param("url_completa") String url_completa,
        boolean esCreadorDeURL, @Param("tipo") Integer tipo);
        */
}
