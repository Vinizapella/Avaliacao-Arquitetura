package service;

import model.Prato;

import java.util.List;

public interface IGerenciarPratos {

    public Prato cadastrar(Prato prato);

    List<Prato> ver();

    void excluir(int id);

    void editar(Prato prato, int id);

}
