package matte.guilherme.folhadepagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matte.guilherme.folhadepagamento.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
