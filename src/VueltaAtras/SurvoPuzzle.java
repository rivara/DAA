package VueltaAtras;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author agustin
 */
public class SurvoPuzzle {
    
    
    public static boolean esFactible(int filaActual, int columnaActual, int[][] tablero, int N, int M, int intento){
        
      
        //sumamos la fila actual
        int acuFila = 0;
        for (int columna=0; columna<=columnaActual;columna++) {
            acuFila = acuFila + tablero[filaActual][columna];
        }
        boolean okFila = true;
        if (columnaActual == M - 1) {
            okFila = (acuFila == tablero[filaActual][M]);
        }else if (columnaActual < M- 1){                   
            okFila =  (acuFila < tablero[filaActual][M]);
        }


        //sumamos la columna actual
        int acuColumna = 0;
        for (int fila=0; fila<=filaActual;fila++) {
            acuColumna = acuColumna + tablero[fila][columnaActual];
        }
        boolean okColumna = true;
        if (filaActual == N - 1) {
            okColumna = (acuColumna == tablero[N][columnaActual]);
        }else if (filaActual < N - 1){                   
            okColumna =  (acuColumna < tablero[N][columnaActual]);
        }

        
       // System.out.println(encontradoColumnas);
       // sc.nextLine();
        
        //Comprobamos repetidos

        int contador_vistos = 0;
        for (int i = 0; i < N && contador_vistos<2; i++){
            for (int j = 0; j < M && contador_vistos<2; j++){
                if (tablero[i][j] == intento)
                    contador_vistos++;
            }
            
        }

     
        return okFila && okColumna && contador_vistos<2;
    }
    
    public static int dameSigY (int filaActual, int columnaActual, int N, int M){
        if (columnaActual == M - 1){
            return 0;
        }else{
            return columnaActual + 1;
        }
        
    }
    
    public static int dameSigX (int filaActual, int columnaActual, int N, int M){
        if (columnaActual == M - 1){
            return filaActual + 1;
        }else{
            return filaActual;
        }
        
    }
    
    public static boolean resuelveBT(int filaActual, int columnaActual, int [][] tablero, int N, int M){
        boolean exito = false;

        if (tablero[filaActual][columnaActual] != 0) {
            if (esFactible(filaActual, columnaActual, tablero, N, M, tablero[filaActual][columnaActual])){
                if (filaActual == N - 1 && columnaActual == M - 1){
                    exito = true;
                }else{
                    int sigX = dameSigX (filaActual, columnaActual, N, M);
                    int sigY = dameSigY (filaActual, columnaActual, N, M);
                    //imprimir (tablero);
                    //sc.nextLine();
                    exito = resuelveBT(sigX, sigY, tablero, N, M);
                } 
            }
        }else {
            for (int intento = 1; intento <= (N * M) && !exito; intento++){
                
                tablero[filaActual][columnaActual] = intento;
               
                if (esFactible(filaActual, columnaActual, tablero, N, M, intento)){
                    if (filaActual == N - 1 && columnaActual == M - 1){
                        exito = true;
                    }else{
                        int sigX = dameSigX (filaActual, columnaActual, N, M);
                        int sigY = dameSigY (filaActual, columnaActual, N, M);
                        //imprimir (tablero);
                        //sc.nextLine();
                        exito = resuelveBT(sigX, sigY, tablero, N, M);
                        if (!exito){
                            //jvergara: ojo desmarcabas en sigX y sigY
                            tablero[filaActual][columnaActual] = 0;
                        }
                    } 
                }

                //jvergara
                if (!exito){
                    tablero[filaActual][columnaActual] = 0;
                }

            }
        }
        
        return exito;
    }
    
    
    public static void imprimir (int[][] tablero){
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        
        
    }
    
    
    public static void main(String[] args) {
        
        //Scanner N = new Scanner (System.in);
        //Scanner M = new Scanner (System.in);
        //System.out.println("Dame la dimension N del tablero: ");
        int dimensionFilas = 3;
       // System.out.println("Dame la dimension M del tablero");
        int dimensionColumnas = 4;

        int[][] tablero = {{0, 6, 0, 0, 30}, {8, 0, 0, 0, 18}, {0, 0, 3, 0, 30}, {27, 16, 10, 25}};
        
        boolean exito = resuelveBT(0, 0, tablero, dimensionFilas, dimensionColumnas);
        
        if (exito){
            imprimir (tablero);
        }else{
            System.out.println("No hay solucion para el tablero propuesto");
            
        }
        
        
    
    
    }
    
}
