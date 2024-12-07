package com.example.demo.Service;
import com.example.demo.Model.TurfReservation;
import com.example.demo.Repository.TurfReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurfReservationService {

    @Autowired
    private TurfReservationRepository repository;

    public void saveReservation(TurfReservation reservation) {
        repository.save(reservation);
    }

    public Optional<TurfReservation> getReservationById(Long id) {
        return repository.findById(id);
    }

    public List<TurfReservation> getAllReservations() {
        return repository.findAll();
    }

    public boolean updateReservation(Long id, TurfReservation updatedReservation) {
        if (repository.existsById(id)) {
            updatedReservation.setId(id);
            repository.save(updatedReservation);
            return true;
        }
        return false;
    }

    public boolean deleteReservation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
