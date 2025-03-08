/** Clasa pentru functiile necesare Masinilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Masina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasinaRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Masina> findAll() {
        List<Masina> masinaList = new ArrayList<>();
        String query = """
            SELECT 
                masina.idmasina, 
                masina.an_fabricatie, 
                masina.kilometraj, 
                masina.pret, 
                masina.stare, 
                masina.iddealer,            -- Include iddealer
                masina.idmodel,             -- Include idmodel
                dealer.nume AS dealer_nume, 
                model.denumire AS model_nume 
            FROM masina
            JOIN dealer ON masina.iddealer = dealer.iddealer
            JOIN model ON masina.idmodel = model.idmodel
        """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Masina masina = new Masina(
                        resultSet.getInt("idmasina"),
                        resultSet.getInt("an_fabricatie"),
                        resultSet.getInt("kilometraj"),
                        resultSet.getString("pret"),
                        resultSet.getString("stare"),
                        resultSet.getInt("iddealer"),         // Citește iddealer
                        resultSet.getInt("idmodel"),          // Citește idmodel
                        resultSet.getString("dealer_nume"),   // Numele dealerului
                        resultSet.getString("model_nume")     // Numele modelului
                );
                masinaList.add(masina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masinaList;
    }


    public void deleteById(int idMasina) {
        String query = "DELETE FROM masina WHERE idmasina = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMasina);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMasina(Masina masina) {
        String query = "INSERT INTO masina (an_fabricatie, kilometraj, pret, stare, iddealer, idmodel) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, masina.getAnFabricatie());
            statement.setInt(2, masina.getKilometraj());
            statement.setString(3, masina.getPret());
            statement.setString(4, masina.getStare());
            statement.setInt(5, masina.getIdDealer());
            statement.setInt(6, masina.getIdModel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMasina(Masina masina) {
        String query = "UPDATE masina SET an_fabricatie = ?, kilometraj = ?, pret = ?, stare = ?, iddealer = ?, idmodel = ? WHERE idmasina = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, masina.getAnFabricatie());
            statement.setInt(2, masina.getKilometraj());
            statement.setString(3, masina.getPret());
            statement.setString(4, masina.getStare());
            statement.setInt(5, masina.getIdDealer());
            statement.setInt(6, masina.getIdModel());
            statement.setInt(7, masina.getIdMasina());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Masina findById(int idMasina) {
        String query = """
        SELECT 
            masina.idmasina, 
            masina.an_fabricatie, 
            masina.kilometraj, 
            masina.pret, 
            masina.stare, 
            masina.iddealer, 
            masina.idmodel, 
            dealer.nume AS dealer_nume, 
            model.denumire AS model_denumire
        FROM masina
        JOIN dealer ON masina.iddealer = dealer.iddealer
        JOIN model ON masina.idmodel = model.idmodel
        WHERE masina.idmasina = ?
    """;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idMasina);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Masina(
                            resultSet.getInt("idmasina"),
                            resultSet.getInt("an_fabricatie"),
                            resultSet.getInt("kilometraj"),
                            resultSet.getString("pret"),
                            resultSet.getString("stare"),
                            resultSet.getInt("iddealer"),
                            resultSet.getInt("idmodel"),
                            resultSet.getString("dealer_nume"),   // Dealer Name
                            resultSet.getString("model_denumire") // Model Name
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

