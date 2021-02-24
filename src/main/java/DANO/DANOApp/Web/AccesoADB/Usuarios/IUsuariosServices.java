package DANO.DANOApp.Web.AccesoADB.Usuarios;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface IUsuariosServices {
    
    List<Usuarios> getOneFromUsuarios(String mail);

    List<Usuarios> getAllFromUsuarios();

    void insertUsuarios(@Param("mail") String mail, @Param("password") String password,@Param("alias") String alias);

    void updateUsuarios(@Param("mail") String mail, @Param("password") String password, @Param("alias") String alias);

}
