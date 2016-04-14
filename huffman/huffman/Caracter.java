/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author jvergara
 */
public class Caracter {
    private char caracter; //Caracter representado
    private float porcentaje = 0; //Porcentaje de aparicion
    private String codigo = ""; //codificacion

    /**
     * @return the caracter
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * @param caracter the caracter to set
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * @return the porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
