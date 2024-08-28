/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 182320034
 */
public class ProdutoEmpresaVO {

    private String CNPJ, Descricao, Categoria, NomeEmpresa, ResponsavelEmpresa;
    private int idProdEmpresa;

    public int getIdProdEmpresa() {
        return idProdEmpresa;
    }

    public void setIdProdEmpresa(int idProdEmpresa) {
        this.idProdEmpresa = idProdEmpresa;
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
    private int IdProduto, quantidade;

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) {
        this.IdProduto = IdProduto;
    }

}
