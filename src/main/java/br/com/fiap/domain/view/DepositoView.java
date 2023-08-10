package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Deposito;

import javax.swing.*;

public class DepositoView {

    public Deposito form(){

        String nome = null;

        do{
            nome = JOptionPane.showInputDialog("nome do Depósito");

        }while (nome==null);


        return new Deposito(null, nome);
    }
}
