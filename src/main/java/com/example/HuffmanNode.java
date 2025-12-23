<<<<<<< HEAD:src/main/java/com/example/HuffmanNode.java
package com.example;

public class HuffmanNode {
}
=======
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

    public HuffmanNode(Character character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}
>>>>>>> origin/lyrach_branch:src/main/java/com/HuffmanNode.java
