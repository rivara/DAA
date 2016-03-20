package VueltaAtras;

import java.util.Scanner;

/**
*
* @author rivara
*/


public class quinceMagico {

	public quinceMagico() {
		// TODO Auto-generated constructor stub
	}
	
	 public static boolean ReinasN (int paso, int solucion [], int dimension) {
	        Scanner leer = new Scanner(System.in);

	        boolean exito=false;
	        solucion[paso] = -1; //No esta colocada
	        for (int intento=0; intento<dimension && !exito; intento++) {
	            solucion [paso]= intento;
	            if (es_factible (intento, paso, solucion)) {
	                if (paso!=dimension-1) {
	                    imprimir (solucion);
	                    String linea = leer.nextLine();
	                    exito=ReinasN (paso+1, solucion, dimension);
	                }else {
	                    exito=true;
	                }
	            }
	        }
	        return exito;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
