/** Clasa pentru gestiunea paginii Login
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private static Map<String, String> credentials = new HashMap<>();

    @GetMapping("/")
    public String loginPage() {
        return "index";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("url") String url,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) {
        // Salvați acreditările pentru a fi folosite de alți utilizatori
        credentials.put("url", url);
        credentials.put("username", username);
        credentials.put("password", password);

        // Testeaza conexiunea
        try (var connection = java.sql.DriverManager.getConnection(url, username, password)) {
            model.addAttribute("message", "Login realizat cu succes!");
            return "menu";
        } catch (Exception e) {
            model.addAttribute("error", "Acreditări nevalide sau conexiune a eșuat.");
            return "index";
        }

    }


    public static Map<String, String> getCredentials() {
        return credentials;
    }
}

