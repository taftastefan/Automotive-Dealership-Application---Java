/** Clasa pentru aplicarea functiile necesare Clientilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Services;

import com.example.ProiectAWJ.Repository.ClientRepository;
import com.example.ProiectAWJ.models.Client;

import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteById(int idClient) {
        clientRepository.deleteById(idClient);
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    public Client findById(int idClient) {
        return clientRepository.findById(idClient);
    }
}
