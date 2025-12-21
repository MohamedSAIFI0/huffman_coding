package com;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    private  HuffmanNode root;

    public HuffmanTree(Map<Character, Integer> freqDict) {
        this.root = buildHuffmanTree(freqDict);
    }

    public HuffmanNode getRoot() {
        return root;
    }

    private HuffmanNode buildHuffmanTree(Map<Character, Integer> freqDict) {
        PriorityQueue<HuffmanNode> heap = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : freqDict.entrySet()) {
            heap.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (heap.size() > 1) {
            HuffmanNode node1 = heap.poll();
            HuffmanNode node2 = heap.poll();
            HuffmanNode merged = null;
            if (node2 != null) {
                merged = new HuffmanNode(
                        null,
                        node1.frequency + node2.frequency
                );
            }
            heap.add(merged);
        }

        return heap.peek();
    }
}

