package com.example.atv02_04.DTO;

import com.example.atv02_04.Entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String nome;
    private Long id;
    private double valor;
    private int saldo;
    private int saldomin;


    public Produto toProduto(){
        return new Produto(
                this.id,
                this.nome,
                this.valor,
                this.saldo,
                this.saldomin
        );
    }
    public ProdutoDTO fromProduto(Produto produto){
        return new ProdutoDTO(
                produto.getNome(),
                produto.getIdProduto(),
                produto.getValor(),
                produto.getSaldo(),
                produto.getSaldomin()
                );
    }

}
