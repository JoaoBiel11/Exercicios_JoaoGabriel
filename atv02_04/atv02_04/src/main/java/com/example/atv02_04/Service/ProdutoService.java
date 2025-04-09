package com.example.atv02_04.Service;

import com.example.atv02_04.DTO.ProdutoDTO;
import com.example.atv02_04.Entity.Produto;
import com.example.atv02_04.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll(){

        return produtoRepository.findAll();
    }

    public Optional<ProdutoDTO> getById(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            ProdutoDTO produtoDTO = new ProdutoDTO();
            return Optional.of(produtoDTO.fromProduto(produtoOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public Optional<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            Produto produto = produtoOptional.get();
            produto.setNome(produtoDTO.getNome());
            produto.setValor(produtoDTO.getValor());
            produto.setSaldo(produtoDTO.getSaldo());
            produto.setSaldomin(produtoDTO.getSaldomin());

            produto = produtoRepository.save(produto);

            return Optional.of(produtoDTO.fromProduto(produto));
        }else{
            return Optional.empty();
        }
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



