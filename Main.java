package Trabalhos;

import Trabalhos.arvores.ArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        No raiz = new No(123);

        arvore.inserir(raiz, 122);
        arvore.inserir(raiz, 111);
        arvore.inOrder(raiz);
    }
}
