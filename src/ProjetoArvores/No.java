package Trabalhos.src.ProjetoArvores;

public class No {
    public long valor;
    public No esquerda;
    public No direita;

    public No(long valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
