package financeiro;

public class Credito implements IPagamentos{

    @Override
    public double calcularTotal(double valor) {
        return valor * 1.05;
    }
}
