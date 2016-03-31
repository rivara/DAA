/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VueltaAtras;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jvergara
 */

public class Sudoku {
    public static int dame_cuadrante (int posicion) {
        return ((int) (posicion / 3)) * 3;
    }
    public static boolean es_valido (int intento, int tablero [][], int fila_actual, int columna_actual, int dimension) {
        //System.out.println ("pos: "+ fila_actual+ " "+ columna_actual);
        //Comprobamos la columna que no exista el mismo numero
        for (int fila = 0; fila <dimension; fila++) {
            if (tablero [fila][columna_actual]==intento)
                return false;
        }
        for (int columna = 0; columna <dimension; columna++) {
            if (tablero [fila_actual][columna]==intento)
                return false;
        }
        //Ahora comprobamos cuadrante
        int inicio_fila, inicio_columna;
        inicio_fila = dame_cuadrante (fila_actual);
        inicio_columna = dame_cuadrante (columna_actual);
       // System.out.println ("inicio: "+ inicio_fila+ " "+ inicio_columna);
        for (int i= inicio_fila; i<inicio_fila+3; i++){
            for (int j= inicio_columna; j<inicio_columna+3; j++){
        //        System.out.println (i+ " "+ j);
               if (tablero [i][j]==intento)
                   return false;
            }
        }
        
        return true;
    }
    private static boolean Resuelve (int fila_actual, int columna_actual, int [][] tablero, int dimension) {
        boolean exito = false;
        int fila_nueva, columna_nueva;
        //System.out.println ("=====================");
        //imprimir (tablero);
        //System.out.println ("=====================");
        if (tablero[fila_actual][columna_actual] !=0) {
            if ((fila_actual==dimension-1) && (columna_actual==dimension-1)) {
                return true;
            }else {
                if (columna_actual==dimension-1) {
                    columna_nueva = 0;
                    fila_nueva = fila_actual +1;
                }else {
                    columna_nueva = columna_actual +1;
                    fila_nueva = fila_actual;
                }
                return Resuelve (fila_nueva, columna_nueva, tablero, dimension);
            }
            
        }else {
            for (int intento=1; intento<=9 && !exito; intento++) {
                if (es_valido(intento, tablero, fila_actual, columna_actual, dimension)) {
                    tablero[fila_actual][columna_actual] = intento;
                    if ((fila_actual==dimension-1) && (columna_actual==dimension-1)) {
                        exito = true;
                    }else {
                        if (columna_actual==dimension-1) {
                            columna_nueva = 0;
                            fila_nueva = fila_actual +1;
                        }else {
                            columna_nueva = columna_actual +1;
                            fila_nueva = fila_actual;
                        }
                        exito = Resuelve (fila_nueva, columna_nueva, tablero, dimension);
                        if (!exito) {
                            tablero [fila_actual][columna_actual] = 0;
                        }
                    }
                }

            }
            return exito;
        }
   }
     private static int ResuelveTodas (int fila_actual, int columna_actual, int [][] tablero, int dimension) {
        
        int fila_nueva, columna_nueva;
        int cont_soluciones = 0;
        //System.out.println ("=====================");
        //imprimir (tablero);
        //System.out.println ("=====================");
        if (tablero[fila_actual][columna_actual] !=0) {
            if ((fila_actual==dimension-1) && (columna_actual==dimension-1)) {
                cont_soluciones = cont_soluciones + 1;
                //imprimir (tablero);
                //Scanner leer = new Scanner(System.in);
                //String linea = leer.nextLine();
                
            }else {
                if (columna_actual==dimension-1) {
                    columna_nueva = 0;
                    fila_nueva = fila_actual +1;
                }else {
                    columna_nueva = columna_actual +1;
                    fila_nueva = fila_actual;
                }
                cont_soluciones = cont_soluciones + ResuelveTodas (fila_nueva, columna_nueva, tablero, dimension);
            }
            
        }else {
            for (int intento=1; intento<=9; intento++) {
                if (es_valido(intento, tablero, fila_actual, columna_actual, dimension)) {
                    tablero[fila_actual][columna_actual] = intento;
                    if ((fila_actual==dimension-1) && (columna_actual==dimension-1)) {
                        cont_soluciones = cont_soluciones + 1;
                        //System.out.println ("=====================");
                        //imprimir (tablero);
                        //System.out.println ("=====================");
                    }else {
                        if (columna_actual==dimension-1) {
                            columna_nueva = 0;
                            fila_nueva = fila_actual +1;
                        }else {
                            columna_nueva = columna_actual +1;
                            fila_nueva = fila_actual;
                        }
                        cont_soluciones = cont_soluciones + ResuelveTodas (fila_nueva, columna_nueva, tablero, dimension);
                    }
                    tablero [fila_actual][columna_actual] = 0;
                }

            }
        }
        return cont_soluciones;
        
   }
    private static void imprimir (int [][] tablero) {
        for (int i=0; i<tablero.length; i++) {
            for (int j=0; j<tablero.length; j++)
                System.out.print (tablero[i][j]+"    ");
         System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
       // System.out.println("Dame la dimension del tablero MxM (9):");
       // String linea = leer.nextLine();
        //int dimension = Integer.parseInt(linea);
        int dimension = 9;
        int[][] tablero = new int[dimension][dimension];
     

        for (int i= 0; i< dimension; i++)
            for (int j=0; j< dimension; j++)
                tablero[i][j] = 0;
        
        for (int i= 0; i< dimension; i++) {
             String linea = leer.nextLine();
             String [] trozos = linea.split(" ");
             for (int j = 0; j < dimension; j++) {
                 tablero [i][j] = Integer.parseInt(trozos [j]);
             }
        }
        
        /*boolean  exito= Resuelve (0, 0, tablero, dimension);
        if (exito)
            imprimir (tablero);
        else
            System.out.println("No hay solucion");
        */
      
        
        int num_soluciones = ResuelveTodas (0, 0, tablero, dimension);
        
        System.out.println("Tiene soluciones: "+ num_soluciones);
    }
}
