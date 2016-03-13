package dyv;

public class Hoja5E1_final {



	static public int[] eliminaRepetidos(int []v, int inf, int sup){
		int medio;
		int [] vIzq, vDer;
		if (inf==sup){ //caso base
 			int [] resulBase = new int[1]; 
			resulBase[0]=v[inf];
			return resulBase;
 		} else{
			medio=(inf+sup)/2; 
			vIzq=eliminaRepetidos(v,inf,medio); 
			vDer=eliminaRepetidos(v,medio+1,sup); 
			return fusiona(vIzq, vDer);
		} 
	}


	static private int[] fusiona( int []v1, int[] v2){
		int i, j, k;
		int [] resul= new int[v1.length+v2.length]; 
		int [] resulFinal;
		i=0;
		j=0;
		k=0;
		while ((i<v1.length) && (j<v2.length)){
			if (v1[i] < v2[j]){ 
				resul[k]=v1[i];
				k=k+1;
				i++; 
			}else{
				if (v1[i] > v2[j]){ 
					resul[k]=v2[j];
					k++;
					j++; 
				}else{
					resul[k]=v1[i]; i++;
					j++;
					k++;
				}
		    }
		} 
		while (j<v2.length){ 
			resul[k]=v2[j];
			j++; 
			k++;
		}
		while (i<v1.length){ 
			resul[k]=v1[i];
			i++; 
			k++;
		}

		resulFinal= new int[k];
		for (i=0; i<k; i++){
			resulFinal[i]=resul[i];
		}
		return resulFinal;
	}

	static void imprime(int []v, String mensaje){
		System.out.print(mensaje+" "); 
		for (int i=0; i<v.length; i++){
			System.out.print(v[i] +", ");
		}
	}

	public static void main(String[] args) {
		int []vector={3,1,1,3,1,1};

		int [] resultado;
		resultado=eliminaRepetidos(vector, 0, vector.length-1); 
		imprime(vector, "Vector entrada:");
		imprime (resultado, "Vector salida:");
	}


















}
