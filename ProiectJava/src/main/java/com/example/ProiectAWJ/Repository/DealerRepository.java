/** Clasa pentru functiile necesare Dealerilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Dealer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealerRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Dealer> findAll() {
        List<Dealer> dealerList = new ArrayList<>();
        String query = "SELECT iddealer, nume, adresa, telefon, email FROM dealer";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Dealer dealer = new Dealer(
                        resultSet.getInt("iddealer"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("telefon"),
                        resultSet.getString("email")
                );
                dealerList.add(dealer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealerList;
    }
}
