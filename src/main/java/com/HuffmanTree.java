package com;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    /*
    * Cette classe a un attribut root qui correspond à la racine de l'arbre de Huffman à construire.
    */

    private  final HuffmanNode root;

    /*
    * Le constructeur HuffmanTree prend en paramètre le dictionnaire des fréquences.
    *Dans le dictionnaire key=Caractère et Value=La fréquence
    * Le constructeur appelle ensuite la méthode qui permet de construire l'arbre de Huffman
    * à savoir buildHuffmanTree
    * */
    public HuffmanTree(Map<Character, Integer> freqDict) {
        this.root = buildHuffmanTree(freqDict);
    }

    //Retourne la racine de l'arbre
    public HuffmanNode getRoot() {
        return root;
    }

    //Methode principale permettant de construire l'arbre de Huffman.
    private HuffmanNode buildHuffmanTree(Map<Character, Integer> freqDict) {
        /*
        * On crée une PriorityQueue qui est l'implémentation JAVA d'un tas minimal.
        * Le minimum inséré se trouve en tête et on y accède avec
        * poll(poll récupère le sommet et le supprime dans le heap).
        * L'étude du minimum dans notre cas porte sur la fréquence.
        * */
        PriorityQueue<HuffmanNode> heap = new PriorityQueue<>();

        /*
        *On parcourt le dictionnaire de fréquences.
        * On récupère le caractère et sa fréquence. On crée un HuffmanNode.
        * Et on l'insère dans le heap.
        */
        for (Map.Entry<Character, Integer> entry : freqDict.entrySet()) {
            heap.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        /*
        *On construit l'arbre de Huffman.
        * On récupère le noeud avec la plus petite fréquence.
        * On récupère le deuxième noeud avec la plus petite fréquence.
        * On crée un nouveau noeud ayant comme fréquence la somme des noeuds minimaux.
        * Les noeuds minimaux récupérés deviennent des fils de ce nouveau noeud.
        * On insère ce nouveau dans le heap.
        * On répète le processus jusqu'à ce que le heap soit vide.
        */
        while (heap.size() > 1) {
            HuffmanNode node1 = heap.poll();
            HuffmanNode node2 = heap.poll();
            HuffmanNode merged = null;
            if (node2 != null) {
                merged = new HuffmanNode(
                        null,
                        node1.frequency + node2.frequency,
                        node1,
                        node2
                );
            }
            heap.add(merged);
        }

        /*On retourne la racine qui nous permet d'avoir tout l'arbre grâce aux attributs
        fils gauche et fils droit
        */
        return heap.poll();
    }
}

