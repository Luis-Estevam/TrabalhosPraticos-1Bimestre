package Trabalhos.src.ProjetoArvores;

public class CaixeiroViajante {
    public int calcularTSP(int[][] grafo) {

        int n = grafo.length;

        boolean[] visitado = new boolean[n];
        int[] caminho = new int[n + 1]; // +1 para voltar ao início

        int custoTotal = 0;
        int atual = 0;

        visitado[0] = true;
        caminho[0] = 0;

        for (int i = 0; i < n - 1; i++) {

            int maisProximo = -1;
            int menorDistancia = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && grafo[atual][j] < menorDistancia) {
                    maisProximo = j;
                    menorDistancia = grafo[atual][j];
                }
            }

            visitado[maisProximo] = true;
            custoTotal += menorDistancia;
            atual = maisProximo;

            caminho[i + 1] = atual; // guarda o caminho
        }

        // volta para a cidade inicial
        custoTotal += grafo[atual][0];
        caminho[n] = 0;

        // imprimir caminho
        System.out.print("Caminho: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(caminho[i]);
            if (i < n) System.out.print(" -> ");
        }
        System.out.println();

        return custoTotal;
    }
    }

