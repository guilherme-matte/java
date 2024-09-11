/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author guilherme-matte
 */
public class FuncionarioVO {
    private String nome, cargo;
    private float salario,vt,vr,plano;

    public float getVt() {
        return vt;
    }

    public void setVt(float vt) {
        this.vt = vt;
    }

    public float getVr() {
        return vr;
    }

    public void setVr(float vr) {
        this.vr = vr;
    }

    public float getPlano() {
        return plano;
    }

    public void setPlano(float plano) {
        this.plano = plano;
    }
    private int idFuncionario;

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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    
}
