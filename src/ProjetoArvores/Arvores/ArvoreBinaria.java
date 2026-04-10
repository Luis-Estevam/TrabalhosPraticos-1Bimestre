package Trabalhos.src.ProjetoArvores.Arvores;

class No {
    public int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

public class ArvoreBinaria {
    public No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    //insercao
    public No inserir(No raiz, int valor) {
        if (raiz == null) return new No(valor);

        if (valor < raiz.valor) {
            raiz.esquerda = inserir(raiz.esquerda, valor);
        } else {
            raiz.direita = inserir(raiz.direita, valor);
        }

        return raiz;
    }

    //remover
    public No remover(No raiz, long valor) {
        if (raiz == null) return null;

        if (valor < raiz.valor) {
            raiz.esquerda = remover(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = remover(raiz.direita, valor);
        } else {
            // Encontrou o nó


            if (raiz.esquerda == null && raiz.direita == null) {
                return null;
            }

            if (raiz.esquerda == null) return raiz.direita;
            if (raiz.direita == null) return raiz.esquerda;

            No sucessor = raiz.direita;

            while (sucessor.esquerda != null) {
                sucessor = sucessor.esquerda;
            }

            // substitui valor
            raiz.valor = sucessor.valor;

            // remove o sucessor
            raiz.direita = remover(raiz.direita, sucessor.valor);
        }

        return raiz;
    }

    public int calcularAltura(No raiz) {
        if (raiz == null)
            return -1;

        int leftHeight = calcularAltura(raiz.esquerda);
        int rightHeight = calcularAltura(raiz.direita);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean busca(No raiz, int valor) {
        if (raiz == null) return false;

        if (raiz.valor == valor) return true;

        if (valor < raiz.valor) {
            return busca(raiz.esquerda, valor);
        }

        return busca(raiz.direita, valor);
    }

    public void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }
}

