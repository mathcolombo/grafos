package com.unisales;

import java.io.*;
import java.util.*;

import com.unisales.algoritmos.Dijkstra;
import com.unisales.algoritmos.Grafo;
import com.unisales.algoritmos.Kruskal;
import com.unisales.algoritmos.Prim;

public class GrafoProcessor {

    private static String pathGeral = "C:\\Users\\Mathe\\Documentos\\faculdade\\4-Periodo\\PIE\\grafos\\src\\main\\java\\com\\unisales\\files";
    public static void main(String[] args) throws IOException {
        escreverResultados();
    }

    // Método para escrever os resultados
    private static void escreverResultados() throws IOException {

        // quantAlgoritmo == 1 -> Djikstra
        // quantAlgoritmo == 2 -> Kruskal
        // quantAlgoritmo == 3 -> Prim
        for(int quantAlgoritmo = 1 ; quantAlgoritmo <= 3 ; quantAlgoritmo++) {

            // Executa leitura dos grafos usando Djikstra
            if(quantAlgoritmo == 1) {

                // rota == 1 -> BAY
                // rota == 2 -> COL
                // rota == 3 -> NY
                for(int rota = 1 ; rota <= 3 ; rota++) {

                    // Executa leitura do grafo BAY
                    if(rota == 1) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\bay-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\djikstra\\bay-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota BAY com Djikstra");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executar Dijkstra e medir o tempo
                                long tempoDijkstra = executarDijkstra(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoDijkstra + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo COL
                    if(rota == 2) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\col-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\djikstra\\col-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota COL com Djikstra");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executar Dijkstra e medir o tempo
                                long tempoDijkstra = executarDijkstra(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoDijkstra + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo NY
                    if(rota == 3) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\ny-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\djikstra\\ny-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota NY com Djikstra");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executar Dijkstra e medir o tempo
                                long tempoDijkstra = executarDijkstra(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoDijkstra + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }
                }
            }

            // Executa leitura dos grafos usando Kruskal
            if(quantAlgoritmo == 2) {

                // rota == 1 -> BAY
                // rota == 2 -> COL
                // rota == 3 -> NY
                for(int rota = 1 ; rota <= 3 ; rota++) {

                    // Executa leitura do grafo BAY
                    if(rota == 1) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\bay-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\kruskal\\bay-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota BAY com Kruskal");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Kruskal e mede o tempo
                                long tempoKruskal = executarKruskal(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoKruskal + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo COL
                    if(rota == 2) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\col-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\kruskal\\col-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota COL com Kruskal");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Kruskal e mede o tempo
                                long tempoKruskal = executarKruskal(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoKruskal + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo NY
                    if(rota == 3) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\ny-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\kruskal\\ny-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota NY com Kruskal");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Kruskal e mede o tempo
                                long tempoKruskal = executarKruskal(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoKruskal + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }
                }
            }

            // Executa leitura dos grafos usando Prim
            if(quantAlgoritmo == 3) {

                // rota == 1 -> BAY
                // rota == 2 -> COL
                // rota == 3 -> NY
                for(int rota = 1 ; rota <= 3 ; rota++) {

                    // Executa leitura do grafo BAY
                    if(rota == 1) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\bay-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\prim\\bay-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota BAY com Prim");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Prim e mede o tempo
                                long tempoPrim = executarPrim(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoPrim + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo COL
                    if(rota == 2) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\col-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\prim\\col-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota COL com Prim");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Prim e mede o tempo
                                long tempoPrim = executarPrim(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoPrim + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }

                    // Executa leitura do grafo NY
                    if(rota == 3) {
    
                        String arquivoEntrada = pathGeral + "\\entrada\\ny-entrada.gr"; // Caminho do arquivo de entrada

                        String arquivoSaida = pathGeral + "\\saida\\prim\\ny-saida.csv"; // Caminho do arquivo de saída CSV
    
                        Grafo grafo = lerGrafo(arquivoEntrada);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
                            writer.write("Origem,Destino,Tempo (ms)\n");
                
                            System.out.println("Executando leitura da rota NY com Prim");

                            // Inicia o contador para escrever no final do arquivo
                            long inicio = System.currentTimeMillis();

                            for (int destino = 1; destino < grafo.getVertices(); destino++) {
            
                                // Executa Prim e mede o tempo
                                long tempoPrim = executarPrim(grafo, 0, destino);
                                writer.write(0 + "," + destino + "," + tempoPrim + "\n");
                            }

                            long fim = System.currentTimeMillis();
                            long tempoSegundos = (fim - inicio) / 1000;
                            long tempoMinutos = (fim - inicio) / 60000;

                            writer.write("Tempo total de execução -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");

                            System.out.println(" -> " + tempoSegundos + " segundos || " + tempoMinutos + " minutos");
                        }
                    }
                }
            }
        }
    }

    // Método para ler o grafo do arquivo .gr
    private static Grafo lerGrafo(String arquivo) throws IOException {
        int maxVertice = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 4) {
                    int origem = Integer.parseInt(partes[1]);
                    int destino = Integer.parseInt(partes[2]);
                    maxVertice = Math.max(maxVertice, Math.max(origem, destino));
                }
            }
        }
    
        // Criar o grafo com o número de vértices encontrado (+1 porque os vértices começam de 0)
        Grafo grafo = new Grafo(maxVertice + 1);
    
        // Reabrir o arquivo para adicionar as arestas
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 4) {
                    int origem = Integer.parseInt(partes[1]);
                    int destino = Integer.parseInt(partes[2]);
                    int peso = Integer.parseInt(partes[3]);
                    grafo.adicionarAresta(origem, destino, peso);
                }
            }
        }
        return grafo;
    }
    
    // Método para executar o algoritmo de Dijkstra
    private static long executarDijkstra(Grafo grafo, int origem, int destino) {
        long inicio = System.currentTimeMillis();
        
        // Supondo que você tenha a classe Dijkstra já implementada
        Dijkstra dijkstra = new Dijkstra();
        int[] distancias = dijkstra.calcularCaminhoMinimo(grafo, origem);
        
        // Aqui, você pode acessar a distância entre os nós (distancias[destino])
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    // Método para executar o algoritmo de Prim
    private static long executarPrim(Grafo grafo, int origem, int destino) {
        long inicio = System.currentTimeMillis();
        
        Prim prim = new Prim();
        int custoTotal = prim.calcularAGM(grafo);
        
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    // Método para executar o algoritmo de Kruskal
    private static long executarKruskal(Grafo grafo, int origem, int destino) {
        long inicio = System.currentTimeMillis();
        
        Kruskal kruskal = new Kruskal();
        List<Grafo.Aresta> arestas = new ArrayList<>();
        for (int i = 0; i < grafo.getVertices(); i++) {
            for (Grafo.Aresta aresta : grafo.getAdjacentes(i)) {
                arestas.add(aresta);
            }
        }
        int custoTotal = kruskal.calcularAGM(grafo.getVertices(), arestas);
        
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }
}
