package Trabalhos;

public class No {
    public long valor;
    public No esquerda;
    public No direita;
    int altura;

    public No(long valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}
