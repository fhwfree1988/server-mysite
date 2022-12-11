package com.sample.mysite.Modules.Product.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServiceAOP {

    //@Before(value = "execution(* com.project.site.Modules.Product.service.ProductService.*(..)) && args(productNo) && args(productName)")
    @Before(value = "execution(* com.project.site.Modules.Product.service.ProductService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint/*, Long productNo,String productName*/) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("get ProductService with name - " + "productName" + " and id - " + "productNo");
    }

    //@After(value = "execution(* com.project.site.Modules.Product.service.ProductService.*(..)) && args(productNo) && args(productName)")
    @After(value = "execution(* com.project.site.Modules.Product.service.ProductService.*(..))")
    public void afterAdvice(JoinPoint joinPoint/*, Long productNo,String productName*/) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("get ProductService with name - " + "productName" + " and id - " + "productNo");
    }
}
