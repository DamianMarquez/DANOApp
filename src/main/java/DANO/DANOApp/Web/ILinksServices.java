package DANO.DANOApp.Web;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ILinksServices {
    
    //List<Links> findByIdGenerico(Integer id);

    List<Links> getOneFromLink(String url);

    List<Links> getAllFromLink();
    void insertLink(@Param("url") String url, @Param("aud_date") Date aud_date);

    void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("contador") Integer contador);
}
