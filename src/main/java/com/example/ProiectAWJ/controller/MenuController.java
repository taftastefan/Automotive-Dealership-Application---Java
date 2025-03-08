/** Clasa pentru gestiunea meniului si a operatiilor din el
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.controller;

import com.example.ProiectAWJ.Repository.*;
import com.example.ProiectAWJ.Services.*;
import com.example.ProiectAWJ.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {
    private final ClientService clientService = new ClientService(new ClientRepository());
    private final MasinaService masinaService = new MasinaService(new MasinaRepository());
    private final VanzareService vanzareService = new VanzareService(new VanzareRepository());

    @GetMapping("/menu")
    public String menuPage() {
        return "menu";
    }

    // Client Operatii
    @GetMapping("/showClienti")
    public String showClienti(Model model) {
        List<Client> clientiList = clientService.findAll();
        model.addAttribute("clienti", clientiList);
        return "menu";
    }

    @GetMapping("/client/add")
    public String addClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }

    @PostMapping("/client/add")
    public String addClient(@ModelAttribute Client client, Model model) {
        try {
            clientService.addClient(client);
            return "redirect:/showClienti";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while adding the client: " + e.getMessage());
            model.addAttribute("client", client);
            return "addClient";
        }
    }

    @GetMapping("/client/update/{idClient}")
    public String updateClientForm(@PathVariable("idClient") int idClient, Model model) {
        Client client = clientService.findById(idClient);
        if (client != null) {
            model.addAttribute("client", client);
            return "updateClient";
        } else {
            model.addAttribute("error", "Client not found");
            return "redirect:/showClienti";
        }
    }

    @PostMapping("/client/update")
    public String updateClient(@ModelAttribute Client client) {
        clientService.updateClient(client);
        return "redirect:/showClienti";
    }

    @GetMapping("/client/delete/{idClient}")
    public String deleteClient(@PathVariable("idClient") int idClient) {
        clientService.deleteById(idClient);
        return "redirect:/showClienti";
    }

    // Masina Operatii
    @GetMapping("/showMasini")
    public String showMasini(Model model) {
        List<Masina> masiniList = masinaService.findAll();
        model.addAttribute("masini", masiniList);
        return "menu";
    }

    @GetMapping("/masina/add")
    public String addMasinaForm(Model model) {
        model.addAttribute("masina", new Masina());
        return "addMasina";
    }

    @PostMapping("/masina/add")
    public String addMasina(@ModelAttribute Masina masina, Model model) {
        try {
            masinaService.addMasina(masina);
            return "redirect:/showMasini";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while adding the masina: " + e.getMessage());
            model.addAttribute("masina", masina);
            return "addMasina";
        }
    }

    @GetMapping("/masina/update/{idMasina}")
    public String updateMasinaForm(@PathVariable("idMasina") int idMasina, Model model) {
        Masina masina = masinaService.findById(idMasina);
        if (masina != null) {
            model.addAttribute("masina", masina);
            return "updateMasina";
        } else {
            model.addAttribute("error", "Masina not found");
            return "redirect:/showMasini";
        }
    }

    @PostMapping("/masina/update")
    public String updateMasina(@ModelAttribute Masina masina) {
        masinaService.updateMasina(masina);
        return "redirect:/showMasini";
    }

    @GetMapping("/masina/delete/{idMasina}")
    public String deleteMasina(@PathVariable("idMasina") int idMasina) {
        masinaService.deleteById(idMasina);
        return "redirect:/showMasini";
    }

    // Vanzare Operatii
    @GetMapping("/showVanzari")
    public String showVanzari(Model model) {
        List<Vanzare> vanzariList = vanzareService.findAll();
        model.addAttribute("vanzari", vanzariList);
        return "menu";
    }

    @GetMapping("/vanzare/add")
    public String addVanzareForm(Model model) {
        model.addAttribute("vanzare", new Vanzare());
        return "addVanzare";
    }

    @PostMapping("/vanzare/add")
    public String addVanzare(@ModelAttribute Vanzare vanzare, Model model) {
        try {
            vanzareService.addVanzare(vanzare);
            return "redirect:/showVanzari";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while adding the vanzare: " + e.getMessage());
            model.addAttribute("vanzare", vanzare);
            return "addVanzare";
        }
    }

    @GetMapping("/vanzare/update/{idVanzare}")
    public String updateVanzareForm(@PathVariable("idVanzare") int idVanzare, Model model) {
        Vanzare vanzare = vanzareService.findById(idVanzare);
        if (vanzare != null) {
            model.addAttribute("vanzare", vanzare);
            return "updateVanzare";
        } else {
            model.addAttribute("error", "Vanzare not found");
            return "redirect:/showVanzari";
        }
    }

    @PostMapping("/vanzare/update")
    public String updateVanzare(@ModelAttribute Vanzare vanzare) {
        vanzareService.updateVanzare(vanzare);
        return "redirect:/showVanzari";
    }

    @GetMapping("/vanzare/delete/{idVanzare}")
    public String deleteVanzare(@PathVariable("idVanzare") int idVanzare) {
        vanzareService.deleteById(idVanzare);
        return "redirect:/showVanzari";
    }
}

