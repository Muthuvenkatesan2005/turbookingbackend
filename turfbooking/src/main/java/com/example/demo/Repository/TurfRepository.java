package com.example.demo.Repository;

import com.example.demo.Model.Turf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurfRepository extends JpaRepository<Turf, Long> {
	
	 @Query("SELECT t FROM Turf t WHERE t.name = :name OR t.email = :email")
	    Turf findByNameOrEmail(String name, String email);
	 
	 	Turf findByEmail(String email);
}
