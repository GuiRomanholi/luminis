package br.com.luminis.models;

public class Emissao {

    private String id_emi;
    private double  quant_co2_emi;

    //Getters e Setters
    public String getId_emi() {
        return id_emi;
    }

    public void setId_emi(String id_emi) {
        this.id_emi = id_emi;
    }

    public double getQuant_co2_emi() {
        return quant_co2_emi;
    }

    public void setQuant_co2_emi(double quant_co2_emi) {
        this.quant_co2_emi = quant_co2_emi;
    }
}
