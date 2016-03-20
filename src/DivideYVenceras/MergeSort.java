package DivideYVenceras;

public class MergeSort {
	



    public static void main(String args[]){
       int arrayEntrada[]={321, 123, 213, 234, 1, 4, 5, 6}; //Este es el array de elementos que vamos a ordenar

       mergeSort(arrayEntrada); //llamada al metodo mergeSort 
       for (int i=0;i < arrayEntrada.length;i++){ //Este bucle imprime el contenido del array
          System.out.print(arrayEntrada[i]+" ");
       }//fin del for
     }//fin del main
     
    public static void mergeSort( int a[ ]){
      
        mergeSort( a, 0, a.length - 1 );
    }
    private static void mergeSort( int a[ ], int left, int right ){
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, left, center );
            mergeSort( a, center + 1, right );

            //Ordena las dos partes anteriores para fusionar los dos vectores
            merge( a, left, center + 1, right );
        }
    }

    private static void merge( int a[ ],int leftPos, int rightPos, int rightEnd){
  	int tmpArray[] = new int[ a.length ];

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd ){
            if( a[ leftPos ]<( a[ rightPos ] ) ){
                tmpArray[ tmpPos ] = a[ leftPos ];
                tmpPos++;
                leftPos++;
            }
            else{
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
            }
        }
        while( leftPos <= leftEnd ){    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }
        while( rightPos <= rightEnd ){  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        }
        // Copy TmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- ){
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }
}//class MergeSort


