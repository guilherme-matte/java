package invest.invest.controller;

import invest.invest.dto.FiiResponseDTO;
import invest.invest.models.CalcularCota;
import invest.invest.models.FiiModel;
import invest.invest.models.TransacaoFii;
import invest.invest.repositories.FiiRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
            "nomeFii": "*RECEBE O NOME SOCIAL DO FII(STRING)*",
            "numCotas":"*RECEBE O NUMERO DE COTAS EMITIDAS(INT)*"
            "siglaFii":"*RECEBE A SILGA DO FII(STRING)*",
            "tipo":"*RECEBE O TIPO DO FII, TIJOLO, FIAGRO OU PAPEL*"
        *  }
        *
        */

        try {
            FiiModel savedFii = fiiRepository.save(fiiModel);
            System.out.println("Funcionou poha_1");
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFii);


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

    @GetMapping("/get/{siglaFii}")
    public ResponseEntity<Object> getOneFii(@PathVariable(value = "siglaFii") String siglaFii) {
        Optional<FiiModel> selectedFii = fiiRepository.findBySiglaFii(siglaFii.toUpperCase());
        try {
            if (selectedFii.isPresent()) {
                FiiModel fii = selectedFii.get();

                CalcularCota cotaValor = new CalcularCota();


                float valorCota = cotaValor.calcularCota(fii.getPL(), fii.getNumCotas());

                FiiResponseDTO response = new FiiResponseDTO(fii, valorCota);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FII NÃO ENCONTRADO!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/buy/{siglaFii}")
    public ResponseEntity<FiiModel> compraCota(@PathVariable(value = "siglaFii") String siglaFii, @RequestPart("cotas") int numCotas, @RequestPart("valorCota") float valorCota) {
        Optional<FiiModel> fii = fiiRepository.findBySiglaFii(siglaFii.toUpperCase());
        System.out.println(fii + "OPTIONAL");
        try {
            return null;//fins de teste

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
