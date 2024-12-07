package com.example.demo.Controller;

import com.example.demo.Model.LoginModel;
import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService loginModelService;

    @GetMapping
    public List<LoginModel> getAllUsers() {
        return loginModelService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginModel> getUserById(@PathVariable Long id) {
        LoginModel user = loginModelService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LoginModel createUser(@RequestBody LoginModel loginModel) {
        return loginModelService.createUser(loginModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginModel> updateUser(@PathVariable Long id, @RequestBody LoginModel userDetails) {
        LoginModel updatedUser = loginModelService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        loginModelService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
