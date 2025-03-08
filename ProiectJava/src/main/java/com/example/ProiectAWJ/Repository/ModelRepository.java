/** Clasa pentru functiile necesare Modelelor de masini
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Model> findAll() {
        List<Model> modelList = new ArrayList<>();
        String query = "SELECT idmodel, denumire FROM model";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Model model = new Model(
                        resultSet.getInt("idmodel"),
                        resultSet.getString("denumire")
                );
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }
}
