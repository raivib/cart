package com.example.democart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.ResourceReaderRepositoryPopulatorBeanDefinitionParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartRepository repository;

    @PostMapping("/cart")
    public Response addCart(@RequestBody Cart cart){
        repository.save(cart);
        return new Response(cart.getId());
    }


/*
    @PostMapping("/cart")
    public Cart addCart(@RequestBody Cart cart){
        return repository.save(cart);
    }
*/
    @GetMapping("/cart")
    public List<Cart> getCarts(){
        return repository.findAll();
    }


}
