/** Clasa pentru functiile necesare Clientilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Repository;

import com.example.ProiectAWJ.models.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private final String username = "postgres";
    private final String password = "parola123";
    private final String url = "jdbc:postgresql://localhost:5432/DealershipAuto";

    public List<Client> findAll() {
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT idclient, nume, prenume, email, telefon FROM client");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("idclient"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("email"),
                        resultSet.getString("telefon")
                );
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    public void deleteById(int idClient) {
        String query = "DELETE FROM client WHERE idclient = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idClient);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        String query = "INSERT INTO client (nume, prenume, email, telefon) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelefon());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        String query = "UPDATE client SET nume = ?, prenume = ?, email = ?, telefon = ? WHERE idclient = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelefon());
            statement.setInt(5, client.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client findById(int idClient) {
        String query = "SELECT idclient, nume, prenume, email, telefon FROM client WHERE idclient = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idClient);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Client(
                            resultSet.getInt("idclient"),
                            resultSet.getString("nume"),
                            resultSet.getString("prenume"),
                            resultSet.getString("email"),
                            resultSet.getString("telefon")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

