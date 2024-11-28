package com.example.springboot.repositories;

import com.example.springboot.models.RateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RateRepository extends JpaRepository<RateModel, UUID> {
    Optional<RateModel> findByIdProduct(String idProduct);//Utilizado para pesquisar no banco pela String idPRoduct, que esta na tabela TB_RATE
}
