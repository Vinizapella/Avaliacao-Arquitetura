package service;

import financeiro.IPagamentos;
import model.Prato;

public class VendaService {

    private IPagamentos metodo;

    public VendaService(IPagamentos metodo) {
        this.metodo = metodo;
    }

    public double realizarVenda(Prato prato, int qtd, boolean isDelivery) {

        if (prato.getEstoque() < qtd) throw new RuntimeException("Estoque Insuficiente!");

        double valorBase = prato.getPrecos() * qtd;

        if (isDelivery) valorBase += 15.0;

        double valorFinal = metodo.calcularTotal(valorBase);
        prato.setEstoque(prato.getEstoque() - qtd);

        return valorFinal;

    }

}
