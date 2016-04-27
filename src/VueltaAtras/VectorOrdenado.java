package VueltaAtras;



import java.util.Scanner;

/**
 *
 * @author Patricia
 */
public class VectorOrdenado {
    public static void main(String args[]) {
        int [] vector= {3,8,1,5,10};
        ordenar(vector);
        imprimir (vector);
    }
    
    public static void ordenar(int [] vector) {
        int [] solucion= new int[vector.length];
        boolean []usados = new boolean [vector.length];
        for (int i = 0; i< usados.length; i++) {
        	usados[i] = false;
        }

        ordenarAux(vector,solucion,usados, 0);

        for (int i = 0; i< solucion.length; i++) {
        	vector[i] = solucion[i];
        }

    }
    
    public static boolean ordenarAux(int [] vector, int[] solucion, boolean usados[], int etapa) {
    	boolean exito = false;

        for (int intento=0; intento<vector.length && !exito; intento++) {
            if (esFactible(vector,solucion,usados, etapa,intento)) {
                usados[intento] = true;
                solucion[etapa] = vector [intento];
                if (etapa==vector.length-1) {
                	exito = true;
                }else {
                	exito = ordenarAux (vector, solucion, usados, etapa+1);
                	if (!exito)
                		usados[intento] = false;
                }
            }
        }
        return exito;
    }
    
    public static boolean esFactible (int [] vector, int[] solucion,  boolean usados[], int etapa, int intento) {
        
        boolean ok = true;


        if (etapa==0)
        	return (usados[intento]==false);
        else{
        	System.out.println(solucion[etapa-1]+" "+vector[intento]);
        	boolean v=((usados[intento]==false) && (solucion[etapa-1]<vector[intento]));
        	if(v==true){
        		imprimir(solucion);
        		//System.out.println(usados[intento]+" "+solucion[etapa-1]+" "+vector[intento]);
        		//System.out.println((usados[intento]==false)+"*"+(solucion[etapa-1]<vector[intento]));
        	}
			return v;
        }
    }
    
   
    
    
    public static void imprimir(int [] vector) {
        System.out.println(" Solucion:");
        System.out.print("[ ");
        for (int i=0; i<vector.length; i++) {
            System.out.print(vector[i]+ " ");
        }
        System.out.println("]");
    }
}
