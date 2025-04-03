package com.example.atv02_04.Service;

import com.example.atv02_04.DTO.ProdutoDTO;
import com.example.atv02_04.Entity.Produto;
import com.example.atv02_04.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Produto fromDTO(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setNome(produtoDTO.getNome());
        produto.setSaldo(produtoDTO.getSaldo());
        produto.setValor(produtoDTO.getValor());
        produto.setSaldomin(produtoDTO.getSaldomin());


        return produto;
    }

    public ProdutoDTO toDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getIdProduto());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setSaldo(produto.getSaldo());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setSaldomin(produto.getSaldomin());

        return produtoDTO;
    }

    public ProdutoDTO save(ProdutoDTO professorDTO){
        Produto produto = this.fromDTO(professorDTO);
        Produto produtoBd = produtoRepository.save(produto);
        return this.toDTO(produtoBd);
    }
        public boolean delete(Long id){
            if(produtoRepository.existsById(id)){
                produtoRepository.deleteById(id);
                return true;
            }else {
                return false;
            }
        }
    }



