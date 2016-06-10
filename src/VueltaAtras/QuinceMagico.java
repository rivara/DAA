package VueltaAtras;




public class QuinceMagico {

    
    public static void main(String[] args) {
        quinceMagico();
    }
    
    public static void quinceMagico(){
        back(0,0, new int[3][3]);
        
    }
    
    public static void back(int fila,int columna, int[][] tablero){
        boolean exito = false;
        
        for(int x = 1; x < 10; x++){
            tablero[fila][columna] = x;//marcar
            if(esPosible(fila, columna, tablero, x)){
                
               if(columna == 2 && fila == 2){
                 //   imprimirTablero(tablero);
                }else{
                    int nextCol = columnaSiguiente(fila, columna);
                    int nextFil = filaSiguiente(fila, columna);
                    back(nextFil, nextCol, tablero);
                }
            }else{
                exito = false;
            }
        }
            tablero[fila][columna] = 0;//desmarcar
        
    }
    
    public static boolean esPosible(int fila, int columna, int[][] tablero, int intento){
      boolean ok = true;
        int aux = 0;
        //fila correcta
        
        for(int c = 0; c <= columna; c++){
            aux += tablero[fila][c];
        }
        if(columna==2){
            ok = ok && aux == 15;
        }else{
            ok = ok && aux < 15;
        }
        
        //columna correcta
        aux = 0;
        for(int f = 0; f <= fila; f++){
            aux += tablero[f][columna];
        }
        if(fila ==2){
            ok = ok&& aux == 15;
        }else{
            ok = ok && aux < 15;
        }
        //diagonal 2 correcta
        aux = 0;
        for(int i = 0; i < 3; i++){
            aux += tablero[i][i];
        }
        if((fila == 2) && (columna == 2))
            ok = ok && aux==15;
        else if(fila == columna)
            ok = ok && aux < 15;
        //diagonal 1 correcta
        aux = 0;
        for(int i = 2; i >= 0; i--){
            aux += tablero[2-i][i];
        }
        if((fila == 2) && (columna == 2))
            ok = ok && aux==15;
        else if(fila == columna)
            ok = ok && aux < 15;
       //comprobacion de repetidos --MIRAR
        for(int f = 0; f <= fila && ok; f++){
            for(int c = 0; c < 3 && ok; c++){
                if(f < fila)
                    ok = tablero[f][c] != intento;
                else{
                    if(c < columna)
                        ok = tablero[f][c] != intento;
                }
            }
        }
        
        
        return ok;
    	
    }
    
    public static int columnaSiguiente(int fila, int columna){
        
        if(columna == 2)
            return 0;
        else return columna+1;
    }
    
    public static int filaSiguiente(int fila, int columna){
        if(columna ==2)
            return fila +1;
        else
            return fila;
    }
    
    public static void imprimirTablero(int[][] tab){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                System.out.print(tab[j][i] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println("- - - ");
    }
    
}
