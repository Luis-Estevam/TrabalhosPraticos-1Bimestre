package Trabalhos.src.ProjetoBuscas.Buscas;

public class BuscaSequencial {
    public int buscaSequencial(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
