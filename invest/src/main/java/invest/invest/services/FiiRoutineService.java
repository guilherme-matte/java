package invest.invest.services;

import invest.invest.models.FiiModel;
import invest.invest.repositories.FiiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static java.lang.Float.parseFloat;

@Component

public class FiiRoutineService {
    @Autowired
    private FiiRepository fiiRepository;

    private Random random = new Random();

    public float formatarValores(float valor) {
        String valorFormatadoString = String.format("%.2f", valor);
        float valorFormatadoFloat = parseFloat(valorFormatadoString);

        return valorFormatadoFloat;
    }

    public void AtualizarValoresFiiCompra() {
        System.out.println("Iniciando ROTINA COMPRA");
        List<FiiModel> allFiis = fiiRepository.findAll();

        if (!allFiis.isEmpty()) {
            for (FiiModel fii : allFiis) {

                int novasCotas = random.nextInt(100) + 1;

                float  =(fii.getPL() + (random.nextFloat(0.1f) * fii.getPL())) / fii.getNumCotas();
                fii.setNumCotas(novasCotas + fii.getNumCotas());
                fii.setPL(( * novasCotas) + fii.getPL());


                fiiRepository.save(fii);
                System.out.println("Atualizado FII: " + fii.getSiglaFii() + " | Novas Cotas: " + novasCotas + " | Valor p/ cota: " + formatarValores() + " | PL: " + formatarValores(fii.getPL()));
            }
            System.out.println("Fim da ROTINA");

        } else {
            System.out.println("Fii não encontrada");
        }

    }

    public void AtualizarValoresFiiVenda() {
        System.out.println("Iniciando ROTINA VENDA");
        List<FiiModel> allFiis = fiiRepository.findAll();

        if (!allFiis.isEmpty()) {
            for (FiiModel fii : allFiis) {

                int novasCotas = random.nextInt(50) + 1;

                float  =(fii.getPL() + (random.nextFloat(0.1f) * fii.getPL())) / fii.getNumCotas();

                fii.setNumCotas(fii.getNumCotas() - novasCotas);
                fii.setPL(fii.getPL() - ( * novasCotas));


                fiiRepository.save(fii);
                System.out.println("Atualizado FII: " + fii.getSiglaFii() + " | Novas Cotas: " + novasCotas + " | Valor p/ cota: " + formatarValores() + " | PL: " + formatarValores(fii.getPL()));


            }
            System.out.println("Fim da ROTINA");
        } else {
            System.out.println("Fii não encontrada");
        }

    }

    public List<FiiModel> retornarListaFii() {
        return fiiRepository.findAll();
    }

//    @Scheduled(fixedRate = 60000)
//    public void distribuirDividendos() {
//        rodarRotinaDividendosFiis();
//        List<FiiModel> allFiis = retornarListaFii();
//        if (!allFiis.isEmpty()) {
//            for (FiiModel fiiModel : allFiis) {
//                float dividendo = fiiModel.getDividendo();
//
//                fiiModel.setPL(fiiModel.getPL() - (dividendo * fiiModel.getNumCotas()));
//                fiiRepository.save(fiiModel);
//            }
//
//        }
//    }

    @Scheduled(fixedRate = 10000)
    public void atualizarPl() {
        List<FiiModel> allFiis = fiiRepository.findAll();

        if (!allFiis.isEmpty()) {
            for (FiiModel fiiModel : allFiis) {
                float novoPl = fiiModel.getPL() * 0.05f;
                System.out.println("Sigla Fii: " + fiiModel.getSiglaFii());
                if (random.nextInt(2) == 0) {
                    fiiModel.setPL(fiiModel.getPL() + novoPl);
                    System.out.println("Pl aumentado: " + fiiModel.getPL());
                } else {
                    fiiModel.setPL(fiiModel.getPL() - novoPl);
                    System.out.println("Pl diminuído: " + fiiModel.getPL());
                }
                fiiRepository.save(fiiModel);
            }
        }
    }

    //@Scheduled(fixedRate = 1000)
    public void rodarRotinaFii() {
        if (random.nextInt(2) == 0) {
            AtualizarValoresFiiCompra();
        } else {
            AtualizarValoresFiiVenda();
        }
    }

    //@Scheduled(fixedRate = 20000)
    public void rodarRotinaDividendosFiis() {
        float lucroDistribuido = random.nextFloat(10000);
        List<FiiModel> fiis = fiiRepository.findAll();
        System.out.println("Rotina DIVIDENDOS - INICIO");
        if (!fiis.isEmpty()) {
            for (FiiModel fiiModel : fiis) {

                fiiModel.setDividendo(lucroDistribuido / fiiModel.getNumCotas());
                fiiRepository.save(fiiModel);

                System.out.println("Sigla: " + fiiModel.getSiglaFii() + " | Dividendo: " + fiiModel.getDividendo());
            }
            System.out.println("Rotina DIVIDENDOS - FIM");

        } else {
            System.out.println("Nenhum Fii encontrado");
        }

    }

    public void calcularDividendo(float pl, int numCotas, FiiModel fiiModel) {
        fiiModel.setDividendo(pl / numCotas);
    }

    public void comprarCota(int quantidadeCotas, FiiModel fiiModel) {
        float total = quantidadeCotas * calcularValorCota(fiiModel);
        fiiModel.setNumCotas(fiiModel.getNumCotas() + quantidadeCotas);
        fiiModel.setPL(total + fiiModel.getPL());
    }

    public void venderCota(int quantidadeCotas, FiiModel fiiModel) {
        float total = quantidadeCotas * calcularValorCota(fiiModel);
        fiiModel.setNumCotas(fiiModel.getNumCotas() - quantidadeCotas);
        fiiModel.setPL(total - fiiModel.getPL());
    }

    public void distribuirDividendos(FiiModel fiiModel) {
        fiiModel.setPL(fiiModel.getPL() - (fiiModel.getDividendo() * fiiModel.getNumCotas()));
    }

    public void simularVendaImovel(FiiModel fiiModel, float valorVenda) {
        fiiModel.setPL(fiiModel.getPL() + valorVenda);
    }

    public float calcularValorCota(FiiModel fiiModel) {
        return fiiModel.getPL() / fiiModel.getNumCotas();
    }

    public float calcularDY(FiiModel fiiModel) {
        return calcularValorCota(fiiModel) / fiiModel.getDividendo();
    }
}
