package com.unisales.algoritmos;

import java.util.*;

public class Dijkstra {

    public static int[] dijkstra(Grafo grafo, int origem) {
        int vertices = grafo.getVertices(); // Número de vértices
        int[] distancias = new int[vertices]; // Array para armazenar as distâncias mínimas
        boolean[] visitado = new boolean[vertices]; // Array para controlar os vértices visitados

        // Inicializa as distâncias como infinito (um valor alto)
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        // Usando uma fila de prioridade (min-heap) para encontrar o próximo vértice com a menor distância
        PriorityQueue<Vertice> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.distancia));
        pq.add(new Vertice(origem, 0));

        while (!pq.isEmpty()) {
            Vertice verticeAtual = pq.poll();
            int u = verticeAtual.id;

            // Se o vértice já foi visitado, ignore-o
            if (visitado[u]) continue;
            visitado[u] = true;

            // Verifica as arestas conectadas ao vértice atual
            for (Grafo.Aresta aresta : grafo.getArestasDoVertice(u)) {
                int v = aresta.getDestino();
                int peso = aresta.getPeso();

                // Relaxamento: Se a distância atual é menor que a distância conhecida
                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    pq.add(new Vertice(v, distancias[v]));
                }
            }
        }

        return distancias;
    }

    // Classe interna para representar um vértice
    private static class Vertice {
        int id;
        int distancia;

        Vertice(int id, int distancia) {
            this.id = id;
            this.distancia = distancia;
        }
    }
}
