package estoque;

import model.Prato;

public interface IControleEstoque {

    void registrarEntradaEstoque(
            Prato prato,
            int qtd
    );

    void validarEBaixarEstoque(
            Prato prato,
            int qtd
    );

}
