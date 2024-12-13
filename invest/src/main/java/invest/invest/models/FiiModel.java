package invest.invest.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tb_fii")
public class FiiModel extends RepresentationModel<FiiModel> implements Serializable {
        private static  final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID idFii;
    private String siglaFii;
    private String nomeFii;
    private Long PL;
    private int numCotas;
    private String tipo;


    public UUID getIdFii() {
        return idFii;
    }

    public void setIdFii(UUID idFii) {
        this.idFii = idFii;
    }

    public String getSiglaFii() {
        return siglaFii;
    }

    public void setSiglaFii(String siglaFii) {
        this.siglaFii = siglaFii;
    }

    public String getNomeFii() {
        return nomeFii;
    }

    public void setNomeFii(String nomeFii) {
        this.nomeFii = nomeFii;
    }

    public Long getPL() {
        return PL;
    }

    public void setPL(Long PL) {
        this.PL = PL;
    }

    public int getNumCotas() {
        return numCotas;
    }

    public void setNumCotas(int numCotas) {
        this.numCotas = numCotas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
