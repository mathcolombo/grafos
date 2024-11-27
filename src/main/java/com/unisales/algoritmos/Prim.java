package com.unisales.algoritmos;

import java.util.Arrays;

public class Prim {
    public static int prim(Grafo grafo) {
        int n = grafo.getVertices();
        int[] chave = new int[n];
        boolean[] visitados = new boolean[n];

        Arrays.fill(chave, Integer.MAX_VALUE);
        chave[0] = 0;
        int custoTotal = 0;

        for (int i = 0; i < n; i++) {
            int u = minChave(chave, visitados);
            visitados[u] = true;
            custoTotal += chave[u];

            for (Grafo.Aresta aresta : grafo.getArestasDoVertice(u)) {
                int v = aresta.getDestino();
                int peso = aresta.getPeso();
                if (!visitados[v] && peso < chave[v]) {
                    chave[v] = peso;
                }
            }
        }

        return custoTotal;
    }

    private static int minChave(int[] chave, boolean[] visitados) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < chave.length; v++) {
            if (!visitados[v] && chave[v] < min) {
                min = chave[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
