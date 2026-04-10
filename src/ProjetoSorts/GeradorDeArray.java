package Trabalhos.src.ProjetoSorts;

import java.util.Random;

public class GeradorDeArray {
    public int[] MelhorCaso(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
           array[i] = i;
        }
        return array;
    }

    public int[] PiorCaso(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    public int[] MedioCaso(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho);
        }
        return array;
    }
}
