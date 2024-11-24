package com.unisales.algoritmos;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
    public int calcularAGM(Grafo grafo) {
        boolean[] visitado = new boolean[grafo.getVertices()];
        PriorityQueue<Grafo.Aresta> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        int custoTotal = 0;

        fila.add(new Grafo.Aresta(0, 0)); // Começa no vértice 0
        while (!fila.isEmpty()) {
            Grafo.Aresta atual = fila.poll();
            int destino = atual.destino;

            if (visitado[destino]) continue;
            visitado[destino] = true;
            custoTotal += atual.peso;

            for (Grafo.Aresta vizinho : grafo.getAdjacentes(destino)) {
                if (!visitado[vizinho.destino]) {
                    fila.add(vizinho);
                }
            }
        }

        return custoTotal;
    }
}
