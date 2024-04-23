package com.project.site.base.concurrent;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/concurrent")
public class Concurrent {

    @GetMapping("/test/{id}")
    public void Concurrent(@PathVariable int id){
        //synchronized (SingletonReduction.class) {
            SingletonReduction.factory().perform();
        //}
        ResponseEntity.ok(id);
    }

    //@PostMapping("/test2")
}
