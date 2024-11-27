package com.unisales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import com.unisales.algoritmos.Grafo;

public class FileHandler {

    public static Grafo lerArquivo(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha = br.readLine();

        // Lê o número de vértices e arestas
        String[] partes = linha.split(" ");
        int vertices = Integer.parseInt(partes[0]);
        int arestas = Integer.parseInt(partes[1]);

        // Cria o grafo com o número de vértices
        Grafo grafo = new Grafo(vertices);

        // Lê as arestas do arquivo
        while ((linha = br.readLine()) != null) {
            partes = linha.split(" ");
            
            // Ignora a primeira parte (letra 'a') e ajusta os índices para 0-based
            int origem = Integer.parseInt(partes[1]) - 1;  // Ajustando para índice 0-based
            int destino = Integer.parseInt(partes[2]) - 1; // Ajustando para índice 0-based
            int peso = Integer.parseInt(partes[3]);

            // Verificação para garantir que os vértices estão dentro do intervalo válido
            if (origem >= 0 && origem < vertices && destino >= 0 && destino < vertices) {
                // Adiciona a aresta ao grafo
                grafo.adicionarAresta(origem, destino, peso);
            } else {
                System.out.println("Índice de vértice fora dos limites: origem = " + origem + ", destino = " + destino);
            }
        }

        br.close();
        return grafo;
    }

    public static void escreverArquivo(String caminho, String conteudo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
        bw.write(conteudo);
        bw.close();
    }
}
