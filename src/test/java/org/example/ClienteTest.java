package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto("Samsung Galaxy S21", "Celulares", "Celular top de linha Samsung", "Magazine Luíza");
        Cliente cliente = new Cliente("Alice");
        cliente.acompanhar(produto);
        produto.iniciarPromocao();
        assertEquals("Alice, promoção iniciada no Produto{Nome='Samsung Galaxy S21', Categoria='Celulares', Descricao='Celular top de linha Samsung', Vendedor='Magazine Luíza'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto produto = new Produto("Geladeira Samsung", "Eletrodomésticos", "Geladeira Frost Free Samsung", "Magazine Luíza");
        Cliente cliente1 = new Cliente("Gabriela");
        Cliente cliente2 = new Cliente("Bruno");
        cliente1.acompanhar(produto);
        cliente2.acompanhar(produto);
        produto.iniciarPromocao();
        assertEquals("Gabriela, promoção iniciada no Produto{Nome='Geladeira Samsung', Categoria='Eletrodomésticos', Descricao='Geladeira Frost Free Samsung', Vendedor='Magazine Luíza'}", cliente1.getUltimaNotificacao());
        assertEquals("Bruno, promoção iniciada no Produto{Nome='Geladeira Samsung', Categoria='Eletrodomésticos', Descricao='Geladeira Frost Free Samsung', Vendedor='Magazine Luíza'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        Produto produto = new Produto("Fogão Samsung", "Eletrodomésticos", "Fogão 5 bocas Samsung", "Magazine Luíza");
        Cliente cliente = new Cliente("Antônio");
        produto.iniciarPromocao();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunoProduto1() {
        Produto produto1 = new Produto("Geladeira Samsung", "Eletrodomésticos", "Geladeira Frost Free Samsung", "Magazine Luíza");
        Produto produto2 = new Produto("Samsung Galaxy S21", "Celulares", "Celular top de linha Samsung", "Magazine Luíza");
        Cliente cliente1 = new Cliente("Alice");
        Cliente cliente2 = new Cliente("Bruno");
        cliente1.acompanhar(produto1);
        cliente2.acompanhar(produto2);
        produto1.iniciarPromocao();
        assertEquals("Alice, promoção iniciada no Produto{Nome='Geladeira Samsung', Categoria='Eletrodomésticos', Descricao='Geladeira Frost Free Samsung', Vendedor='Magazine Luíza'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

}