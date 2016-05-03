package DivideYVenceras;

public class ElemDesordenado {
	
	class ErrorNoDesorden extends Exception {
       public ErrorNoDesorden() {}
       public ErrorNoDesorden(String msg) {
         super(msg);
       }
	}
    public static void main(String args[]){
    //   int arrayEntrada[]={1,2,3,4,5,0,7,8,9,10,11}; //Este es el array de elementos 
      int arrayEntrada[]={2,4,6,8,16,12,18,20,22,24}; //Este es el array de elementos 
       ElemDesordenado elemdesordenado = new ElemDesordenado ();
       
       try {
		   int elemento=elemdesordenado.buscarDesordenado (arrayEntrada, 0, arrayEntrada.length-1);
		   System.out.println ("Elemento desordenado: "+elemento);
       }catch (Exception e) {
		   System.out.println ("No hay elemento desordenado");
	   }
     }
     
     public int buscarDesordenado (int v[], int inicio, int fin) throws ErrorNoDesorden{
		if (inicio==fin) { //Vector de una posicion entonces no hay posibilidad de desorden. Nunca sera caso base viniendo de la recursividad pero preparamos por si nos llaman con un vector asi
			throw new ErrorNoDesorden("Error no hay elemento desordenador");
		}else if (inicio+1==fin) { //Vector de dos posiciones 
			if (v[fin]<v[inicio]) {
				return v[fin];
			} else {
				throw new ErrorNoDesorden("Error no hay elemento desordenador");
			}
		}else {
			int mitad = (inicio + fin) /2;
			if (v[mitad]> v[mitad+1]) {
				return v[mitad+1];
			}else if (v[mitad]<v[mitad-1]){
				return v[mitad];
			}else {
				try {
					return buscarDesordenado (v, inicio, mitad-1);
				}catch (Exception e) {
				}
				try {
					return buscarDesordenado (v, mitad+1, fin);
				}catch (Exception e) {
				}
				//Si llegamos aqui es porque en ambas partes no hay desordean asi es que excepcion
				throw new ErrorNoDesorden("Error no hay elemento desordenador");
			}
		}
		 
	 }
}
