package dyv;

import java.util.ArrayList;

/*Ejercicio 1
Dado un vector de naturales con elementos duplicados, se quiere una función que devuelva
el vector con los elementos duplicados eliminados. Por ejemplo, para una entrada {3, 1, 5,
3, 1, 1} debe generar una salida {1, 3, 5}. Escribe la función y las funciones auxiliares en
Java que implemente una estrategia Divide y vencerás y que no supere el coste O( n log n ).*/
public class Hoja5E1 {

		public static int repetidos(int v[], int inicio, int fin,ArrayList<String> aux) {
			if (inicio == fin) {
				return  v[inicio];
			
			} else {
				int mitad = (inicio + fin) / 2;
				int pos_1 = repetidos(v, inicio, mitad,aux);
				int pos_2 = repetidos(v, mitad + 1, fin,aux);
				if!(aux.contains(o))
					aux.add(pos_1);
				
			}          
		}

		

	public static void main(String[] args) {
		int arrayEntrada[] = { 4, 2, 8, 10, 20, 23, 24,25,21 }; // Este es el array
		ArrayList<String> AList = new ArrayList<String>();
		System.out.println(repetidos(arrayEntrada, 0,arrayEntrada.length - 1,AList));
		
	}

	

}
