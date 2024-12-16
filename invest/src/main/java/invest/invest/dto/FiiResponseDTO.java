package invest.invest.dto;

import invest.invest.models.FiiModel;

public class FiiResponseDTO {
    private FiiModel fii;
    private float valorCota;

    public FiiResponseDTO(FiiModel fii, float valorCota) {
        this.fii = fii;
        this.valorCota = valorCota;
    }

    public FiiModel getFii() {
        return fii;
    }

    public void setFii(FiiModel fii) {
        this.fii = fii;
    }

    public float getValorCota() {
        return valorCota;
    }

    public void setValorCota(float valorCota) {
        this.valorCota = valorCota;
    }
}