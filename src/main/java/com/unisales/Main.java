package com.unisales;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.unisales.algoritmos.Dijkstra;
import com.unisales.algoritmos.Grafo;
import com.unisales.algoritmos.Kruskal;
import com.unisales.algoritmos.Prim;

public class Main {
    public static void main(String[] args) {
        // Monitoramento de memória
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria máxima: " + runtime.maxMemory() / (1024 * 1024) + " MB");
        System.out.println("Memoria total: " + runtime.totalMemory() / (1024 * 1024) + " MB");
        System.out.println("Memoria livre: " + runtime.freeMemory() / (1024 * 1024) + " MB");

        try {
            // Configuração dos caminhos de entrada e saída
            String path = "C:\\Users\\Mathe\\Documentos\\faculdade\\4-Periodo\\PIE\\grafos\\src\\main\\java\\com\\unisales";

            processarRota(path, "bay");
            processarRota(path, "col");
            processarRota(path, "ny");

        } catch (IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
        }

        // Monitoramento final de memória
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " MB");
    }

    public static void processarRota(String pathBase, String nomeArquivo) throws IOException {
        String caminhoEntrada = pathBase + "\\files\\entrada\\" + nomeArquivo + ".gr";
        String caminhoSaida = pathBase + "\\files\\saida\\" + nomeArquivo + ".txt";

        // Leitura do grafo
        Grafo grafo = FileHandler.lerArquivo(caminhoEntrada);

        // Criar lista de adjacência
        List<List<Grafo.Aresta>> listaAdjacencia = grafo.getTodasArestas();

        // Execução e medição de tempos dos algoritmos
        StringBuilder resultado = new StringBuilder();

        // Dijkstra
        long inicioDijkstra = System.currentTimeMillis();
        int[] distancias = Dijkstra.dijkstra(grafo, 0);
        long fimDijkstra = System.currentTimeMillis();
        double tempoDijkstra = fimDijkstra - inicioDijkstra;

        resultado.append(">>>>>>>>>>>>>>>>>>>> Dijkstra <<<<<<<<<<<<<<<<<<<<").append("\n");
        resultado.append("\n");
        resultado.append("Distancias com Dijkstra: ").append(Arrays.toString(distancias)).append("\n");
        resultado.append(String.format("Tempo de execucao Dijkstra: %.1f ms\n", tempoDijkstra));
        resultado.append(">>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<").append("\n");

        // Kruskal
        long inicioKruskal = System.currentTimeMillis();
        int custoKruskal = Kruskal.kruskal(grafo);
        long fimKruskal = System.currentTimeMillis();
        double tempoKruskal = fimKruskal - inicioKruskal;

        resultado.append(">>>>>>>>>>>>>>>>>>>> Kruskal <<<<<<<<<<<<<<<<<<<<").append("\n");
        resultado.append("\n");
        resultado.append("Custo da AGM com Kruskal: ").append(custoKruskal).append("\n");
        resultado.append(String.format("Tempo de execucao Kruskal: %.1f ms\n", tempoKruskal));
        resultado.append(">>>>>>>>>>>>>>>>>>>>>>>>-<<<<<<<<<<<<<<<<<<<<<<<<").append("\n");
        // Prim
        long inicioPrim = System.currentTimeMillis();
        int custoPrim = Prim.prim(grafo);
        long fimPrim = System.currentTimeMillis();
        double tempoPrim = fimPrim - inicioPrim;

        resultado.append(">>>>>>>>>>>>>>>>>>>> Prim <<<<<<<<<<<<<<<<<<<<").append("\n");
        resultado.append("\n");
        resultado.append("Custo da AGM com Prim: ").append(custoPrim).append("\n");
        resultado.append(String.format("Tempo de execucao Prim: %.1f ms\n", tempoPrim));
        resultado.append(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<").append("\n");

        // Escrever resultados no arquivo
        FileHandler.escreverArquivo(caminhoSaida, resultado.toString());
        System.out.println("Resultados escritos em " + caminhoSaida);
    }
}
