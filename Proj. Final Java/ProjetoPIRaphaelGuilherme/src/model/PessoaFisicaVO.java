/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author 182320034
 */
public class PessoaFisicaVO {
    
    private String Nome,Sobrenome,CPF,TelefonePF,EmailPF,Endereco,Cep,NomeCompleto,dataFormatada;

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }
    
    private Date DataCadastroPF;
    
     private int IdPF;

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    
     
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        this.Cep = cep;
    }

    
    public int getIdPF() {
        return IdPF;
    }

    public void setIdPF(int IdPF) {
        this.IdPF = IdPF;
    }

    

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefonePF() {
        return TelefonePF;
    }

    public void setTelefonePF(String TelefonePF) {
        this.TelefonePF = TelefonePF;
    }

    public String getEmailPF() {
        return EmailPF;
    }

    public void setEmailPF(String EmailPF) {
        this.EmailPF = EmailPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public Date getDataCadastroPF() {
        return DataCadastroPF;
    }

    public void setDataCadastroPF(Date DataCadastroPF) {
        this.DataCadastroPF = DataCadastroPF;
    }
    
    
    
    
}
