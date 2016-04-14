/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.xml.soap.Node;

/**
 *
 * @author jvergara
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static Caracter[] huffman( Caracter[] caracteres ) {
       
        
        //PASO 3: Crear un arraylist de arboles
        ArrayList <Nodo> arboles = new ArrayList <Nodo> ();
        for (int i = 0; i < caracteres.length; i++) {
            Nodo nuevo = new Nodo (caracteres[i],null, null);
            arboles.add(nuevo);
        }
        
        //PASO 4: Reducir el arraylist a un solo arbol
        while (arboles.size()>1) {
            Nodo nodo1 = arboles.get(0);
            arboles.remove(0);
            Nodo nodo2 = arboles.get(0);
            arboles.remove(0);
            Caracter caracter = new Caracter ();
            caracter.setPorcentaje(nodo1.caracter.getPorcentaje()+nodo2.caracter.getPorcentaje());
            caracter.setCaracter(' ');
            Nodo nuevo = new Nodo (caracter, nodo1, nodo2);
            arboles.add(nuevo);
            Collections.sort(arboles);
        }
        
        //PASO 5: Ahora recorremos el arbol que nos queda y rellenamos el array con sus codigos. 
        //Antes de nada volvemos a ordenar el array alfabeticamente
         caracteres = ordenarArrayAlfabeto (caracteres);
         SacarCodigos (arboles.get(0), caracteres, "");
         
         return caracteres;
         
    }
  
    public static void AsignarCodigo (char letra,Caracter[] caracteres, String codigo) {
        for (int i = 0; i < caracteres.length; i++) {
           if (caracteres[i].getCaracter()==letra) {
               caracteres[i].setCodigo(codigo);
           }
        }
    }
    public static void SacarCodigos (Nodo arbol,Caracter[] caracteres, String codigo) {
        if (arbol.isLeaf()) {
            AsignarCodigo (arbol.caracter.getCaracter(),caracteres, codigo);
        }else {
            SacarCodigos (arbol.left, caracteres, codigo+"0");
            SacarCodigos (arbol.right, caracteres, codigo+"1");
        }
    }
    public static Caracter[] ordenarArray(Caracter[] n) {
        Caracter aux;
        for (int i = 0; i < n.length - 1; i++) {
            for (int x = i + 1; x < n.length; x++) {
                if (n[x].getPorcentaje() < n[i].getPorcentaje()) {
                    aux = n[i];
                    n[i] = n[x];
                    n[x] = aux;
                }
            }
        }

        return n;
    }
    
    public static Caracter[] ordenarArrayAlfabeto (Caracter[] n) {
        Caracter aux;
        for (int i = 0; i < n.length - 1; i++) {
            for (int x = i + 1; x < n.length; x++) {
                if (n[x].getCaracter() < n[i].getCaracter()) {
                    aux = n[i];
                    n[i] = n[x];
                    n[x] = aux;
                }
            }
        }

        return n;
    }
    public static void apuntar_letra (char letra, Caracter [] caracteres){
        for (int i = 0; i< caracteres.length; i++) {
            if (caracteres[i].getCaracter() == letra) {
                caracteres[i].setPorcentaje(caracteres[i].getPorcentaje() + 1);
            }
        }
    }
    public static void main(String[] args) {
        //PASO 1: Construir el array de frecuencias segun texto
        Caracter [] caracteres = new Caracter [28];
        
        Scanner leer = new Scanner(System.in);
        
        //Leemos el numero de edificios
        System.out.println ("Introduce un texto en mayusculas: ");
        String linea = leer.nextLine();
        linea = linea.toUpperCase();
        
        int cont = 0;
        for (char letra='A'; letra <= 'Z'; letra++) {
            Caracter c = new Caracter ();
            c.setCaracter(letra);
            c.setPorcentaje(0);
            caracteres[cont] = c;
            cont++;
        }
        
        Caracter c = new Caracter ();
        c.setCaracter('.');
        c.setPorcentaje(0);
        caracteres[cont] = c;
        cont++;
        
        c = new Caracter ();
        c.setCaracter(',');
        c.setPorcentaje(0);
        caracteres[cont] = c;
        cont++;
        
        //Analizamos el texto introducido para sacar los porcentajes sin contar los espacios en blanco
        //Primero vamos a contar caracteres y los apuntamos
        int contador_caracteres = 0;
        for (int i = 0; i < linea.length(); i++) {
            if (linea.charAt(i)!=' '){
                apuntar_letra (linea.charAt(i), caracteres);
                contador_caracteres ++;
                
            }
        }
        //Segundo dividimos entre el total
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i].setPorcentaje(caracteres[i].getPorcentaje() / contador_caracteres);
        }
        for (int i = 0; i < caracteres.length; i++) {
            System.out.println ("Caracter: "+caracteres[i].getCaracter()+ " Porcentaje: "+caracteres[i].getPorcentaje());
        }
        //PASO 2: Ordenar Array por de frecuencia menor a mayor
        caracteres = ordenarArray (caracteres);
        
        caracteres = huffman (caracteres);
        
       //PASO 6: Se imprime el array
        for (int i = 0; i < caracteres.length; i++) {
             System.out.println ("Caracter: "+caracteres[i].getCaracter()+ " Codigo: "+caracteres[i].getCodigo());
        }
    }
}
