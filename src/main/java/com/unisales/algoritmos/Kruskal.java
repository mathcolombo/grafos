package com.unisales.algoritmos;

import java.util.*;

public class Kruskal {
    public static int kruskal(Grafo grafo) {
        // Coletando todas as arestas do grafo
        List<Grafo.Aresta> arestas = new ArrayList<>();
        for (int i = 0; i < grafo.getVertices(); i++) {
            arestas.addAll(grafo.getArestasDoVertice(i));
        }

        // Ordenando as arestas por peso
        Collections.sort(arestas, Comparator.comparingInt(a -> a.getPeso()));

        int[] pai = new int[grafo.getVertices()];
        for (int i = 0; i < grafo.getVertices(); i++) {
            pai[i] = i; // Inicializa os pais de cada vértice como eles mesmos
        }

        int custoTotal = 0;

        // Percorrendo as arestas e aplicando o algoritmo de Kruskal
        for (Grafo.Aresta aresta : arestas) {
            int origem = aresta.getOrigem(); // A origem da aresta
            int destino = aresta.getDestino(); // O destino da aresta

            // Verifica se origem e destino estão em diferentes componentes (usando find)
            if (find(origem, pai) != find(destino, pai)) {
                custoTotal += aresta.getPeso(); // Soma o peso da aresta à solução
                union(origem, destino, pai); // Une os dois componentes
            }
        }

        return custoTotal;
    }

    // Método para encontrar o "pai" do vértice, com compressão de caminho
    private static int find(int v, int[] pai) {
        if (pai[v] != v) {
            pai[v] = find(pai[v], pai); // Compressão de caminho
        }
        return pai[v];
    }

    // Método para unir dois conjuntos de vértices
    private static void union(int u, int v, int[] pai) {
        pai[find(u, pai)] = find(v, pai); // Une as duas partes do grafo
    }
}
