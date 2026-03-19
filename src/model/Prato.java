package model;

public class Prato {

    private int id;
    private String nome;
    private double precos;

    public Prato(int id, String nome, double precos) {
        this.id = id;
        this.nome = nome;
        this.precos = precos;
    }

    public Prato(String nome, double precos) {
        this.nome = nome;
        this.precos = precos;
    }

    public Prato() {
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

    public double getPrecos() {
        return precos;
    }

    public void setPrecos(double precos) {
        this.precos = precos;
    }
}
