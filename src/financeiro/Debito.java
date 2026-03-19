package financeiro;

public class Debito implements IPagamentos{

    @Override
    public double calcularTotal(
            double valor
    ) {

        return valor * 0.97;

    }
}
