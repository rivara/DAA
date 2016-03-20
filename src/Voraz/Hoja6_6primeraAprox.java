package Voraz;

public class Hoja6_6primeraAprox {
	public static void cambiarMonedas(int cantidad){
		//caso base suma=0
		if(cantidad==0){
			System.out.println("cambio efectuado");
		}else{
		//caso recursivo
		if(cantidad>= 200){
			cantidad=cantidad-200;
			System.out.println("200,");
			
			
		}
		if(cantidad>= 100){
			cantidad=cantidad-100;
			System.out.println("100,");
			
			
		}
		if(cantidad>= 50){
			cantidad=cantidad-50;
			System.out.println("50,");
			
			
		}
		if(cantidad>= 20){
			cantidad=cantidad-20;
			System.out.println("20,");
			
			
		}
		if(cantidad>= 10){
			cantidad=cantidad-10;
			System.out.println("10,");
		
			
		}
		if(cantidad>= 5){
			cantidad=cantidad-5;
			System.out.println("5,");
			
			
		}
		if(cantidad>= 2){
			cantidad=cantidad-2;
			System.out.println("2,");
			
			
		}
		if(cantidad>= 1){
			cantidad=cantidad-1;
			System.out.println("1,");
			
			
		}
		cambiarMonedas(cantidad);
		}
		
	}

	public static void main(String[] args)  {
		cambiarMonedas(1323);
		
				}

}
