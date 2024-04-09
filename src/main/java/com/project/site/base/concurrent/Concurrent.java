package com.project.site.base.concurrent;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/concurrent")
public class Concurrent {

    @PostMapping("/test/{id}")
    public void Concurrent(@PathVariable int id){
        SingletonReduction.perform();
        ResponseEntity.ok(id);
    }

    //@PostMapping("/test2")
}
