/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VueltaAtras;

import java.util.Scanner;
public class Laberinto {
    private static boolean Resuelve (int paso, int fila_actual, int columna_actual, String [][] tablero, int dimension, int[] incrX, int[] incrY) {
        boolean exito = false;
        for (int intento=0; intento<4  ;intento++) {
            int nuevaF = fila_actual + incrX[intento];
            int nuevaC = columna_actual + incrY[intento];
            if ((nuevaF>=0 && nuevaF<dimension) && (nuevaC>=0 && nuevaC<dimension)) {
                if (tablero[nuevaF][nuevaC].equals("S")) {
                    exito=true;
                }else if (tablero[nuevaF][nuevaC].equals(" ")) {
                    String numero = Integer.toString (paso);
                    tablero[nuevaF][nuevaC] = numero;
                    exito = Resuelve (paso+1, nuevaF, nuevaC , tablero, dimension, incrX, incrY);
                    if (!exito) {
                        tablero[nuevaF][nuevaC] =  " ";
                    }
               }
            }
             
         }
      return exito;
   }

    private static void imprimir (String [][] tablero) {
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
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        System.out.println("Dame la dimension del tablero MxM :");
        String linea = leer.nextLine();
        int dimension = Integer.parseInt(linea);
    
        String[][] tablero = new String[dimension][dimension];
        int[] incrX = new int[] { 0,-1,0, 1};
        int[] incrY = new int[] { -1, 0,1, 0};

        for (int i= 0; i< dimension; i++)
            for (int j=0; j< dimension; j++)
                tablero[i][j] = " ";
        
        tablero[0][0] = "E";
        tablero[2][2] = "M";
        tablero[dimension-1][dimension-1] = "S";
    
        boolean exito = Resuelve (1, 0, 0, tablero, dimension, incrX, incrY);
        if (exito)
            imprimir (tablero);
        else
            System.out.println("No hay solucion");
    }
}
