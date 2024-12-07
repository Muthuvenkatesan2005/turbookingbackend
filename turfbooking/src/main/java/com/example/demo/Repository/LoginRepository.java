package com.example.demo.Repository;

import com.example.demo.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {
}

//    LoginModel findByUsernameAndPassword(String username, String password);

