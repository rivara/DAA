package dyv;

import java.util.ArrayList;

/*Ejercicio 1
Dado un vector de naturales con elementos duplicados, se quiere una función que devuelva
el vector con los elementos duplicados eliminados. Por ejemplo, para una entrada {3, 1, 5,
3, 1, 1} debe generar una salida {1, 3, 5}. Escribe la función y las funciones auxiliares en
Java que implemente una estrategia Divide y vencerás y que no supere el coste O( n log n ).*/
public class Hoja5E1 {

		public static int repetidos(int v[], int inicio, int fin,int aux[],int cont) {
			if (inicio == fin) {
				return  v[inicio];	
			}else {
				//recorro todo el array con mitad si aparece en otro sitio
				int mitad = (inicio + fin) / 2;
			    
				
			
				int pos_1 = repetidos(v, inicio, mitad,aux,cont);
				int pos_2 = repetidos(v, mitad+1, fin,aux,cont);
			// si pos_1 es 0 nos encontramos en la primera posicion	
			if (pos_1==0){		
					//miro por un lado
				 System.out.println(pos_1+"o"+mitad);
					 if((v[mitad]==pos_1)&&(mitad!=0)){		
						 System.out.println(pos_1+"se repite en la posicion "+mitad);
						 aux[cont]=pos_1;
						 cont++;
					 }
					 return pos_1;
				}else{ 
				//miro por el otro lado 	 
					 if((v[mitad]==pos_2)&&(mitad!=v.length)){
						 System.out.println(pos_2+"se repite en la posicion "+mitad);
						 aux[cont]=pos_2;
						 cont++;
					 }
					 return pos_2;
				}
			
			}
		}
		
		
				
		
	    
		

	public static void main(String[] args) {
		int arrayEntrada[] = {2,2,2,2,7,7,11}; // Este es el array
		int array2[]=new int[arrayEntrada.length];
		repetidos(arrayEntrada, 0,arrayEntrada.length - 1,array2,0);
	
	//compruebo todas las posiciones del array crado	
	 for(int aux=0 ;aux<array2.length;aux++){
		 System.out.print(array2[aux]);
	 }
	}

	

}
