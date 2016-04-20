/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VueltaAtras;

import java.util.Scanner;

/**
 *
 * @author jvergara
 */
public class SaltoDelCaballo {
    private static boolean Resuelve (int paso, int fila_actual, int columna_actual, int[][] tablero, int dimension, int[] incrX, int[] incrY) {
        boolean exito = false;
        for (int intento=0; intento<8 && !exito; intento++) {
            int nuevaF = fila_actual + incrX[intento];
            int nuevaC = columna_actual + incrY[intento];
            //Exportable //es factible
            if ((nuevaF>=0 && nuevaF<dimension) && (nuevaC>=0 && nuevaC<dimension)) {
                if (tablero[nuevaF][nuevaC] == 0) {
                	//si es 0 lo meto ya que esa posicion es válida marco
                    tablero[nuevaF][nuevaC] = paso;
                    if (paso==dimension*dimension)
                        exito = true;
                    else {
                        exito = Resuelve (paso+1,nuevaF, nuevaC , tablero, dimension, incrX, incrY);
                       //desmarca ese numero no es válido
                      
                    }
               }
            }
      
             
         }
      return exito;
   }
   private static void imprimir (int[][] tablero) {
      for (int i=0; i<tablero.length; i++) {
         for (int j=0; j<tablero.length; j++)
            System.out.print (tablero[i][j]+"  ");
         System.out.println();
      }
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Dame la dimension del tablero MxM (Ejemplo 5):");
        String linea = leer.nextLine();
        int dimension = Integer.parseInt(linea);
    
        int[][] tablero = new int[dimension][dimension];
        int[] incrX = new int[] {-1,  1,  2, 2, 1, -1, -2, -2};
        int[] incrY = new int[] {-2, -2, -1, 1, 2,  2,  1, -1};

        tablero[0][0] = 1;
        boolean exito = Resuelve (2, 0, 0, tablero, dimension, incrX, incrY);
        if (exito)
            imprimir (tablero);
        else
            System.out.println("No hay solucion");
    }
}
