package com;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String text=FileUtils.readFile("exemple.txt");
        Map<Character, Integer> frequencies=FrequencyAnalyzer.countFrequency(text);
        HuffmanTree huffmanTree = new HuffmanTree(frequencies);
        System.out.println("===== Arbre de Huffman =====");
        huffmanTree.printTree();
    }
}