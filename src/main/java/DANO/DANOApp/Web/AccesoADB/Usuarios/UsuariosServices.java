package DANO.DANOApp.Web.AccesoADB.Usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServices implements IUsuariosServices{

    @Autowired
    private UsuariosRepository repository;

    @Override
    public List<Usuarios> getOneFromUsuarios(String mail){
        List<Usuarios> lista = repository.getOneFromUsuarios(mail);
        return lista;
    }

    @Override
    public List<Usuarios> getAllFromUsuarios() {
        List<Usuarios> lista = repository.getAllFromUsuarios();
        return lista;
    }

    @Override
    public void insertUsuarios(@Param("mail") String mail, @Param("password") String password, @Param("alias") String alias) {
        List<Usuarios> lista = this.getOneFromUsuarios(mail);
        if (lista.size() == 0) {
            repository.insertUsuarios(mail, password, alias);
        } else {
            this.updateUsuarios(mail, password, alias);
        }
    }

    @Override
    public void updateUsuarios(@Param("mail") String mail, @Param("password") String password, @Param("alias") String alias) {
            repository.updateUsuarios(mail, password, alias);
    }
    
}
