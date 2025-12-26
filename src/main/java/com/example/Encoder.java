package com.example;
import java.util.Map;

public class Encoder {
    public static String encode(String text, Map<Character, String> codes) {
        if (text == null || codes == null) return "";

        StringBuilder encoded = new StringBuilder();

        for (char c : text.toCharArray()) {
            String code = codes.get(c);
            if (code != null) {
                encoded.append(code);
            } else {
                System.err.println("Avertissement : Aucun code Huffman trouvé pour le caractère : '" + c + "' (code Unicode: " + (int)c + ")");
            }
        }

        return encoded.toString();
    }
}
