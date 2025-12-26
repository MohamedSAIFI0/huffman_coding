package com.example;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCodeGenerator {

    /**
     * Génère le dictionnaire des codes Huffman à partir de la racine.
     * Gère également le cas particulier d'un arbre à un seul nœud.
     */
    public static Map<Character, String> generateCodes(HuffmanNode root) {
        Map<Character, String> codesMap = new HashMap<>();

        if (root == null) return codesMap;

        // CAS PARTICULIER : L'arbre n'a qu'un seul nœud (ex: texte = "aaaaa")
        // Dans ce cas, la racine est une feuille et n'a pas d'enfants.
        if (root.left == null && root.right == null) {
            codesMap.put(root.character, "0");
            return codesMap;
        }

        // Cas général : appel de la récursion
        generateCodesRecursive(root, "", codesMap);
        return codesMap;
    }

    /**
     * Méthode récursive pour parcourir l'arbre.
     */
    private static void generateCodesRecursive(HuffmanNode node, String code, Map<Character, String> codesMap) {
        if (node == null) return;

        // Si c'est une feuille (le caractère n'est pas nul)
        if (node.left == null && node.right == null) {
            codesMap.put(node.character, code);
        } else {
            // On ajoute '0' pour la branche gauche et '1' pour la branche droite
            generateCodesRecursive(node.left, code + "0", codesMap);
            generateCodesRecursive(node.right, code + "1", codesMap);
        }
    }

}