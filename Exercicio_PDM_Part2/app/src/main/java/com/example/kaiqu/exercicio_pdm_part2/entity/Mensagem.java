package com.example.kaiqu.exercicio_pdm_part2.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kaiqu on 08/08/2016.
 */
public class Mensagem implements Parcelable{

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

    protected Mensagem(Parcel in) {
        id = in.readInt();
        idRemetente = in.readInt();
        mensagem = in.readString();
        idDestinatario = in.readInt();
    }

    public static final Creator<Mensagem> CREATOR = new Creator<Mensagem>() {
        @Override
        public Mensagem createFromParcel(Parcel in) {
            return new Mensagem(in);
        }

        @Override
        public Mensagem[] newArray(int size) {
            return new Mensagem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(idRemetente);
        parcel.writeString(mensagem);
        parcel.writeInt(idDestinatario);
    }
}
