package com.unisales.algoritmos;

import java.util.*;

public class Dijkstra {
    public int[] calcularCaminhoMinimo(Grafo grafo, int origem) {
        int vertices = grafo.getVertices();
        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        fila.add(new int[]{origem, 0});

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int u = atual[0];

            for (Grafo.Aresta aresta : grafo.getAdjacentes(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    fila.add(new int[]{v, distancias[v]});
                }
            }
        }

        return distancias;
    }
}

