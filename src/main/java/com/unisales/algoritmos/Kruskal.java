package com.unisales.algoritmos;

import java.util.*;

public class Kruskal {
    public static class ConjuntoDisjunto {
        int[] pai, rank;

        public ConjuntoDisjunto(int tamanho) {
            pai = new int[tamanho];
            rank = new int[tamanho];
            for (int i = 0; i < tamanho; i++) pai[i] = i;
        }

        public int encontrar(int v) {
            if (pai[v] != v) pai[v] = encontrar(pai[v]);
            return pai[v];
        }

        public boolean unir(int u, int v) {
            int raizU = encontrar(u), raizV = encontrar(v);
            if (raizU == raizV) return false;

            if (rank[raizU] > rank[raizV]) pai[raizV] = raizU;
            else if (rank[raizU] < rank[raizV]) pai[raizU] = raizV;
            else {
                pai[raizV] = raizU;
                rank[raizU]++;
            }
            return true;
        }
    }

    public int calcularAGM(int vertices, List<Grafo.Aresta> arestas) {
        arestas.sort(Comparator.comparingInt(a -> a.peso));
        ConjuntoDisjunto cd = new ConjuntoDisjunto(vertices);
        int custoTotal = 0;

        for (Grafo.Aresta aresta : arestas) {
            if (cd.unir(aresta.destino, aresta.peso)) {
                custoTotal += aresta.peso;
            }
        }

        return custoTotal;
    }
}

