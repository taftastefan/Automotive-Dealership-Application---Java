/** Clasa pentru obtinerea datelor din tabela Angajat
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.models;

public class Angajat {
    private int idAngajat;
    private String nume;
    private String prenume;

    public Angajat() {
    }

    public Angajat(int idAngajat, String nume, String prenume) {
        this.idAngajat = idAngajat;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "idAngajat=" + idAngajat +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}

