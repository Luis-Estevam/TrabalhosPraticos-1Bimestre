package Trabalhos.src;

import Trabalhos.src.ProjetoSorts.MenuSort;
import Trabalhos.src.ProjetoBuscas.MenuBuscas;
import Trabalhos.src.ProjetoArvores.MenuArvore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MenuSort menuSort = new MenuSort();
        MenuBuscas menuBuscas = new MenuBuscas();
        MenuArvore menuArvore = new MenuArvore();

        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Benchmark de Ordenação");
            System.out.println("2 - Análise de Buscas");
            System.out.println("3 - Exemplo Caixeiro Viajante");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Informe o tamanho do array: ");
                    int tamanho = scanner.nextInt();
                    menuSort.exibirBenchmark(tamanho);
                    break;

                case 2:
                    System.out.print("Informe o número de repetições: ");
                    int repeticoes = scanner.nextInt();
                    menuBuscas.exibirBuscas(repeticoes);
                    break;

                case 3:
                    menuArvore.exibirCaixeiro();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
