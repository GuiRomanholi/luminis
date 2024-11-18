package br.com.luminis.models;

public class CustoEnergia {

    private String id_custo;
    private double custo_kwh;
    private double fator_emi_co2;


    //Getters e Setters
    public String getId_custo() {
        return id_custo;
    }

    public void setId_custo(String id_custo) {
        this.id_custo = id_custo;
    }

    public double getCusto_kwh() {
        return custo_kwh;
    }

    public void setCusto_kwh(double custo_kwh) {
        this.custo_kwh = custo_kwh;
    }

    public double getFator_emi_co2() {
        return fator_emi_co2;
    }

    public void setFator_emi_co2(double fator_emi_co2) {
        this.fator_emi_co2 = fator_emi_co2;
    }
}
