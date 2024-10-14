package matte.guilherme.folhadepagamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome, cargo;

	
	private double salario, plano, vt, va;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public double getPlano() {
		return plano;
	}


	public void setPlano(double plano) {
		this.plano = plano;
	}


	public double getVt() {
		return vt;
	}


	public void setVt(double vt) {
		this.vt = vt;
	}


	public double getVa() {
		return va;
	}


	public void setVa(double va) {
		this.va = va;
	}

	
}



