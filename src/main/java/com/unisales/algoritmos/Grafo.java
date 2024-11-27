package com.unisales.algoritmos;

import java.util.*;

public class Grafo {
    public int vertices; // Número de vértices
    public List<List<Aresta>> adjacencias; // Lista de adjacência

    // Construtor do grafo
    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencias = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencias.add(new ArrayList<>());
        }
    }

    // Método para adicionar aresta ao grafo (grafo não direcionado)
    public void adicionarAresta(int origem, int destino, int peso) {
        adjacencias.get(origem).add(new Aresta(origem, destino, peso));
        adjacencias.get(destino).add(new Aresta(destino, origem, peso)); // Grafo não direcionado
    }
    

    // Método para obter a lista de arestas de um vértice específico
    public List<Aresta> getArestasDoVertice(int vertice) {
        return adjacencias.get(vertice);
    }

    // Método para obter todas as arestas do grafo
    public List<List<Aresta>> getTodasArestas() {
        return adjacencias;
    }

    // Classe interna para representar uma aresta
    public static class Aresta {
        public int origem;
        public int destino;
        public int peso;
    
        // Construtor da aresta
        public Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    
        // Métodos getters
        public int getOrigem() {
            return origem;
        }
    
        public int getDestino() {
            return destino;
        }
    
        public int getPeso() {
            return peso;
        }
    }
    

    // Getter para o número de vértices
    public int getVertices() {
        return vertices;
    }
}
