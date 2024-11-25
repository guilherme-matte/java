package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
//NotBlank e NotNull são utilizados para evitar que os campos sejam enviado ao banco corretamente, não estando nulo ou em branco


}
