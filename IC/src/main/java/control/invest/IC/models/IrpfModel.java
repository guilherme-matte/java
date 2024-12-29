package control.invest.IC.models;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;


public class IrpfModel extends RepresentationModel<IrpfModel> implements Serializable {

    //classe para fins de teste, futuramente serão adicionados outros tipos de rendimentos

    private UUID idIrpf;

    private String cpf;
    private String nomePessoaFisica;

    private String fontePagadoraCnpj;
    private String fontePagadoraNomeEmpresa;

    //rendimentos tributaveis
    private double rendimentosTotais;
    private double prevSocial;
    private double impostoRetido;

    // rendimentos isentos
    private double pagamentosRecebidos;//Pagamento realizado ao titular ou socio de micro empresa
    private double outrosRendimentosIsentos;


    // rendimentos exclusivos
    private double impRendDecTerc;

    //rendimentos acumulados
    private double pensao;

    //pagamento dedutiveis
    private String cnpjEmpresaPagDedutivel;
    private String nomeEmpresaPagDedutivel;
    private double valorEmpresaPAgDedutivel;

    public UUID getIdIrpf() {
        return idIrpf;
    }

    public void setIdIrpf(UUID idIrpf) {
        this.idIrpf = idIrpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomePessoaFisica() {
        return nomePessoaFisica;
    }

    public void setNomePessoaFisica(String nomePessoaFisica) {
        this.nomePessoaFisica = nomePessoaFisica;
    }

    public String getFontePagadoraCnpj() {
        return fontePagadoraCnpj;
    }

    public void setFontePagadoraCnpj(String fontePagadoraCnpj) {
        this.fontePagadoraCnpj = fontePagadoraCnpj;
    }

    public String getFontePagadoraNomeEmpresa() {
        return fontePagadoraNomeEmpresa;
    }

    public void setFontePagadoraNomeEmpresa(String fontePagadoraNomeEmpresa) {
        this.fontePagadoraNomeEmpresa = fontePagadoraNomeEmpresa;
    }

    public double getRendimentosTotais() {
        return rendimentosTotais;
    }

    public void setRendimentosTotais(double rendimentosTotais) {
        this.rendimentosTotais = rendimentosTotais;
    }

    public double getPrevSocial() {
        return prevSocial;
    }

    public void setPrevSocial(double prevSocial) {
        this.prevSocial = prevSocial;
    }

    public double getImpostoRetido() {
        return impostoRetido;
    }

    public void setImpostoRetido(double impostoRetido) {
        this.impostoRetido = impostoRetido;
    }

    public double getPagamentosRecebidos() {
        return pagamentosRecebidos;
    }

    public void setPagamentosRecebidos(double pagamentosRecebidos) {
        this.pagamentosRecebidos = pagamentosRecebidos;
    }

    public double getOutrosRendimentosIsentos() {
        return outrosRendimentosIsentos;
    }

    public void setOutrosRendimentosIsentos(double outrosRendimentosIsentos) {
        this.outrosRendimentosIsentos = outrosRendimentosIsentos;
    }

    public double getImpRendDecTerc() {
        return impRendDecTerc;
    }

    public void setImpRendDecTerc(double impRendDecTerc) {
        this.impRendDecTerc = impRendDecTerc;
    }

    public double getPensao() {
        return pensao;
    }

    public void setPensao(double pensao) {
        this.pensao = pensao;
    }

    public String getCnpjEmpresaPagDedutivel() {
        return cnpjEmpresaPagDedutivel;
    }

    public void setCnpjEmpresaPagDedutivel(String cnpjEmpresaPagDedutivel) {
        this.cnpjEmpresaPagDedutivel = cnpjEmpresaPagDedutivel;
    }

    public String getNomeEmpresaPagDedutivel() {
        return nomeEmpresaPagDedutivel;
    }

    public void setNomeEmpresaPagDedutivel(String nomeEmpresaPagDedutivel) {
        this.nomeEmpresaPagDedutivel = nomeEmpresaPagDedutivel;
    }

    public double getValorEmpresaPagDedutivel() {
        return valorEmpresaPAgDedutivel;
    }

    public void setValorEmpresaPagDedutivel(double valorEmpresaPAgDedutivel) {
        this.valorEmpresaPAgDedutivel = valorEmpresaPAgDedutivel;
    }
}
