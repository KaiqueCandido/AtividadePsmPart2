/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.web.pdm.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaiqu
 */
@XmlRootElement
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Mensagem> mensagens;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pessoa> contatos;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, Login login, List<Mensagem> mensagens, List<Pessoa> contatos) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.mensagens = mensagens;
        this.contatos = contatos;
    }

    public Pessoa(int id, String nome, String email, Login login, List<Mensagem> mensagens, List<Pessoa> contatos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.mensagens = mensagens;
        this.contatos = contatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Pessoa> getContatos() {
        return contatos;
    }

    public void setContatos(List<Pessoa> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", login=" + login + ", mensagens=" + mensagens + ", contatos=" + contatos + '}';
    }

}
