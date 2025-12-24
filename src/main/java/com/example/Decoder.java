package com.example;

public class Decoder {

    public static String decode(String encoded, HuffmanNode root) {
        if (encoded == null || root == null) return "";

        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            } else {
                throw new IllegalArgumentException("Invalid bit: " + bit);
            }

            // Leaf reached
            if (current.left == null && current.right == null) {
                decoded.append(current.character);
                current = root; // restart from root
            }
        }

        return decoded.toString();
    }
}
