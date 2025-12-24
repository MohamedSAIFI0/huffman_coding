package com.example;

public class CompressionUtils {

    public static int originalSizeBits(String text) {
        if (text == null) return 0;
        return text.length() * 8;
    }

    public static int compressedSizeBits(String encoded) {
        if (encoded == null) return 0;
        return encoded.length();
    }

    public static double compressionRatio(String text, String encoded) {
        int original = originalSizeBits(text);
        int compressed = compressedSizeBits(encoded);

        if (original == 0) return 0.0;
        return (double) compressed / original;
    }

    public static double compressionGain(String text, String encoded) {
        return 1.0 - compressionRatio(text, encoded);
    }
}
