package VueltaAtras;

import java.util.Scanner;

/**
*
* @author rivara
*/


public class quinceMagico {


	 public static boolean quinceMagico (int paso, int solucion []) {

	        boolean exito=false;
	     //   solucion[paso] = 0; //No esta colocada
	        for (int intento=1;  intento<9 && !exito;intento++) {
	            solucion [paso]= intento;
	            // comprueba que no se pase de 15
	            if (es_factible (intento, paso, solucion)) {
	            	//comprueba el numero de casillas maximo 3 (de 0 a 2)g
	                if (paso!=2) {
	                    imprimir (solucion);
	                    exito=quinceMagico(paso+1, solucion);
	                }
	                }else {
	                	//si la suma es 15 t 
	                	if(suma(solucion)==15){
	                    exito=true;
	                	}else{
	                    //si no hacemos bactracking
	                	exito=quinceMagico(paso-1, solucion);
	                	}
	                }
	            }
	        
	        
	        return exito;
	 }

	    public static boolean es_factible (int intento, int paso, int solucion[]) {
	    // si la suma de lo que llevamos es 15 o menos ok 
	    if(suma(solucion)<=15)
	    	return true;
	    //si se supera devolvemos un 0
	    return false;
	    }
	 
	 private static void imprimir (int[] v) {
	        for (int i=0; i<v.length; i++)
	            System.out.print (v[i]+"*");
	        System.out.println();
	    }
	 
	 
	 
	 private static int suma (int[] v) {
		 int sum=0;
	        for (int i=0; i<v.length; i++)
	           sum=sum +v[i];
	        System.out.println("la suma es ="+sum);
	       return sum;
	    }


	public static void main(String[] args) {
		
		
		 int solucion []= new int [3];
		   if (!quinceMagico (0, solucion)) {
	           System.out.println("Tenemos solucion");
	           imprimir (solucion);
	       }else {
	           System.out.println("No tenemos solucion");
	       }

	}

}
