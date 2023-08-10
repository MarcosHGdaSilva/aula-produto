package br.com.fiap;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.repository.ProdutoRepository;
import br.com.fiap.domain.service.DepositoService;
import br.com.fiap.domain.service.ProdutoService;
import br.com.fiap.domain.view.DepositoView;
import br.com.fiap.domain.view.ProdutoView;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

//        List<Produto> produtos = ProdutoRepository.findAll();
//
//        for (Produto produto : produtos) {
//            System.out.println( produto );
//        }
//        Produto prod = ProdutoRepository.findById( 8L );
//
//        System.out.println(prod);

//        List<Produto> produtos = ProdutoRepository.findByName( "ipad" );
//
//        produtos.forEach( System.out::println );

//        ProdutoView view = new ProdutoView();
//        Produto produto = view.form();
//        var p = ProdutoService.persist(produto);
//        if(Objects.nonNull(p)){
//            System.out.println(p);
//        }else{
//           System.out.printf("Não foi possível salvar o produto");
//        }

        DepositoView view = new DepositoView();
        Deposito deposito = view.form();

        var d = DepositoService.persist(deposito);

        if (Objects.isNull(d)){
            System.out.println("Não foi possível salvar o Depósito");
        }else{
            System.out.println(d);
        }
    }
}