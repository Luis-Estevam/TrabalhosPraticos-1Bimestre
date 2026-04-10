package Trabalhos.src.ProjetoSorts;

public class Benchmark {
    BubbleSort bubble = new BubbleSort();
    InsertionSort insertion = new InsertionSort();

    public long MedirBubbleSort (int[] array) {
        long inicio = System.nanoTime();
        bubble.bubbleSort(array);
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public long MedirInsertionSort(int[] array) {
        long inicio = System.nanoTime();
        insertion.insertionSort(array);
        long fim = System.nanoTime();
        return fim - inicio;
    }

}
