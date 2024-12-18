package invest.invest.controller;

import invest.invest.dto.DividendYieldDTO;
import invest.invest.dto.TransacaoCotaDTO;
import invest.invest.dto.FiiResponseDTO;
import invest.invest.models.CalcularCota;
import invest.invest.models.FiiModel;
import invest.invest.repositories.FiiRepository;
import invest.invest.services.FiiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FiiController {
    @Autowired
    FiiRepository fiiRepository;
    @Autowired
    FiiService fiiService ;


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
            fiiModel.setDividendo(0f);
            FiiModel savedFii = fiiRepository.save(fiiModel);
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
    public ResponseEntity<Object> compraCota(@PathVariable(value = "siglaFii") String siglaFii, @RequestBody TransacaoCotaDTO transacaoCotaDTO) {
        Optional<FiiModel> fii = fiiRepository.findBySiglaFii(siglaFii.toUpperCase());
        try {
            if (fii.isPresent()) {
                FiiModel fiiModel = fii.get();

                fiiModel.setNumCotas(fiiModel.getNumCotas() + transacaoCotaDTO.getCotas());
                fiiModel.setPL(fiiModel.getPL() + (transacaoCotaDTO.getCotas() * transacaoCotaDTO.getValorCota()));


                System.out.println(transacaoCotaDTO.getValorCota());
                fiiRepository.save(fiiModel);
                return ResponseEntity.status(HttpStatus.OK).body(fiiModel);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FII NOT FOUND");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/sell/{siglaFii}")
    public ResponseEntity<Object> vendaCota(@PathVariable(value = "siglaFii") String siglaFii, @RequestBody TransacaoCotaDTO transacaoCotaDTO) {
        Optional<FiiModel> fii = fiiRepository.findBySiglaFii(siglaFii.toUpperCase());
        try {
            if (fii.isPresent()) {
                FiiModel fiiModel = fii.get();

                fiiModel.setNumCotas(fiiModel.getNumCotas() - transacaoCotaDTO.getCotas());
                fiiModel.setPL(fiiModel.getPL() - (transacaoCotaDTO.getCotas() * transacaoCotaDTO.getValorCota()));
                fiiRepository.save(fiiModel);
                return ResponseEntity.status(HttpStatus.OK).body(fiiModel);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FII NOT FOUND");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Map<String, Object>>> getAllFiis() {
        List<FiiModel> fiiModelList = fiiRepository.findAll();
        List<Map<String, Object>> response = new ArrayList<>();
        if (!fiiModelList.isEmpty()) {
            for (FiiModel fiiModel : fiiModelList) {
                Map<String, Object> fiiData = new HashMap<>();
                fiiData.put("idFii", fiiModel.getIdFii());
                fiiData.put("siglaFii", fiiModel.getSiglaFii());
                fiiData.put("nomeFii", fiiModel.getNomeFii());
                fiiData.put("PL", fiiModel.getPL());
                fiiData.put("numCotas", fiiModel.getNumCotas());
                fiiData.put("tipo", fiiModel.getTipo());
                fiiData.put("dividendo", fiiService.calcularDividendo(fiiModel));


                response.add(fiiData);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/DY/{siglaFii}")
    public ResponseEntity<Object> calcularDY(@PathVariable(value = "siglaFii") String siglaFii, @RequestBody DividendYieldDTO dividendYieldDTO) {
        Optional<FiiModel> fii = fiiRepository.findBySiglaFii(siglaFii.toUpperCase());
        try {
            if (fii.isPresent()) {
                FiiModel fiiModel = fii.get();
                int numCotas = fiiModel.getNumCotas();
                float lucro = dividendYieldDTO.getLucroDistribuido();

                if (numCotas <= 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O número de cotas não pode ser igual ou menor que 0");
                }

                fiiModel.setDividendo(lucro / numCotas);
                System.out.println(lucro + " - " + numCotas);
                fiiRepository.save(fiiModel);

                return ResponseEntity.status(HttpStatus.OK).body(fiiModel);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FII NOT FOUND");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

