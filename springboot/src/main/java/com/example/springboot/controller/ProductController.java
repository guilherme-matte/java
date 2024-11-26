package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

        //body armazena as informações json
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>>getAllProducts(){
    List<ProductModel> productList = productRepository.findAll();

    if (!productList.isEmpty()){
        for (ProductModel product : productList){
            UUID id = product.getIdproduct();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());

        }
    }
    //LinkTo  -adicionado ao produto, o link para acesso o getById
            return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id")UUID id){
        //object pois terão dois tipos diferentes de retorno
        //PathVariable serve para pegar valores diretamente da URL passando o parametro "id"
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()){
        //verifica se a consulta retorna nada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

        }
    product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id")UUID id, @RequestBody @Valid ProductRecordDto ProductRecordDto) {
    Optional<ProductModel> product0 = productRepository.findById(id);
    if (product0.isEmpty()){
        //caso a consulta retorne nada
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

    }

    var productModel = product0.get();


    BeanUtils.copyProperties(ProductRecordDto,productModel);


    return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){

        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

        }
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("PRODUCT DELETED SUCCESSFULLY");
    }
}

