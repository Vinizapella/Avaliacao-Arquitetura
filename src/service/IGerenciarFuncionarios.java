package service;

import model.Funcionario;

import java.util.List;

public interface IGerenciarFuncionarios {

    public Funcionario contratar (Funcionario funcionario);

    List<Funcionario> listar();

    void demitir(int id);

    void editar(Funcionario funcionario, int id);


}
