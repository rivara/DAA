/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Voraz;

/**
 *
 * @author jvergara
 */
public class Mochila {
    public static int objetosNumero (int[] ps, int c) {
   // Problema de la mochila que consiste en coger cuantos más objetos mejor.
   // Precondicion: el array de pesos esta ordenado de forma creciente.
   // Devuelve el numero de objetos como maximo que podemos coger.
      int n = 0;
      int r = c;
      for (int i=0; i<ps.length; i++) {
         if (ps[i]<=r) {
            n++;
            r = r - ps[i];
         }
      }
      return n;
   }
    public static int objetosPeso (int[] ps, int c) {
   // Problema de la mochila que consiste en coger cuanto mas peso mejor. (cuando más ajustado mejor)
   // Precondicion: el array de pesos esta ordenado de forma creciente.
   // Devuelve el peso que hemos podido alcanzar.
      int p = 0;
      int r = c;
      for (int i=0; i<ps.length; i++) {
         if (ps[i]<=r) {
            p = p + ps[i];
            r = r - ps[i];
         }
      }
      return p;
   }
    

   public static float mochilaMejoresObjetos1 (int[] ps, int[] bs, int c) {
   //Mochila implementación mejor. Imprime los objetos seleccionados usando la mejor proporcion beneficio/peso
   // ps y bs ordenados en orden decreciente de b/p
       
      float[] xs = new float[ps.length];
      int p = c;
      float b = (float)0.0;
      for (int i=0; i<ps.length; i++) {
        // xs[i] = if (ps[i]<=p) ? (float)1.0 : (float)p/ps[i]);
         if (ps[i]<=p)
             xs[i] = (float)1.0;
         else 
             xs[i] = (float)p/ps[i];
         p -= ps[i]*xs[i];
         b += bs[i]*xs[i];
      }
      imprimir (xs);
      return b;
   }

   public static float mochilaMejoresObjetos2 (int[] ps, int[] bs, int c) {
     //Mochila implementación mejor. Imprime los objetos seleccionados usando la mejor proporcion beneficio/peso
     //vectores sin ordenar
      // se calculan tasas de b/p
      float[] ts = new float[ps.length];
      for (int i=0; i<ps.length; i++)
         ts[i] = (float)bs[i]/ps[i];
      
      // se ordenan los índices en 'is' según las tasas de b/p
      int[] is = new int[ps.length];
      is = ordenarIndices (ts);
      // el algoritmo voraz, usando el vector de índices 'is'
      float[] xs = new float[ps.length];
      int p = c;
      float b = (float)0.0;
      for (int i=0; i<ps.length; i++) {
         if (ps[is[i]]<=p) {
             xs[is[i]] = (float)1.0;
         }else {
             xs[is[i]] = (float)p/ps[is[i]];// una X parte de ese objeto
         }
         p -= xs[is[i]]*ps[is[i]];
         b += xs[is[i]]*bs[is[i]];
      }
      imprimir(xs);
      return b;
   }
   private static int[] ordenarIndices (float[] v1) {
   // se ordena por inserción directa según las tasas contenidas en 'v1'
      int[] v2 = new int[v1.length];
      v2[0] = 0;
      for (int i=1; i<v1.length; i++) {
         float aux = v1[i];
         int j;
         for (j=i-1; j>=0 && v1[v2[j]]<aux; j--)
            v2[j+1] = v2[j];
         v2[j+1] = i;
      }
      return v2;
   }
   
   private static void imprimir (float[] v) {
      for (int i=0; i<v.length; i++)
         System.out.print (v[i]+" ");
      System.out.println ();
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int pesos [] = {10, 34, 15, 5};
        int beneficios [] = {3,2,3,2};
        int capacidad_mochila = 10;
        mochilaMejoresObjetos2 (pesos, beneficios, capacidad_mochila);
        
    }
}
