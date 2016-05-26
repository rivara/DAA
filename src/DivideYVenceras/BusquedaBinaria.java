package DivideYVenceras;
/////////////////
//NO VISTO///////
/////////////////

class BusquedaBinaria
{
 public static void main(String[] args)
 {
	int arrayEntrada[]={ 1, 5, 6, 123, 213, 234, 321}; 
	int indice=-1;
	indice=busquedaBinaria (arrayEntrada,234,0,arrayEntrada.length-1);
 
	  if(indice==-1)
	  {
	   System.out.println("tu número no esta en la lista");
	  }
	  else
	  {
	   System.out.println("tu número esta en el indice: "+indice);
	  }
 }
 
 
 static int busquedaBinaria (int a[],int n,int Iabajo,int Iarriba)
 {
  int Icentro,indice=-1;
 
  if(Iarriba<Iabajo)
  {
   return -1;
  }
 
  else
  {
   Icentro=(Iabajo+Iarriba)/2;
   System.out.println (Icentro);
   if (n<a[Icentro])
   {
    return(busquedaBinaria(a,n,Iabajo,Icentro-1));
   }
 
   else
   {
     if (n>a[Icentro])
     {
      return(busquedaBinaria(a,n,Icentro+1,Iarriba));
     }    
     else
     {
      return Icentro;
     }
 
   }
  }
 }
 
}
