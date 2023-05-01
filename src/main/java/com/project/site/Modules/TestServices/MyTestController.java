package com.project.site.Modules.TestServices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("mytestcontroller")
@RequestMapping("/mytest")
public class MyTestController {

    private final TestServices testServices;

    public MyTestController(TestServices testServices) {
        this.testServices = testServices;
    }

    @GetMapping("/native-query")
    public String NativeQuery(){
        testServices.NativeQuery();

        return "";
    }

}
