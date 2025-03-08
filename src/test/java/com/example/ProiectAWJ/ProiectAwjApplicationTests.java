package com.example.ProiectAWJ;

import com.example.ProiectAWJ.Repository.ClientRepository;
import com.example.ProiectAWJ.models.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProiectAwjApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Test de bază pentru încărcarea contextului aplicației.
	 */
	@Test
	void contextLoads() {
		assertNotNull(restTemplate);
		assertNotNull(clientRepository);
	}

	/**
	 * Test pentru endpoint-ul principal de login.
	 */
	@Test
	void testLoginEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("Login")); // Verificăm că pagina de login se încarcă
	}

	/**
	 * Test pentru afișarea clienților (endpoint: /showClienti).
	 * Simulează existența unor clienți în baza de date.
	 */
	@Test
	void testShowClienti() {
		// Adăugăm un client de test
		Client testClient = new Client("Ion", "Popescu", "ion@example.com", "0712345678");
		clientRepository.addClient(testClient);

		// Verificăm că endpoint-ul funcționează
		ResponseEntity<String> response = restTemplate.getForEntity("/showClienti", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("Ion")); // Verificăm că clientul este afișat
	}

	/**
	 * Test pentru adăugarea unui client (POST /client/add).
	 */
	@Test
	void testAddClient() {
		// Datele clientului de test
		Client newClient = new Client("Maria", "Ionescu", "maria@example.com", "0723456789");

		// Trimiterea cererii POST pentru a adăuga clientul
		ResponseEntity<String> response = restTemplate.postForEntity("/client/add", newClient, String.class);
		assertEquals(HttpStatus.FOUND, response.getStatusCode()); // Redirecționare după succes

		// Verificăm că clientul a fost adăugat
		List<Client> clients = clientRepository.findAll();
		assertTrue(clients.stream().anyMatch(client -> client.getEmail().equals("maria@example.com")));
	}

	/**
	 * Test pentru ștergerea unui client (GET /client/delete/{idClient}).
	 */
	@Test
	void testDeleteClient() {
		// Adăugăm un client de test
		Client testClient = new Client("Test", "Client", "test@example.com", "0712345678");
		clientRepository.addClient(testClient);

		// Verificăm că clientul există
		List<Client> clientsBefore = clientRepository.findAll();
		Client existingClient = clientsBefore.stream()
				.filter(client -> client.getEmail().equals("test@example.com"))
				.findFirst()
				.orElse(null);
		assertNotNull(existingClient);

		// Ștergem clientul folosind endpoint-ul
		restTemplate.getForEntity("/client/delete/" + existingClient.getIdClient(), String.class);

		// Verificăm că clientul a fost șters
		List<Client> clientsAfter = clientRepository.findAll();
		assertFalse(clientsAfter.stream().anyMatch(client -> client.getEmail().equals("test@example.com")));
	}
}
