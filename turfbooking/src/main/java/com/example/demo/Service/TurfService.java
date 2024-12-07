package com.example.demo.Service;

import com.example.demo.Model.Turf;
import com.example.demo.Repository.TurfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class TurfService {

    @Autowired
    private TurfRepository turfRepository;

    public Turf saveTurf(Turf turf) {
        return turfRepository.save(turf);
    }

    public List<Turf> getAllTurfs() {
        List<Turf> turfs = turfRepository.findAll();
        turfs.forEach(turf -> {
            if (turf.getImage() != null) {
                turf.setImageBase64(Base64.getEncoder().encodeToString(turf.getImage()));
            }
        });
        return turfs;
    }

    public Optional<Turf> getTurfById(Long id) {
        Optional<Turf> turf = turfRepository.findById(id);
        turf.ifPresent(t -> {
            if (t.getImage() != null) {
                t.setImageBase64(Base64.getEncoder().encodeToString(t.getImage()));
            }
        });
        return turf;
    }

    public void deleteTurf(Long id) {
        turfRepository.deleteById(id);
    }
    
    public boolean authenticateUser(String name, String email, String password) {
        Turf optionalTurf = turfRepository.findByNameOrEmail(name, email);
        if (optionalTurf.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
