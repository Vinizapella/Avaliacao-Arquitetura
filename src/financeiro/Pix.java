package financeiro;

public class Pix implements IPagamentos{

    @Override
    public double calcularTotal(double valor) {
        return valor * 0.90;
    }
}
