/** Clasa pentru obtinerea datelor din tabela Vanzare
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.models;

public class Vanzare {
    private int idVanzare;
    private String dataVanzare;
    private String pretFinal;
    private int idClient;       // ID Client pentru JOIN
    private int idMasina;       // ID Masina pentru JOIN
    private int idAngajat;      // ID Angajat pentru JOIN
    private String clientNume;  // Numele clientului
    private String modelNume;   // Modelul mașinii
    private String angajatNume; // Numele angajatului

    public Vanzare() {
    }

    public Vanzare(int idVanzare, String dataVanzare, String pretFinal, int idClient, int idMasina, int idAngajat,
                   String clientNume, String modelNume, String angajatNume) {
        this.idVanzare = idVanzare;
        this.dataVanzare = dataVanzare;
        this.pretFinal = pretFinal;
        this.idClient = idClient;
        this.idMasina = idMasina;
        this.idAngajat = idAngajat;
        this.clientNume = clientNume;
        this.modelNume = modelNume;
        this.angajatNume = angajatNume;
    }

    public int getIdVanzare() {
        return idVanzare;
    }

    public void setIdVanzare(int idVanzare) {
        this.idVanzare = idVanzare;
    }

    public String getDataVanzare() {
        return dataVanzare;
    }

    public void setDataVanzare(String dataVanzare) {
        this.dataVanzare = dataVanzare;
    }

    public String getPretFinal() {
        return pretFinal;
    }

    public void setPretFinal(String pretFinal) {
        this.pretFinal = pretFinal;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getClientNume() {
        return clientNume;
    }

    public void setClientNume(String clientNume) {
        this.clientNume = clientNume;
    }

    public String getModelNume() {
        return modelNume;
    }

    public void setModelNume(String modelNume) {
        this.modelNume = modelNume;
    }

    public String getAngajatNume() {
        return angajatNume;
    }

    public void setAngajatNume(String angajatNume) {
        this.angajatNume = angajatNume;
    }

    @Override
    public String toString() {
        return "Vanzare{" +
                "idVanzare=" + idVanzare +
                ", dataVanzare='" + dataVanzare + '\'' +
                ", pretFinal='" + pretFinal + '\'' +
                ", idClient=" + idClient +
                ", idMasina=" + idMasina +
                ", idAngajat=" + idAngajat +
                ", clientNume='" + clientNume + '\'' +
                ", modelNume='" + modelNume + '\'' +
                ", angajatNume='" + angajatNume + '\'' +
                '}';
    }
}
