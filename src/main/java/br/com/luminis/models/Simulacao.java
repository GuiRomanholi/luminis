package br.com.luminis.models;

public class Simulacao {
    private String id_simu;
    private double custoEstimado;
    private double emissaoEstimada;

    public String getId_simu() {
        return id_simu;
    }

    public void setId_simu(String id_simu) {
        this.id_simu = id_simu;
    }

    public double getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(double custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    public double getEmissaoEstimada() {
        return emissaoEstimada;
    }

    public void setEmissaoEstimada(double emissaoEstimada) {
        this.emissaoEstimada = emissaoEstimada;
    }
}
