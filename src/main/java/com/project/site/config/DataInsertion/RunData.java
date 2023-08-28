package com.project.site.config.DataInsertion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunData {

    @Autowired
    private ProductData productData;

    @Value("${mytest.val}")
    private String val;

    public void loadData(){
        productData.loadData();
    }

}
