package model;

public class Funcionario {

    private int id;

    private String nome;

    private String cargos;

    private double salarios;

    public Funcionario(String nome, String cargos, double salarios) {
        this.nome = nome;
        this.cargos = cargos;
        this.salarios = salarios;
    }

    public Funcionario(int id, String nome, String cargos, double salarios) {
        this.id = id;
        this.nome = nome;
        this.cargos = cargos;
        this.salarios = salarios;
    }

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public double getSalarios() {
        return salarios;
    }

    public void setSalarios(double salarios) {
        this.salarios = salarios;
    }
}
