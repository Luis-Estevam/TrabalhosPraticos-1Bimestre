package Trabalhos.src.ProjetoSorts.Sorts;

public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i];
            int j = i -1;

            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j -1;
            }
            arr[j + 1] = chave;
        }
    }
}
