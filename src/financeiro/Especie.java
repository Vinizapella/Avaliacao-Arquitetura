package financeiro;

public class Especie implements IPagamentos{

    @Override
    public double calcularTotal(double valor) {
        return valor * 0.92;
    }
}
