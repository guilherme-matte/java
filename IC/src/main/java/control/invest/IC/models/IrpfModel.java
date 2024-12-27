package control.invest.IC.models;

import jakarta.persistence.Entity;
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
    private double decTercSal;

    //rendimentos acumulados
    private double pensao;



}
