package VueltaAtras;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author jvergara
 */
public class LaberintoV2_0 {
    private static void Resuelve (int paso, int fila_actual, int columna_actual, String [][] tablero, int dimension, int[] incrX, int[] incrY, String [][] mejor_tablero, int []pasos_mejor) {
        //if (paso>pasos_mejor[0])
          //  return;

        for (int intento=0; intento<4; intento++) {
            int nuevaF = fila_actual + incrX[intento];
            int nuevaC = columna_actual + incrY[intento];
            
            if ((nuevaF>=0 && nuevaF<dimension) && (nuevaC>=0 && nuevaC<dimension)) {
                if (tablero[nuevaF][nuevaC].equals("S")) {
                    if (paso<pasos_mejor[0]) {
                        pasos_mejor[0] = paso;
                        for (int i=0; i<tablero.length; i++) {
                            for (int j=0; j<tablero[0].length; j++) {
                                mejor_tablero[i][j] = tablero[i][j];
                            }
                        }
                    }
                }else if (tablero[nuevaF][nuevaC].equals(" ")) {
                    String numero = Integer.toString (paso);
                    tablero[nuevaF][nuevaC] = numero;
                    Resuelve (paso+1, nuevaF, nuevaC , tablero, dimension, incrX, incrY, mejor_tablero, pasos_mejor);
                    tablero[nuevaF][nuevaC] =  " ";
               }
                
            }
             
         }
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
        //Variables para hacer la mejor solucion
        String[][] mejor_tablero = new String[dimension][dimension];
        int pasos_mejor[] = new int[1];
        pasos_mejor[0]= dimension*dimension;
        //Fin variables para hacer la mejor solucion


        int[] incrX = new int[] { 1,-1,0, 0};
        int[] incrY = new int[] { 0, 0,1, -1};

        for (int i= 0; i< dimension; i++)
            for (int j=0; j< dimension; j++)
                tablero[i][j] = " ";
        
        tablero[0][0] = "E";
        tablero[2][2] = "M";
        tablero[dimension-1][dimension-1] = "S";


    
        Resuelve (1, 0, 0, tablero, dimension, incrX, incrY, mejor_tablero, pasos_mejor);
        
        imprimir (mejor_tablero);
        
    }
}
