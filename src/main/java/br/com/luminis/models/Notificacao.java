package br.com.luminis.models;

import java.util.Date;

public class Notificacao {
    private String id_noti;
    private String conteudo;
    private Date dataEnvio;

    //Getters e Setters
    public String getId_noti() {
        return id_noti;
    }

    public void setId_noti(String id_noti) {
        this.id_noti = id_noti;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
