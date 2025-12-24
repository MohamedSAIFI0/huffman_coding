package com.example;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        String text = FileUtils.readFile("exemple.txt");
        System.out.println("Original text:");
        System.out.println(text);
        System.out.println("===================================");

        Map<Character, Integer> frequencies=FrequencyAnalyzer.countFrequency(text);
        System.out.println("************ Les frequences de chaque char ********************");
        frequencies.forEach((character, integer) -> {
            if (character == '\n') {
                System.out.print("\\n"+"=>"+integer+"\t");
            }else if(character == '\r'){
                System.out.print("\\r"+"=>"+integer+"\t");
            }
            else{System.out.print(character+"=>"+integer+"\t");}
        });
        System.out.println("\n***************************************");

        HuffmanTree huffmanTree = new HuffmanTree(frequencies);
        System.out.println("*************************  Huffman tree display  ***************************");
        huffmanTree.printTreeHorizontal(huffmanTree.getRoot());
        System.out.println("\n***************************************************************");
        System.out.println("************ Les codes de chaque char ********************");
        Map<Character, String> codes = HuffmanCodeGenerator.generateCodes(huffmanTree.getRoot());
        codes.forEach((character, string) -> {
            if (character == '\n') {
                System.out.print("\\n"+"=>"+string+"\t");
            }else if(character == '\r'){
                System.out.print("\\r"+"=>"+string+"\t");
            }
            else{System.out.print(character+"=>"+string+"\t");}
        });
        System.out.println("\n***************************************");
    }
}