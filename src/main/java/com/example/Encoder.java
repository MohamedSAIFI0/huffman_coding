package com.example;

public class Encoder {

    /**
     * Encode un texte en utilisant le tableau ASCII optimisé.
     *
     */
    public static String encode(String text, String[] asciiArray) {
        if (text == null || asciiArray == null) return "";

        StringBuilder encoded = new StringBuilder();

        for (char c : text.toCharArray()) {
            // Vérifie que le caractère est dans la plage ASCII
            if (c < 256 && asciiArray[c] != null) {
                encoded.append(asciiArray[c]);
            } else {
                // Optionnel : gérer les caractères non-ASCII
                System.err.println("Caractère non supporté : " + c);
            }
        }

        return encoded.toString();
    }
}
