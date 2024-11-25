package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        //Valid verifica se as validações no ProductRecordDto estão OK, caso não estejam, o metodo post não é executado
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);//converte os dados da DTO para o MODEL

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
        //HTTPSTATUS retorna uma reposta do HTTP caso esteja OK

        //1hr e 8 minutos https://www.youtube.com/watch?v=wlYvA2b1BWI&ab_channel=MichelliBrito
    }
}

