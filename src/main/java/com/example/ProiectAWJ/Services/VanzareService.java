/** Clasa pentru aplicarea functiile necesare Vanzarilor
 * @author Tafta Stefan-Alexandru
 * @version 12 Ianuarie 2025
 */

package com.example.ProiectAWJ.Services;

import com.example.ProiectAWJ.Repository.VanzareRepository;
import com.example.ProiectAWJ.models.Vanzare;

import java.util.List;

public class VanzareService {
    private final VanzareRepository vanzareRepository;

    public VanzareService(VanzareRepository vanzareRepository) {
        this.vanzareRepository = vanzareRepository;
    }

    public List<Vanzare> findAll() {
        return vanzareRepository.findAll();
    }

    public void deleteById(int idVanzare) {
        vanzareRepository.deleteById(idVanzare);
    }

    public void addVanzare(Vanzare vanzare) {
        vanzareRepository.addVanzare(vanzare);
    }

    public void updateVanzare(Vanzare vanzare) {
        vanzareRepository.updateVanzare(vanzare);
    }

    public Vanzare findById(int idVanzare) {
        return vanzareRepository.findById(idVanzare);
    }
}
