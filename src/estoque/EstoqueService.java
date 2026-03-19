package estoque;

import model.Prato;

public class EstoqueService implements IControleEstoque{

    @Override
    public void registrarEntradaEstoque(
            Prato prato,
            int qtd
    ) {

        int estoqueAtual = prato.getEstoque();

        prato.setEstoque(estoqueAtual + qtd);

    }

    @Override
    public void validarEBaixarEstoque(
            Prato prato,
            int qtd
    ) {

        if (prato.getEstoque() < qtd){

            throw new RuntimeException("Estoque insufciente para o prato" + prato.getNome().toUpperCase());

        }

        int novoEstoque = prato.getEstoque() - qtd;

        prato.setEstoque(novoEstoque);

    }
}
