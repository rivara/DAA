package VueltaAtras;


public class jugadores_bt_2 {
    
	//llamada al BT
	public static void jugadoresBT(int[] jugadores) {
		//creo estructuras auxiliares
		boolean solucion[] =new boolean[jugadores.length];
		boolean solucionMejor[] =new boolean[jugadores.length]; 
		BT(jugadores,0,solucion,solucionMejor);
		for(int i=0;i<solucionMejor.length;i++){
			if (solucionMejor[i]) {
				System.out.println ("Jugador "+i+" va al equipo 1");
			}else {
				System.out.println ("Jugador "+i+" va al equipo 2");
			}
			
		}

	}
	
	//algorimo de BT
	public static void BT(int v[],int etapa,boolean solucion[],boolean solucionMejor[]){
		//for
		for(int intento=1;intento<=2;intento++){
			if(es_factible(v,etapa,intento,solucion,solucionMejor)){
				
				//marcar
				if(intento==1){
					solucion[etapa]=true;
				}else{
					solucion[etapa]=false;
				}

				if(es_solucion(v,etapa,solucion)){
					if(es_mejor(v,solucion,solucionMejor)) {
						copiar(solucion,solucionMejor);
					}
				}else if (etapa<v.length-1){
					BT(v,etapa+1,solucion,solucionMejor);
				}
			}
			
			solucion[etapa]=false;
		}
		
	}

		public static boolean es_factible(int v[], int etapa, int intento,boolean solucion[], boolean solucionMejor[]) {
			int cont1=0;
			int cont2=0;
			for(int i=0;i<etapa;i++){
				if(solucion[i]) {
					cont1 ++;
				}
				else {
					cont2++;
				}
			}
			//si siguient se pasa
			if(intento==0)
				cont1++;
			else
				cont2++;
				
			return ((cont1<=v.length/2)&&(cont2<=v.length/2));
		}

		
		public static boolean es_solucion(int[] v,int etapa,boolean[] solucion){
			int cont=0;
			for(int i=0	;i<=etapa;i++){
				if(solucion[i])
					cont++;
			}
			return(etapa==v.length-1)&&(cont==v.length/2);
		}
		
		
		
		
		
		public static boolean es_mejor (int v[],boolean solucion[],boolean solucionMejor[]){
			int cont1=0,cont2=0;
			for(int i=0;i<v.length;i++){
				if(solucion[i])
					cont1=cont1 + v[i];
				else
					cont2=cont2 + v[i];
			}
			
			int diferencia=Math.abs(cont1-cont2);
			cont1=0;
			cont2=0;
			//DA PROBLEMAS
			for(int i=0;i<v.length;i++){
				if(solucionMejor[i]){
					//traza
					cont1=cont1+v[i];
				}
				else
					cont2=cont2+v[i];
			}
			int diferencia2=Math.abs(cont1-cont2);				
			return diferencia<diferencia2;
		}
			
		
	



	public static void copiar(boolean []solucion,boolean []solucionMejor){
		for(int i=0;i<solucion.length;i++){
			solucionMejor[i]=solucion[i];
		}
	}

	public static void main(String[] args) {
		//meto un arry de jugadores (pares)
		//las estadistica de juegos
		int jugadores[]= {1,4,3,2};
		//llamada a jugadores
		
		jugadoresBT(jugadores);
		
	}

}
