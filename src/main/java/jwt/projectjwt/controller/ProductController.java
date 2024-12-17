package jwt.projectjwt.controller;

import jwt.projectjwt.domain.user.User;
import jwt.projectjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getProduct() {
        List<User> list = userRepository.findAll();

        return ResponseEntity.ok(list);
    }
}
