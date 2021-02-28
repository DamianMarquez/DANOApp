package DANO.DANOApp.Web.AccesoADB.Links;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LinksRepository extends CrudRepository<Links, Integer> {
    


    @Query(value="select * from links", nativeQuery=true)
    List<Links> getAllFromLink();


    @Query(value = "select * from links where url_completa = :url_completa", nativeQuery = true)
    List<Links> getOneFromLink(String url_completa);

    @Query(value = "select * from links where url = :url", nativeQuery = true)
    List<Links> getOneFromLinkId(String url);

    @Modifying
    @Query(value = "CALL insert_links(:url,:aud_date,:contador,:url_completa,:tipo)", nativeQuery = true)
    @Transactional
    void insertLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("contador") Integer contador,@Param("url_completa") String url_completa
    ,@Param("tipo") Integer tipo);


    @Modifying
    @Query(value = "CALL update_links(:url,:aud_date,:contador,:url_completa)", nativeQuery = true)
    @Transactional
    void updateLink(@Param("url") String url, @Param("aud_date") Date aud_date, @Param("contador") Integer contador,
            @Param("url_completa") String url_completa);
}
