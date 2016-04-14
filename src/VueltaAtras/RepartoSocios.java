package VueltaAtras;
import java.util.Scanner;


public class RepartoSocios {
	public static boolean es_factible (int cosas[], int solucion[], int etapa, int intento) {
		int total = 0;
		int asignado_socio1 = 0;
		int asignado_socio2 = 0;
		
		for (int i=0; i<cosas.length; i++) {
			total = total + cosas [i];
			if (solucion[i]==1) {
				asignado_socio1 = asignado_socio1 + cosas [i];
			}
			if (solucion[i]==2) {
				asignado_socio2 = asignado_socio2 + cosas [i];
			}
		}
		
		if (intento==1) {//Pretendes darselo al socio 1
			if ((asignado_socio1 + cosas[etapa]) > (total/2))
				return false;
		}
		if (intento==2) {//Pretendes darselo al socio 1
			if ((asignado_socio2 + cosas[etapa]) > (total/2))
				return false;
		}
		
		return true;
		
		
	}
	public static boolean BT (int cosas[], int solucion[], int etapa) {
		boolean exito = false;
		for (int intento =1; intento<=2 && !exito ; intento++) {
			if (es_factible (cosas, solucion, etapa, intento)) { //etapa= el objeto
				solucion[etapa]=intento;						//intento= a quién se lo das
				if (etapa == cosas.length-1) {
					exito = true;
				}else {
					exito = BT (cosas, solucion, etapa+1);
					if (!exito) {
						solucion[etapa]=0; 
					}
				}
			}
		}
		return exito;
		
	}
	public static void BTTodas (int cosas[], int solucion[], int etapa) {
		//Scanner in = new Scanner (System.in);
		
		for (int intento =1; intento<=2  ; intento++) {
			if (es_factible (cosas, solucion, etapa, intento)) { //etapa= el objeto
				solucion[etapa]=intento;	//intento= a quién se lo das
				//imprimir (solucion);
				//in.nextLine();
				if (etapa == cosas.length-1) {
					imprimir (solucion);
				}else {
					BTTodas (cosas, solucion, etapa+1);
				}
				solucion[etapa]=0; 
			}
		}
		
	}
	public static void imprimir (int solucion []) {
		for (int i=0; i<solucion.length; i++) {
			System.out.println ("Objeto: "+i+" =>"+solucion[i]);
		}
	}
	public static void main (String args[]) {
		System.out.println ("Reparto de socios");
		int cosas [] = {40,20,25,5,10};
		int solucion[] = new int[cosas.length];
		
		/*
		boolean exito = BT (cosas, solucion, 0);
		if (exito) {
			imprimir (solucion);
		}else {
			System.out.println ("No se puede hacer un reparto justo");
		}
		*/
		BTTodas (cosas, solucion, 0);
	}
}










