package service;

import estoque.IControleEstoque;
import financeiro.IPagamentos;
import model.Prato;

public class VendaService {

    private final IPagamentos metodo;

    private final IControleEstoque controleEstoque;


    public VendaService(
            IPagamentos metodo,
            IControleEstoque controleEstoque
    ){
        this.metodo = metodo;
        this.controleEstoque = controleEstoque;
    }

    public double realizarVenda(
            Prato prato,
            int qtd,
            boolean isDelivery
    ) {

        if (prato.getEstoque() < qtd) throw new RuntimeException("Estoque Insuficiente!");

        double valorBase = prato.getPrecos() * qtd;

        if (isDelivery) valorBase += 15.0;

        double valorFinal = metodo.calcularTotal(valorBase);
        prato.setEstoque(prato.getEstoque() - qtd);

        return valorFinal;

    }

    public double realizarProcessamentoVenda(
            Prato prato,
            int qtd,
            boolean ehDelivery
    ){

        this.controleEstoque.validarEBaixarEstoque(prato, qtd);

        double valorBase = prato.getPrecos() * qtd;

        if (ehDelivery) {
            valorBase += 15.0;
        }

        return this.metodo.calcularTotal(valorBase);
    }


}
