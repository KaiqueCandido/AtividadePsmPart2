package com.example.kaiqu.exercicio_pdm_part2.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by kaiqu on 08/08/2016.
 */
public class Pessoa implements Parcelable{

    private int id;
    private String nome;
    private String email;
    private Login login;
    private List<Mensagem> mensagens;
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

    protected Pessoa(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        email = in.readString();
        contatos = in.createTypedArrayList(Pessoa.CREATOR);
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

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
        return this.contatos;
    }

    public void setContatos(List<Pessoa> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(email);
        parcel.writeTypedList(contatos);
    }

}
