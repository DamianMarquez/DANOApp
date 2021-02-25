package DANO.DANOApp.Web.AccesoADB.Links;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "links")
public class Links {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Integer id;


    @Column(name = "url")
    private String url;

    @Column(name = "aud_date")
    private Date aud_date;


    @Column(name = "contador")
    private Integer contador;

    @Column(name = "url_completa")
    private String url_completa;

    public Links(){
    }

    public Links(String url, String url_completa){
        this.url = url;
        this.url_completa = url_completa;
        this.aud_date = new Date(System.currentTimeMillis());
    }

    // GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getAud_date() {
        return aud_date;
    }

    public void setAud_date(Date aud_date) {
        this.aud_date = aud_date;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
    //OVERRIDES

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.url);
        hash = 79 * hash + Objects.hashCode( this.aud_date);
        hash = 79 * hash + Objects.hashCode(this.contador);
        hash = 79 * hash + Objects.hashCode(this.url_completa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Links other = (Links) obj;
        if (this.aud_date != other.aud_date) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.contador, other.contador)) {
            return false;
        }
        if (!Objects.equals(this.url_completa, other.url_completa)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Link{id=").append(id).append(", URL=").append(url).append(", Aud_Date=").append(aud_date).append(", contador=").append(contador)
                .append(", URL Completa=").append(url_completa).append("}");

        return builder.toString();
    }



}
