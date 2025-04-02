package com.example.atv02_04.DTO;

import com.example.atv02_04.Entity.Produto;

public class ProdutoDTO {
    private String nome;
    private Long id;
    private double valor;
    private int saldo;
    private int saldomin;


    public ProdutoDTO(){
    }

    public ProdutoDTO(String nome, int valor, int saldo, int saldomin, Long id) {
        this.nome = nome;
        this.valor = valor;
        this.saldo = saldo;
        this.saldomin = saldomin;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldomin() {
        return saldomin;
    }

    public void setSaldomin(int saldomin) {
        this.saldomin = saldomin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
