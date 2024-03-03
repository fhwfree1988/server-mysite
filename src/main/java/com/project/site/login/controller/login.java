package com.project.site.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.websocket.server.PathParam;

@RestController()
@RequestMapping("/login")
public class login {

    @PostMapping("/test/{id}")
    public void login(@PathVariable int id){
        ResponseEntity.ok(id);
    }

    //@PostMapping("/test2")
}
