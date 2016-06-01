package DivideYVenceras;

public class CurvaConcava {
	

    public static void main(String args[]){
       int arrayEntrada[]={4, 3, 2, 1, 2, 3, 4, 5, 6, 7}; //Este es el array de elementos 
       
       int k=buscarPosK (arrayEntrada, 0, arrayEntrada.length-1);
       System.out.println ("Posicion k: "+k);
       
     }
     
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
}
