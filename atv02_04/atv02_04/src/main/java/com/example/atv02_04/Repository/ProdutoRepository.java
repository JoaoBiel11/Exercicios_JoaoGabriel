package com.example.atv02_04.Repository;

import com.example.atv02_04.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
