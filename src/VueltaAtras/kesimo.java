package VueltaAtras;

public class kesimo {
	
	public static int ReestructurarAlAzar (int vectorEnteros1[]) {
		//se encarga de reestructurar un vector recibido como entrada en base a uno
		//cualquiera de sus elementos, y devuelve la posición de dicho pivote al término de la
		//reestructuración.
		
		
		for(int i=0; i<vectorEnteros1.length-1; i++) {  
            for(int j=0; j<vectorEnteros1.length-i-1; j++) { 
                if (vectorEnteros1[j]>vectorEnteros1[j+1])  { 
                    int aux   = vectorEnteros1[j]; 
                    vectorEnteros1[j]  = vectorEnteros1[j+1]; 
                    vectorEnteros1[j+1]= aux; 
                }    
            } 
        }
	
		int pos_mitad = vectorEnteros1.length/2;
		
		return pos_mitad;
		
		
	}
	public static int kesimo_maspequeno (int v[], int k) {
		int pivote = ReestructurarAlAzar (v);
		if (pivote==k) {
			return v[pivote];
		}else if (k<pivote) {
			int v_aux[] = new int [pivote-1];
			for (int i=0; i<pivote-1; i++) {
				v_aux[i] = v[i];
			}
			return kesimo_maspequeno (v_aux,k);
		}else {
			int v_aux[] = new int [v.length-(pivote)];
			int cont=0;
			for (int i=pivote+1; i<v.length; i++) {
				v_aux[cont] = v[i];
				cont++;
			}
			return kesimo_maspequeno (v_aux,k-pivote);
		}
	}
	
	
	public static void main (String args[]) {
		int vector[] =  {51,23,6,72,100};
		
		int numero = kesimo_maspequeno (vector, 2);
		
		System.out.println ("Kesimo mas pequeño es: "+numero);
		
	}
	
	
}
