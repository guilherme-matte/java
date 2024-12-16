package invest.invest.models;

public class TransacaoFii {

    private int cotasCompradas;
    private float valorCota;

    public float calcularPlFii(float valorCota, int numCotas) {
        float total;
        return total = valorCota * numCotas;
    }

    public int getCotasCompradas() {
        return cotasCompradas;
    }

    public void setCotasCompradas(int cotasCompradas) {
        this.cotasCompradas = cotasCompradas;
    }

    public float getValorCota() {
        return valorCota;
    }

    public void setValorCota(float valorCota) {
        this.valorCota = valorCota;
    }
}

