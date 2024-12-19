package invest.invest.services;

import invest.invest.models.FiiModel;
import invest.invest.repositories.FiiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class FiiService {
    @Autowired
    private FiiRepository fiiRepository;


    public float calcularDividendo(FiiModel fiiModel) {
        if (fiiModel.getNumCotas() == 0) {
            return 0;
        } else {
            return fiiModel.getPL() / fiiModel.getNumCotas();
        }
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
