package Trabalhos.src.ProjetoBuscas;

import Trabalhos.src.ProjetoArvores.Arvores.ArvoreBinaria;
import Trabalhos.src.ProjetoBuscas.Buscas.BuscaBinaria;
import Trabalhos.src.ProjetoBuscas.Buscas.BuscaSequencial;
import Trabalhos.src.ProjetoSorts.GeradorDeArray;

import java.util.Random;

public class MenuBuscas {
    public void exibirBuscas(int repeticoes) {
        int[] volumes = {100, 1000, 10000};
        GeradorDeArray geradorDeArray = new GeradorDeArray();
        BuscaBinaria buscaBinaria = new BuscaBinaria();
        BuscaSequencial buscaSequencial = new BuscaSequencial();
        AnaliseEstatistica analiseEstatistica = new AnaliseEstatistica();

        for (int i : volumes) {
            System.out.println(i + " elementos: ");

            long[] temposSeq = new long[repeticoes];
            long[] temposBin = new long[repeticoes];
            long[] temposArv = new long[repeticoes];

            for (int j = 0; j < repeticoes; j++) {
                int[] valores = geradorDeArray.MedioCaso(i);
                int[] valoresBinario = geradorDeArray.MelhorCaso(i);
                int valor = valores[new Random().nextInt(i)];

                // Sequencial
                long inicio = System.nanoTime();
                buscaSequencial.buscaSequencial(valores, valor);
                long fim = System.nanoTime();
                temposSeq[j] = fim - inicio;

                // Binária
                inicio = System.nanoTime();
                buscaBinaria.buscaBinaria(valoresBinario, valor);
                fim = System.nanoTime();
                temposBin[j] = fim - inicio;

                //Arvore
                ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
                for (int val : valores) arvoreBinaria.inserir(arvoreBinaria.raiz, val);
                inicio = System.nanoTime();
                arvoreBinaria.busca(arvoreBinaria.raiz, valor);
                fim = System.nanoTime();
                temposArv[j] = fim - inicio;
            }

            System.out.println("Busca Sequencial -> Média: " +
                    analiseEstatistica.calcularMedia(temposSeq) +
                    " ns | Desvio: " +
                    analiseEstatistica.desvioPadrao(temposSeq));

            System.out.println("Busca Binária -> Média: " +
                    analiseEstatistica.calcularMedia(temposBin) +
                    " ns | Desvio: " +
                    analiseEstatistica.desvioPadrao(temposBin));

            System.out.println("Busca em Árvore -> Média: " +
                    analiseEstatistica.calcularMedia(temposArv) +
                    " ns | Desvio: " +
                    analiseEstatistica.desvioPadrao(temposArv));
            System.out.println(" ");
        }
        }
    }

