package Trabalhos.src.ProjetoBuscas;

public class AnaliseEstatistica {
    public double calcularMedia(long[] resultados) {
        double soma = 0;
        for (long i: resultados) {
            soma += i;
        }
        return soma / resultados.length;
    }

    public double desvioPadrao(long[] resultados) {
        double media = calcularMedia(resultados);
        double soma = 0;

        for (long i : resultados) {
            soma += Math.pow(i - media, 2);
        }
        return Math.sqrt(soma / resultados.length);
    }
}
