package VueltaAtras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Subcolecciones {

	public static ArrayList <boolean []> soluciones = new ArrayList<boolean []>();
	
	

	public static boolean esFactible (boolean [] usados, int intento, int etapa, int []c, int cont_seleccionados, int m) {
		if (intento==0) {
			//Si decidimos descartarlo es porque mas adelante quedan numeros tantos como para completar mi objetivo
			
			//Cuantos me quedan por seleccionar?
			int quedan = m-cont_seleccionados;
			//Cuantos candidatos quedarían para coger después de esta etapa?
			int candidatos = usados.length - (etapa+1);
			
			if (candidatos>=quedan)
				return true; 
			else 
				return false;
		}
		
		//Si el intento es 1 sera cogerlo y hay que comprobar la condicion de divisible
		//Buscamos el primer cierto que sera el menor y probamos si este es divisible
		boolean encontrado = false;
		int posicion=0;
		for (int i=0; i<usados.length && !encontrado ; i++) {
			if (usados[i]) {
				encontrado=true;
				posicion = i;
			}
		}
		if (encontrado) {
			if ((c[etapa]%c[posicion]) !=0)
				return false;
		}
		
		return true;
		
	}

	public static void BT (int c[], boolean []usados, int etapa,  int cont_seleccionados, int m) throws IOException {
		
		//BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		//cin.readLine();
		for (int intento=0; intento <=1; intento++) {
			//Si el intento es 0 no lo cogemos, 
			//Si el intento es 1 si lo cogemos.
			if (esFactible(usados, intento, etapa, c, cont_seleccionados, m)) {
				if (intento==1) {
					usados[etapa] = true;
					
					if (cont_seleccionados+1 == m) {
						soluciones.add(usados.clone());
					} else {
						if (etapa + 1< usados.length)
							BT(c, usados, etapa + 1,cont_seleccionados+1, m);	
					}
				}else {
					usados[etapa]=false;
					if (etapa + 1< usados.length)
						BT(c, usados, etapa+1,cont_seleccionados , m);
				}
			}
			usados[etapa] = false;
		}
	}



	
	/**
	 * @param args
	 */
	private static void mostrar2(boolean[] sol) {
		System.out.print("Solucion: ");
		for (int i = 0; i < (sol.length); i++) {
			
				System.out.print(sol[i] + ", ");
		}
		System.out.println ("");
	} 
	private static void mostrar(boolean[] sol, int[] c) {
		System.out.print("Solucion: ");
		for (int i = 0; i < (sol.length); i++) {
			if (sol[i])
				System.out.print(c[i] + ", ");
		}
		System.out.println ("");
	}

	private static void mostrar(ArrayList<boolean[]> soluciones, int []c) {
		for (boolean[] sol: soluciones) {
			mostrar(sol,c);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int n=0; 
		int m=0; 
		try {
			n= Integer.parseInt(cin.readLine());
			String[] numeros = cin.readLine().split(" ");
			int []c = new int[n];
			boolean []usados = new boolean[n];
			for (int i=0; i<n; i++) {
				c[i] = Integer.parseInt (numeros[i]);
				usados[i] = false;
			}
			Arrays.sort (c);
			
			m= Integer.parseInt(cin.readLine());
			
			
			//Se le pasa: 
			//c: Conjunto de numeros candidatos
			//usados: Los usados de los candidatos
			//etapa: indice
			//cont_seleccionados
			//solucion
			//m: Numero de elementos a formar parte de la solucion

			BT (c, usados, 0, 0, m);
			
			System.out.println (soluciones.size());
			mostrar (soluciones,c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		 

}
