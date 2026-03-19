package model;

public class Prato {

    private int id;
    private String nome;
    private double precos;
    private int estoque;

    public Prato(int id, String nome, double precos, int estoque) {
        this.id = id;
        this.nome = nome;
        this.precos = precos;
        this.estoque = estoque;
    }

    public Prato(String nome, double precos, int estoque) {
        this.nome = nome;
        this.precos = precos;
        this.estoque = estoque;
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
