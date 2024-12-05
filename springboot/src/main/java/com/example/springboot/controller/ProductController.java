package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.models.RateModel;
import com.example.springboot.repositories.ProductRepository;
import com.example.springboot.repositories.RateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductController {
    private String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        } else {
            return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        }
    }


    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    RateRepository rateRepository;

    @PostMapping(value = "/products", consumes = {"multipart/form-data"})
    public ResponseEntity<ProductModel> saveProduct(@RequestPart("product") String productJson,
                                                    @RequestPart("image") MultipartFile imageFile) {
        //@Valid verifica se as validações no ProductRecordDto estão OK, caso não estejam, o metodo post não é executado e retorna Bad Request


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductRecordDto productRecordDto = objectMapper.readValue(productJson, ProductRecordDto.class);
            var productModel = new ProductModel();
            BeanUtils.copyProperties(productRecordDto, productModel);//converte os dados da DTO para o MODEL
            productModel.setExtensionImage(getFileExtension(imageFile.getOriginalFilename()));
            var savedProduct = productRepository.save(productModel);

            try {

                String imageFileName = savedProduct.getIdproduct().toString() + getFileExtension(imageFile.getOriginalFilename());

                File directory = new File(uploadDir);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File saveFile = new File(uploadDir + imageFileName);
                imageFile.transferTo(saveFile);
                savedProduct.setImageUrl(imageFileName);
                System.out.println(uploadDir);
                System.out.println(imageFileName);
                System.out.println(saveFile);

            } catch (IOException e) {
                System.out.println("Mensagem " + e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            productRepository.save(savedProduct);

            var rateModel = new RateModel();
            rateModel.setIdProduct(savedProduct.getIdproduct().toString());

            rateModel.setName(savedProduct.getName());

            rateRepository.save(rateModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));

            //HTTPSTATUS retorna uma reposta do HTTP caso esteja OK

            //body armazena as informações json
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Map<String, Object>>> getAllProducts() {
        List<ProductModel> productList = productRepository.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (ProductModel productModel : productList) {
            Map<String, Object> productData = new HashMap<>();

            productData.put("idProduct", productModel.getIdproduct());
            productData.put("name", productModel.getName());
            productData.put("value", productModel.getValue());
            productData.put("image_url", productModel.getImageUrl());

            response.add(productData);
        }
        //LinkTo  -adicionado ao produto, o link para acesso o getById
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        //object pois terão dois tipos diferentes de retorno
        //PathVariable serve para pegar valores diretamente da URL passando o parametro "id"
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            //verifica se a consulta retorna nada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

        }
        product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto ProductRecordDto) {
        //@PutMapping utilizado para atualização no banco, utilizando ID como parametro, passa pelo ProductRecordDto para validação dos campos
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            //caso a consulta retorne nada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

        }

        var productModel = product0.get();


        BeanUtils.copyProperties(ProductRecordDto, productModel);


        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {

        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");
        }
        ProductModel product = product0.get();
        String imageUrl = product.getImageUrl();

        if (imageUrl != null && !imageUrl.isEmpty()) {
            File imageFile = new File(uploadDir + imageUrl.substring(imageUrl.lastIndexOf("/") + 1));
    if (imageFile.exists()){
        if (imageFile.delete());
    }
        }

        Optional<RateModel> rate0 = rateRepository.findByIdProduct(id.toString());

        if (rate0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUCT NOT FOUND");

        }

        rateRepository.delete(rate0.get());
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("PRODUCT DELETED SUCCESSFULLY");
    }
}

