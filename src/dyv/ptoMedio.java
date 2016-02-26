package dyv;

public class ptoMedio {

	/*private static int ptoMedio(int numeros[], int ini, int fin) {
		// caso base
		if (ini == fin) {
			return ini;
		} else {

			int medio = (ini + fin) / 2;
			ptoMedio(numeros, ini, medio);
			ptoMedio(numeros, medio + 1, fin);

			//if ((medio - 1 > 0) && (medio + 1 < numeros.length)) {

				if ((numeros[medio] < numeros[medio - 1])
						&& (numeros[medio] < numeros[medio + 1])) {
							 System.out.println("punto medio real"+medio);
							 return medio;
			}
				
			return medio;
		}
		
	}*/
	  
    public static int buscarPosK (int v[], int inicio, int fin) {
        if (inicio > fin) {
           return -1;
       }else {
           int mitad = (inicio + fin) /2;
           boolean buscar_atras = false;
           boolean buscar_delante = false;
           if (mitad > inicio) {
               buscar_atras = v[mitad-1]<v[mitad]; //Estara detras si el de la posicion anterior a la mitad es inferior (ya que hemos caido en la zona creciente zona 2)
           }
           if (mitad < fin) {
               buscar_delante = v[mitad+1]<v[mitad]; //Estara delante si el de la posicion siguiente es inferior a la mitad (ya que hemos caido en la zona decreciente zona 1)
           }
           System.out.println ("pos mitad: "+mitad+" elemento mitad: "+v[mitad]);
           if ((buscar_atras==true) && (buscar_delante==false)) {
               System.out.println ("Buscando atras");
               return buscarPosK (v, inicio, mitad-1);
           }else if ((buscar_atras==false) && (buscar_delante==true)) {
               System.out.println ("Buscando delante");
               return buscarPosK (v, mitad+1, fin);
           }else {
               return mitad;
           }
          
       }
        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// llamada principal
		int arrayEntrada[] = {1,2,3,0,5};
		int pos = buscarPosK(arrayEntrada, 1, arrayEntrada.length-1);
		System.out.println("el punto medio esta en la posicion que sale: " + pos);

	}

}
