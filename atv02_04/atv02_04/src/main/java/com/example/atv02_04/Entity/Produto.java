package com.example.atv02_04.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProduto;
    private String nome;
    private double valor;
    private int saldo;
    private int saldomin;


    public Produto(Long idProduto, String nome, double valor, int saldo, int saldomin) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.saldo = saldo;
        this.saldomin = saldomin;
    }

    public Produto() {

    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
}
