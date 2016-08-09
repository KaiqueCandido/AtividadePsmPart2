/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.web.pdm.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaiqu
 */
@XmlRootElement
@Entity
public class Mensagem implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int idRemetente;
    private String mensagem;
    private int idDestinatario;

    public Mensagem() {
    }

    public Mensagem(int idRemetente, String mensagem, int idDestinatario) {
        this.idRemetente = idRemetente;
        this.mensagem = mensagem;
        this.idDestinatario = idDestinatario;
    }

    public Mensagem(int id, int idRemetente, String mensagem, int idDestinatario) {
        this.id = id;
        this.idRemetente = idRemetente;
        this.mensagem = mensagem;
        this.idDestinatario = idDestinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(int idRemetente) {
        this.idRemetente = idRemetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "id=" + id + ", idRemetente=" + idRemetente + ", mensagem=" + mensagem + ", idDestinatario=" + idDestinatario + '}';
    }

}
