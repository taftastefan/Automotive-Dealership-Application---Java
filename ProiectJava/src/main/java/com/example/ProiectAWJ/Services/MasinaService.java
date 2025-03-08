/** Clasa pentru aplicarea functiile necesare Masinilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Services;

import com.example.ProiectAWJ.Repository.MasinaRepository;
import com.example.ProiectAWJ.models.Masina;

import java.util.List;

public class MasinaService {
    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public List<Masina> findAll() {
        return masinaRepository.findAll();
    }

    public void deleteById(int idMasina) {
        masinaRepository.deleteById(idMasina);
    }

    public void addMasina(Masina masina) {
        masinaRepository.addMasina(masina);
    }

    public void updateMasina(Masina masina) {
        masinaRepository.updateMasina(masina);
    }

    public Masina findById(int idMasina) {
        return masinaRepository.findById(idMasina);
    }
}

