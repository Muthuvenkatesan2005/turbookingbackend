package com.example.demo.Service;

import com.example.demo.Model.LoginModel;
import com.example.demo.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<LoginModel> getAllUsers() {
        return loginRepository.findAll();
    }

    public LoginModel getUserById(Long id) {
        return loginRepository.findById(id).orElse(null);
    }

    public LoginModel createUser(LoginModel loginModel) {
        return loginRepository.save(loginModel);
    }

    public LoginModel updateUser(Long id, LoginModel userDetails) {
        return loginRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    return loginRepository.save(user);
                })
                .orElse(null);
    }

    public void deleteUser(Long id) {
        loginRepository.deleteById(id);
    }
}
