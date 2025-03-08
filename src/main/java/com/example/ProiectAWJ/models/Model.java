/** Clasa pentru obtinerea datelor din tabela Model
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.models;

public class Model {
    private int idModel;
    private String denumire;

    public Model() {
    }

    public Model(int idModel, String denumire) {
        this.idModel = idModel;
        this.denumire = denumire;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Model{" +
                "idModel=" + idModel +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}
