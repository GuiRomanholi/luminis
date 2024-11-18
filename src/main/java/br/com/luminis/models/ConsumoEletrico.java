package br.com.luminis.models;

import java.util.Date;

public class ConsumoEletrico {

    private String id_ce;
    private Date date_ce;
    private double quant_kwh_ce;

    //Getters e Setters
    public String getId_ce() {
        return id_ce;
    }

    public void setId_ce(String id_ce) {
        this.id_ce = id_ce;
    }

    public Date getDate_ce() {
        return date_ce;
    }

    public void setDate_ce(Date date_ce) {
        this.date_ce = date_ce;
    }

    public double getQuant_kwh_ce() {
        return quant_kwh_ce;
    }

    public void setQuant_kwh_ce(double quant_kwh_ce) {
        this.quant_kwh_ce = quant_kwh_ce;
    }
}
