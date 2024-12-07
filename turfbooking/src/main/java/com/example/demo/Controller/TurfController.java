package com.example.demo.Controller;

import com.example.demo.Model.Turf;
import com.example.demo.Service.TurfService;
import com.example.demo.Model.LoginModel;  // Import LoginModel class
import com.example.demo.Service.LoginService;  // Import LoginService class if exists
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turfs")
@CrossOrigin(origins = "http://localhost:3000")
public class TurfController {

    @Autowired
    private TurfService turfService;

    @Autowired
    private LoginService loginService;  // Ensure loginService is correctly defined and available

    // Endpoint to register a turf
    @PostMapping("/registerTurf")
    public ResponseEntity<Turf> registerTurf(
            @RequestParam("turfName") String turfName,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            @RequestParam("pitchSize") String pitchSize,
            @RequestParam("regularPrice") String regularPrice,
            @RequestParam("discountedPrice") String discountedPrice,
            @RequestParam("cafe") String cafe,
            @RequestParam("contact") String contact,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("address") String address
    ) {
        try {
            Turf turf = new Turf();
            turf.setName(turfName);
            turf.setDescription(description);
            turf.setPitchSize(pitchSize);
            turf.setRegularPrice(regularPrice);
            turf.setDiscountedPrice(discountedPrice);
            turf.setCafe(cafe);
            turf.setContact(contact);
            turf.setLatitude(latitude);
            turf.setLongitude(longitude);
            turf.setEmail(email);
            turf.setPassword(password);
            turf.setAddress(address);

            if (image != null && !image.isEmpty()) {
                byte[] imageBytes = image.getBytes();
                turf.setImage(imageBytes);
            }

            Turf savedTurf = turfService.saveTurf(turf);
            return new ResponseEntity<>(savedTurf, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Turf turf) {
        boolean isAuthenticated = turfService.authenticateUser(turf.getName(), turf.getEmail(), turf.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");
        }
    }

    // Endpoint to update an existing turf
    @PutMapping("/{id}")
    public ResponseEntity<Turf> updateTurf(
            @PathVariable Long id,
            @RequestParam(value = "turfName", required = false) String turfName,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "pitchSize", required = false) String pitchSize,
            @RequestParam(value = "regularPrice", required = false) String regularPrice,
            @RequestParam(value = "discountedPrice", required = false) String discountedPrice,
            @RequestParam(value = "cafe", required = false) String cafe,
            @RequestParam(value = "contact", required = false) String contact,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "longitude", required = false) String longitude,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "address", required = false) String address
    ) {
        try {
            Optional<Turf> existingTurfOpt = turfService.getTurfById(id);
            if (!existingTurfOpt.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Turf turf = existingTurfOpt.get();

            // Update fields if provided
            if (turfName != null) turf.setName(turfName);
            if (description != null) turf.setDescription(description);
            if (pitchSize != null) turf.setPitchSize(pitchSize);
            if (regularPrice != null) turf.setRegularPrice(regularPrice);
            if (discountedPrice != null) turf.setDiscountedPrice(discountedPrice);
            if (cafe != null) turf.setCafe(cafe);
            if (contact != null) turf.setContact(contact);
            if (latitude != null) turf.setLatitude(latitude);
            if (longitude != null) turf.setLongitude(longitude);
            if (email != null) turf.setEmail(email);
            if (password != null) turf.setPassword(password);
            if (address != null) turf.setAddress(address);

            // Handle image update
            if (image != null && !image.isEmpty()) {
                byte[] imageBytes = image.getBytes();
                turf.setImage(imageBytes);
            }

            Turf updatedTurf = turfService.saveTurf(turf);
            return new ResponseEntity<>(updatedTurf, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve all turfs
    @GetMapping
    public ResponseEntity<List<Turf>> getAllTurfs() {
        List<Turf> turfs = turfService.getAllTurfs();
        return new ResponseEntity<>(turfs, HttpStatus.OK);
    }

    // Endpoint to retrieve a turf by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Turf> getTurfById(@PathVariable Long id) {
        Optional<Turf> turf = turfService.getTurfById(id);
        return turf.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to delete a turf by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurf(@PathVariable Long id) {
        turfService.deleteTurf(id);
        return ResponseEntity.noContent().build();
    }
}
