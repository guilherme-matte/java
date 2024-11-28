package com.example.springboot.controller;

import com.example.springboot.models.RateModel;
import com.example.springboot.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RateController {
    @Autowired
    RateRepository rateRepository;

    @GetMapping("/products/{id}/rate")
    public ResponseEntity<Object> getRateByProductId(@PathVariable(value = "id") String idProduct) {
        Optional<RateModel> rate = rateRepository.findByIdProduct(idProduct);
        if (rate.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(rate.get());
        } else {
            System.out.println(idProduct);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - 1371");
        }
    }

    @PutMapping("/rate/{id}")
    public ResponseEntity<Object> insertRate(@PathVariable(value = "id") String idProduct, @RequestBody RateModel newRateData) {
        Optional<RateModel> rate = rateRepository.findByIdProduct(idProduct);
        if (rate.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR - 1372");
        } else {
            RateModel rateModel = rate.get();

            rateModel.setQuantity(newRateData.getQuantity());
            rateModel.setAllRate(newRateData.getAllRate());

            rateRepository.save(rateModel);
            return ResponseEntity.status(HttpStatus.OK).body(rateModel);
        }
    }
}
