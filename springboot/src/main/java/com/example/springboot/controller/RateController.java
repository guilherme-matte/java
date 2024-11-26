package com.example.springboot.controller;

import com.example.springboot.models.ProductModel;
import com.example.springboot.models.RateModel;
import com.example.springboot.repositories.ProductRepository;
import com.example.springboot.repositories.RateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class RateController {
    @Autowired
    RateRepository rateRepository;
    @GetMapping("/products/{id}/rate")
    public ResponseEntity<Object> getRateByProductId(@PathVariable(value = "id")String idProduct){
        Optional<RateModel> rate = rateRepository.findByIdProduct(idProduct);
        System.out.println(rate);
        if (rate.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(rate.get());
        }else{
            System.out.println(idProduct);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - 1371");
        }
            }
}
