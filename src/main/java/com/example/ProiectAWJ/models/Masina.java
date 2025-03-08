/** Clasa pentru obtinerea datelor din tabela Masina
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.models;

public class Masina {
    private int idMasina;
    private int anFabricatie;
    private int kilometraj;
    private String pret;
    private String stare;
    private int idDealer;       // ID Dealer pentru JOIN
    private int idModel;        // ID Model pentru JOIN
    private String dealerNume;  // Numele dealerului
    private String modelNume;   // Numele modelului

    public Masina() {
    }

    public Masina(int idMasina, int anFabricatie, int kilometraj, String pret, String stare, int idDealer, int idModel,
                  String dealerNume, String modelNume) {
        this.idMasina = idMasina;
        this.anFabricatie = anFabricatie;
        this.kilometraj = kilometraj;
        this.pret = pret;
        this.stare = stare;
        this.idDealer = idDealer;
        this.idModel = idModel;
        this.dealerNume = dealerNume;
        this.modelNume = modelNume;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getKilometraj() {
        return kilometraj;
    }

    public void setKilometraj(int kilometraj) {
        this.kilometraj = kilometraj;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getStare() {
        return stare;
    }

    public void setStare(String stare) {
        this.stare = stare;
    }

    public int getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(int idDealer) {
        this.idDealer = idDealer;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getDealerNume() {
        return dealerNume;
    }

    public void setDealerNume(String dealerNume) {
        this.dealerNume = dealerNume;
    }

    public String getModelNume() {
        return modelNume;
    }

    public void setModelNume(String modelNume) {
        this.modelNume = modelNume;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "idMasina=" + idMasina +
                ", anFabricatie=" + anFabricatie +
                ", kilometraj=" + kilometraj +
                ", pret='" + pret + '\'' +
                ", stare='" + stare + '\'' +
                ", idDealer=" + idDealer +
                ", idModel=" + idModel +
                ", dealerNume='" + dealerNume + '\'' +
                ", modelNume='" + modelNume + '\'' +
                '}';
    }
}
