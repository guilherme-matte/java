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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private UUID idFii;
    private String siglaFii;
    private String nomeFii;
    private Long PL;
    private int numCotas;
    private 

}
