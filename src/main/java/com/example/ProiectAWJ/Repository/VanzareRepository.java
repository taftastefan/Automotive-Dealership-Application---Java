/** Clasa pentru functiile necesare Vanzarilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Vanzare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VanzareRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Vanzare> findAll() {
        List<Vanzare> vanzareList = new ArrayList<>();
        String query = """
            SELECT 
                vanzare.idvanzare, 
                vanzare.data_vanzare, 
                vanzare.pret_final, 
                vanzare.idclient,        -- Include idclient
                vanzare.idmasina,        -- Include idmasina
                vanzare.idangajat,       -- Include idangajat
                client.nume AS client_nume, 
                model.denumire AS model_nume, 
                angajat.nume AS angajat_nume 
            FROM vanzare
            JOIN client ON vanzare.idclient = client.idclient
            JOIN masina ON vanzare.idmasina = masina.idmasina
            JOIN model ON masina.idmodel = model.idmodel
            JOIN angajat ON vanzare.idangajat = angajat.idangajat
        """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Vanzare vanzare = new Vanzare(
                        resultSet.getInt("idvanzare"),
                        resultSet.getString("data_vanzare"),
                        resultSet.getString("pret_final"),
                        resultSet.getInt("idclient"),         // Citește idclient
                        resultSet.getInt("idmasina"),         // Citește idmasina
                        resultSet.getInt("idangajat"),        // Citește idangajat
                        resultSet.getString("client_nume"),   // Numele clientului
                        resultSet.getString("model_nume"),    // Modelul mașinii
                        resultSet.getString("angajat_nume")   // Numele angajatului
                );
                vanzareList.add(vanzare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vanzareList;
    }


    public void deleteById(int idVanzare) {
        String query = "DELETE FROM vanzare WHERE idvanzare = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVanzare);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVanzare(Vanzare vanzare) {
        String query = "INSERT INTO vanzare (data_vanzare, pret_final, idclient, idmasina, idangajat) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vanzare.getDataVanzare()); // Setting as String
            statement.setString(2, vanzare.getPretFinal());
            statement.setInt(3, vanzare.getIdClient());
            statement.setInt(4, vanzare.getIdMasina());
            statement.setInt(5, vanzare.getIdAngajat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVanzare(Vanzare vanzare) {
        String query = "UPDATE vanzare SET data_vanzare = ?, pret_final = ?, idclient = ?, idmasina = ?, idangajat = ? WHERE idvanzare = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vanzare.getDataVanzare()); // Setting as String
            statement.setString(2, vanzare.getPretFinal());
            statement.setInt(3, vanzare.getIdClient());
            statement.setInt(4, vanzare.getIdMasina());
            statement.setInt(5, vanzare.getIdAngajat());
            statement.setInt(6, vanzare.getIdVanzare());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vanzare findById(int idVanzare) {
        String query = """
        SELECT 
            vanzare.idvanzare, 
            vanzare.data_vanzare, 
            vanzare.pret_final, 
            vanzare.idclient,  -- Include ID-ul clientului
            vanzare.idmasina,  -- Include ID-ul mașinii
            vanzare.idangajat, -- Include ID-ul angajatului
            client.nume AS client_nume, 
            model.denumire AS model_nume, 
            angajat.nume AS angajat_nume 
        FROM vanzare
        JOIN client ON vanzare.idclient = client.idclient
        JOIN masina ON vanzare.idmasina = masina.idmasina
        JOIN model ON masina.idmodel = model.idmodel
        JOIN angajat ON vanzare.idangajat = angajat.idangajat
        WHERE vanzare.idvanzare = ?
    """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVanzare);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Vanzare(
                            resultSet.getInt("idvanzare"),
                            resultSet.getString("data_vanzare"),
                            resultSet.getString("pret_final"),
                            resultSet.getInt("idclient"),      // ID-ul clientului
                            resultSet.getInt("idmasina"),      // ID-ul mașinii
                            resultSet.getInt("idangajat"),     // ID-ul angajatului
                            resultSet.getString("client_nume"), // Numele clientului
                            resultSet.getString("model_nume"),  // Numele modelului
                            resultSet.getString("angajat_nume") // Numele angajatului
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
