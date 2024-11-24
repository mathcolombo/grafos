package com.unisales.algoritmos;

import java.util.*;

public class Grafo {
    private final int vertices;
    private final List<List<Aresta>> adjacencia;

    public Grafo(int vertices) {
        this.vertices = vertices;
        this.adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        adjacencia.get(origem).add(new Aresta(destino, peso));
        adjacencia.get(destino).add(new Aresta(origem, peso)); // Para grafos não direcionados
    }

    public List<Aresta> getAdjacentes(int vertice) {
        return adjacencia.get(vertice);
    }

    public int getVertices() {
        return vertices;
    }

    public static class Aresta {
        int destino, peso;

        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}

