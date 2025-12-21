package com;

public class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char caracter, int frequency){
        this.caracter = caracter;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}
