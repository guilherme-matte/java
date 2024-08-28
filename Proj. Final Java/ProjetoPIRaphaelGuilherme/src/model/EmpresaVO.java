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
public class EmpresaVO {
    private String NomeEmpresa,ResponsavelEmpresa,CNPJ,CargoEmpresa,EmailEmpresa
            ,TelefoneEmpresa,EmailResponsavel,TelefoneResponsavel,dataFormatada;

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }
    
    private Date DataCadastroEmpresa;
    
     private int IdEmpresa;

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }

    public String getResponsavelEmpresa() {
        return ResponsavelEmpresa;
    }

    public void setResponsavelEmpresa(String ResponsavelEmpresa) {
        this.ResponsavelEmpresa = ResponsavelEmpresa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCargoEmpresa() {
        return CargoEmpresa;
    }

    public void setCargoEmpresa(String CargoEmpresa) {
        this.CargoEmpresa = CargoEmpresa;
    }

    public String getEmailEmpresa() {
        return EmailEmpresa;
    }

    public void setEmailEmpresa(String EmailEmpresa) {
        this.EmailEmpresa = EmailEmpresa;
    }

    public String getTelefoneEmpresa() {
        return TelefoneEmpresa;
    }

    public void setTelefoneEmpresa(String TelefoneEmpresa) {
        this.TelefoneEmpresa = TelefoneEmpresa;
    }

    public String getEmailResponsavel() {
        return EmailResponsavel;
    }

    public void setEmailResponsavel(String EmailResponsavel) {
        this.EmailResponsavel = EmailResponsavel;
    }

    public String getTelefoneResponsavel() {
        return TelefoneResponsavel;
    }

    public void setTelefoneResponsavel(String TelefoneResponsavel) {
        this.TelefoneResponsavel = TelefoneResponsavel;
    }

    public Date getDataCadastroEmpresa() {
        return DataCadastroEmpresa;
    }

    public void setDataCadastroEmpresa(Date DataCadastroEmpresa) {
        this.DataCadastroEmpresa = DataCadastroEmpresa;
    }
    
    
    
}
