package com.project.site.my.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UsersController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping("users")
    public List <User2> getUsers() {
        //for mongo
        /*return this.userRepository.findAll();*/
        return null;
    }
}
