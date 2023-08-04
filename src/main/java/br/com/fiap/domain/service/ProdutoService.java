package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.repository.ProdutoRepository;

import java.util.Objects;

public class ProdutoService {

    public static Produto persist(Produto p){
        if(Objects.isNull(p.getNome())){
            return null;

        }
        if(Objects.isNull(p.getDescricao())){
            return null;
        }
        if(Objects.isNull(p.getValor())){
            return null;
        }

        return ProdutoRepository.persist(p);



    }





}
