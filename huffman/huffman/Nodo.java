/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author jvergara
 */
 // Huffman trie node
public class Nodo implements Comparable<Nodo> {
        public final Caracter caracter;
        public final Nodo left, right;

        Nodo(Caracter caracter, Nodo left, Nodo right) {
            this.caracter  = caracter;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        public boolean isLeaf() {

            return (left == null && right == null);
        }

        // compare, based on frequency
        public int compareTo(Nodo that) {
            float aux = (this.caracter.getPorcentaje()*100) - (that.caracter.getPorcentaje()*100);
            int a;
            a = (int) aux;
            return a;
        }
    }
