package Trabalhos.src.ProjetoBuscas.Buscas;

public class BuscaBinaria {
    public int buscaBinaria(int[] array, int valor) {
        int inicio = 0;
        int fim = array.length -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (array[meio] == valor){
                return meio;
            } else if (array[meio] < valor) {
                inicio = meio + 1;
            } else fim = meio -1;
        }
        return -1;
    }
}
