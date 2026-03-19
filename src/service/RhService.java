package service;

import model.Funcionario;

public class RhService {

        public void aplicarAumento(
                Funcionario funcionario,
                double porc
        ) {

            funcionario.setSalarios(funcionario.getSalarios() * (1 + (porc/100)));

        }
}
