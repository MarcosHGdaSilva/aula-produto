package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.ProdutoEstocado;
import br.com.fiap.domain.repository.DepositoRepository;
import br.com.fiap.domain.repository.ProdutoRepository;
import br.com.fiap.domain.service.ProdutoEstocadoService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarOutputStream;
public class ProdutoEstocadoView {
    List<Produto> produtos = new ArrayList<>();
    List<Deposito> depositos = new ArrayList<>();
    List<ProdutoEstocado> produtosEstocados = new ArrayList<>();
    public List<ProdutoEstocado> formEstocar() {

        ProdutoRepository produtoRepository = new ProdutoRepository();
        DepositoRepository depositoRepository = new DepositoRepository();

        produtos = ProdutoRepository.findAll();
        depositos = DepositoRepository.findAll();
        if (produtos.size() > 0 && depositos.size() > 0) {
            Produto produto = (Produto) JOptionPane.showInputDialog(null, "Escolha o produto", "Seleção de produtos", JOptionPane.QUESTION_MESSAGE, null, produtos.toArray(), produtos.get(0) );
            if (Objects.isNull(produto)) return produtosEstocados;

            Deposito deposito = (Deposito) JOptionPane.showInputDialog(null, "Escolha o depósito", "Seleção de depósitos", JOptionPane.QUESTION_MESSAGE, null, depositos.toArray(), depositos.get(0) );
            if (Objects.isNull(deposito)) return produtosEstocados;

            Integer quantidade = 0;
            do {
                quantidade = Integer.valueOf(JOptionPane.showInputDialog("Informe a quantidade de Itens do produto "+produto.getNome()+" que deseja encaminhar ao estoque"));
            }while (quantidade <= 0);

            for (int i = 0; i < quantidade; i++){
                ProdutoEstocado pe = new ProdutoEstocado();
                pe.setProduto(produto).setDeposito(deposito);
                produtosEstocados.add(ProdutoEstocadoService.entrada(pe));
            }


            if(produtosEstocados.size()>0) JOptionPane.showMessageDialog(null, "Sucesso!\n" +produtosEstocados.size()+ " itens de "+ produto.getNome() +" foram estocados com sucesso em "+ deposito.getNome() );

        }else{
            JOptionPane.showMessageDialog(null, "Não é possível estocar. Verifique se existem produtos e depósitos disponíveis ");
        }

        return produtosEstocados;
    }
}
