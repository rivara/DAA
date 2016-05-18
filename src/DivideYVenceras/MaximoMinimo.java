
package DivideYVenceras;
class MaximoMinimo
{
 public static void main(String[] args)
 {
	int arrayEntrada[]={ 1, 4, 5, -6, 123, 234, 213}; 
	
	int resultados[] = new int [2];
	mym (arrayEntrada, resultados);
	
	System.out.println("Maximo: "+resultados[0]);
	System.out.println("Minimo: "+resultados[1]);
	  
 }
 
 
	static void mym (int a[], int []result) {
		if (a.length>1) {
			int [] result_1 = new int [2];
			int [] result_2 = new int [2];
			
			int n = a.length /2;
			int n2 = a.length - n;
			int aux1 [] = new int [n];
			int aux2 [] = new int [n2];
		
			for (int i=0; i<n; i++){
				aux1[i] = a[i];
			}
			for (int i=0; i<n2; i++){
				aux2[i] = a[n+i];
			}
		
		    System.out.println(a[n]+" "+a[n2]);
		
			mym (aux1, result_1);
			mym (aux2, result_2);
			
			//identifica al menor
			if (result_1[0]>result_2[0]){
				result[0] = result_1[0];
			}else
				result[0] = result_2[0];
			//identica al mayor
			if (result_1[1]<result_2[1]){
				result[1] = result_1[1];
			}else
				result[1] = result_2[1];
			
		}else {
		
			result[0] = a[0];
			result[1] = a[0];
		}
	
	}
 
}
