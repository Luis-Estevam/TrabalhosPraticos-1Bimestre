package Trabalhos.src.ProjetoSorts;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public void exibir(int tamanho) {

        GeradorDeArray geradorDeArray = new GeradorDeArray();
        Benchmark benchmark = new Benchmark();

        int[] melhorCaso = geradorDeArray.MelhorCaso(tamanho);
        int[] piorCaso = geradorDeArray.PiorCaso(tamanho);
        int[] casoMedio = geradorDeArray.MedioCaso(tamanho);

        //bubble
        long melhorBubble = benchmark.MedirBubbleSort(melhorCaso);
        long piorBubble = benchmark.MedirBubbleSort(piorCaso);
        long medioBubble = benchmark.MedirBubbleSort(casoMedio);

        //insertion
        long melhorInsertion = benchmark.MedirInsertionSort(melhorCaso);
        long piorInsertion = benchmark.MedirInsertionSort(piorCaso);
        long medioInsertion = benchmark.MedirInsertionSort(casoMedio);

        //Resultados
        System.out.println("====== Tempos BubbleSort: ======");
        System.out.println("Melhor caso: " + melhorBubble);
        System.out.println("Pior caso: " + piorBubble);
        System.out.println("Medio caso: " + medioBubble);

        System.out.println("====== Tempos InsertionSort: ======");
        System.out.println("Melhor caso: " + melhorInsertion);
        System.out.println("Pior caso: " + piorInsertion);
        System.out.println("Medio caso: " + medioInsertion);
    }
}
