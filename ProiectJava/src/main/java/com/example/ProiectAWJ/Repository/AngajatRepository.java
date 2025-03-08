/** Clasa pentru functiile necesare Angajatilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Angajat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AngajatRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Angajat> findAll() {
        List<Angajat> angajatList = new ArrayList<>();
        String query = "SELECT idangajat, nume, prenume FROM angajat";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Angajat angajat = new Angajat(
                        resultSet.getInt("idangajat"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume")
                );
                angajatList.add(angajat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return angajatList;
    }
}
