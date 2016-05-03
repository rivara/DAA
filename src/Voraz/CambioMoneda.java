package Voraz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * @author jvergara
 */
public class CambioMoneda {

    /**
     * @param args the command line arguments
     */
   static int[] unidades = {200, 100, 50, 20, 10, 5, 2, 1};

   public static int cambiarMonedas2 (int total) {
      int[] cambio = new int[unidades.length];
      int monedas = 0;
      int resto = total;
      for (int i=0; i<unidades.length && resto!=0; i++) {
         cambio[i] = resto/unidades[i];
         monedas = monedas + cambio[i];
         resto = resto % unidades[i];
      }
     
      imprimir (cambio);
      return (monedas);
   }

  private static void imprimir (int[] v) {
      for (int i=0; i<v.length; i++)
         System.out.println ("Monedas de "+unidades[i]+": "+v[i]);
   }
    public static void main(String[] args) {
        // TODO code application logic here
        int totalmonedas_en_mano = cambiarMonedas2 (36);
        System.out.println ("Total monedas: "+ totalmonedas_en_mano);
    }
}








