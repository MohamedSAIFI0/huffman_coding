package com.example;

import java.io.FileWriter;
import java.io.IOException;

public class HuffmanGraphvizExporter {

    /**
     * Exporte l'arbre de Huffman vers un fichier .dot pour Graphviz
     * @param root racine de l'arbre Huffman
     * @param filename chemin du fichier .dot à générer
     */
    public static void exportToDot(HuffmanNode root, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("digraph HuffmanTree {\n");
            writer.write("    node [shape=circle];\n");
            writeDotNode(writer, root);
            writer.write("}\n");
        }
    }

    /**
     * Méthode récursive pour générer le code DOT
     * @return un identifiant unique pour le noeud
     */
    private static int writeDotNode(FileWriter writer, HuffmanNode node) throws IOException {
        if (node == null) return -1;

        int id = node.hashCode(); // identifiant unique pour Graphviz

        String label = (node.character != null)
                ? displayChar(node.character) + " (" + node.frequency + ")"
                : String.valueOf(node.frequency);
        writer.write(String.format("    %d [label=\"%s\"];\n", id, label));

        if (node.left != null) {
            int leftId = writeDotNode(writer, node.left);
            writer.write(String.format("    %d -> %d [label=\"0\"];\n", id, leftId));
        }
        if (node.right != null) {
            int rightId = writeDotNode(writer, node.right);
            writer.write(String.format("    %d -> %d [label=\"1\"];\n", id, rightId));
        }

        return id;
    }

    private static String displayChar(Character c) {
        if (c == null) return "*";
        switch (c) {
            case '\n': return "\\\\n";  // DOT literal
            case '\r': return "\\\\r";
            case '\t': return "\\\\t";
            case ' ':  return "' '";
            case '"':  return "\\\"";
            default:   return "'" + c + "'";
        }
    }
}
