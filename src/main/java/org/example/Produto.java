package org.example;

import java.util.Observable;

public class Produto extends Observable {

    private String nomeProduto;
    private String categoria;
    private String descricao;
    private String vendedor;

    public Produto(String nomeProduto, String categoria, String descricao, String vendedor) {
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.descricao = descricao;
        this.vendedor = vendedor;
    }

    public void iniciarPromocao(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome='" + nomeProduto + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Descricao='" + descricao + '\'' +
                ", Vendedor='" + vendedor + '\'' +
                '}';
    }
}