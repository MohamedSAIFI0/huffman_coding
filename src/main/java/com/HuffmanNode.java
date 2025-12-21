package com;

public class HuffmanNode implements Comparable<HuffmanNode>{
    Character character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Character character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}
