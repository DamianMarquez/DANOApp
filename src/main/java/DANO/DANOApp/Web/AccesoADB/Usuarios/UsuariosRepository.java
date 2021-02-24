package DANO.DANOApp.Web.AccesoADB.Usuarios;


    
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuariosRepository  extends CrudRepository<Usuarios, Integer> {

    @Query(value = "select * from Usuarios", nativeQuery = true)
    List<Usuarios> getAllFromUsuarios();

    @Query(value = "select * from Usuarios where mail = :mail", nativeQuery = true)
    List<Usuarios> getOneFromUsuarios(String mail);

    @Modifying
    @Query(value = "CALL insert_Usuarios(:mail,:password,:alias)", nativeQuery = true)
    @Transactional
    void insertUsuarios(@Param("mail") String mail, @Param("password") String password, @Param("alias") String alias);

    @Modifying
    @Query(value = "CALL update_Usuarios(:mail,:password,:alias)", nativeQuery = true)
    @Transactional
    void updateUsuarios(@Param("mail") String mail, @Param("password") String password, @Param("alias") String alias);
}
