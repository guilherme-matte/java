package invest.invest.controller;

import invest.invest.models.FiiModel;
import invest.invest.repositories.FiiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FiiController {
    @Autowired
    FiiRepository fiiRepository;

    @PostMapping("/create")
    public ResponseEntity<FiiModel> saveFii(@RequestBody FiiModel fiiModel) {
        /*
        * Este metodo receberá um JSON no formato:
        * {
            "pl":*RECEBE PATRIMONIO LIQUIDO DO FII(FLOAT)* ,
            "nome_fii": "*RECEBE O NOME SOCIAL DO FII(STRING)*",
            "num_COTAS":"*RECEBE O NUMERO DE COTAS EMITIDAS(INT)*"
            "sigla_fii":"*RECEBE A SILGA DO FII(STRING)*",
            "tipo":"*RECEBE O TIPO DO FII, TIJOLo, FIAGRO OU PAPEL*"
        *  }
        *
        */

        try {
            FiiModel savedFii = fiiRepository.save(fiiModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFii);


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
