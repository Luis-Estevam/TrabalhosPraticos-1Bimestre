package Trabalhos.src.ProjetoArvores;

public class MenuArvore {
    public void exibirCaixeiro() {
        CaixeiroViajante caixeiroViajante = new CaixeiroViajante();
        int[][] grafo = {
                {0, 20, 15, 20},
                {15, 15, 35, 25},
                {15, 0, 0, 35},
                {20, 25, 30, 0}
        };
        System.out.println("grafo = " +
                " {0, 20, 15, 20},\n" +
                "         {15, 15, 35, 25},\n" +
                "         {15, 0, 0, 35},\n" +
                "         {20, 25, 30, 0}");
        int resultado = caixeiroViajante.calcularTSP(grafo);


        System.out.println("Custo total: " + resultado);
    }
}
