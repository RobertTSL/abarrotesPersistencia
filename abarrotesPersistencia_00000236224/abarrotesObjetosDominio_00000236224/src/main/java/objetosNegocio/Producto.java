/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import static java.lang.Integer.parseInt;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author rober
 */
public class Producto {

    /**
     * Clave del producto (formato AA###).
     */
    protected String numClave;

    /**
     * Nombre del producto.
     */
    protected String nombreProducto;

    /**
     * Tipo de producto: 'E' (empacado) o 'G' (granel).
     */
    protected char tipo;

    /**
     * Unidad de medida (KG, g, L, PZ).
     */
    protected String unidad;

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa todos los atributos del producto.
     *
     * @param numClave Clave del producto (formato AA###)
     * @param nombreProducto Nombre del producto
     * @param tipo Tipo de producto ('E' empacado, 'G' granel)
     * @param unidad Unidad de medida (KG, g, L, PZ)
     */
    public Producto(String numClave, String nombreProducto, char tipo, String unidad) {
        this.numClave = numClave;
        this.nombreProducto = nombreProducto;
        this.tipo = tipo;
        this.unidad = unidad;
    }

    /**
     * Constructor que inicializa solo la clave del producto. Los demás
     * atributos se inicializan en null o vacío.
     *
     * @param numClave Clave del producto
     */
    public Producto(String numClave) {
        this.numClave = numClave;
        this.nombreProducto = null;
        this.tipo = ' ';
        this.unidad = null;
    }

    /**
     * Constructor de copia.
     *
     * @param producto Objeto producto a copiar
     */
    public Producto(Producto producto) {
        if (producto != null) {
            this.numClave = producto.numClave;
            this.nombreProducto = producto.nombreProducto;
            this.tipo = producto.tipo;
            this.unidad = producto.unidad;
        }
    }

    /**
     * Obtiene la clave del producto.
     *
     * @return Clave del producto
     */
    public String getClave() {
        return this.numClave;
    }

    /**
     * Establece la clave del producto.
     *
     * @param numClave Nueva clave del producto (formato AA###)
     */
    public void setClave(String numClave) {
        if (numClave != null && numClave.matches("[A-Z]{2}[0-9]{3}")) {
            this.numClave = numClave;
        }
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getNombreProducto() {
        return this.nombreProducto;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombreProducto Nuevo nombre del producto
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Obtiene el tipo del producto.
     *
     * @return Tipo del producto ('E' o 'G')
     */
    public char getTipo() {
        return this.tipo;
    }

    /**
     * Establece el tipo del producto.
     *
     * @param tipo Tipo del producto ('E' o 'G')
     */
    public void setTipo(char tipo) {
        if (tipo == 'E' || tipo == 'G') {
            this.tipo = tipo;
        } else {
            System.out.println("El tipo es incorrecto");
        }
    }

    /**
     * Obtiene la unidad del producto.
     *
     * @return Unidad de medida
     */
    public String getUnidad() {
        return this.unidad;
    }

    /**
     * Establece la unidad del producto.
     *
     * @param unidad Unidad de medida (KG, g, L, PZ)
     */
    public void setUnidad(String unidad) {
        if (unidad != null
                && (unidad.equals("KG") || unidad.equals("g") || unidad.equals("L") || unidad.equals("PZ"))) {
            this.unidad = unidad;
        }
    }

    /**
     * Compara dos productos por su clave.
     *
     * @param otroObjeto Objeto a comparar
     * @return true si ambos productos tienen la misma clave
     */
    @Override
    public boolean equals(Object otroObjeto) {

        if (otroObjeto == null) {
            return false;
        }

        if (this.getClass() != otroObjeto.getClass()) {
            return false;
        }

        Producto otroProducto = (Producto) otroObjeto;
        return this.numClave.equals(otroProducto.numClave);
    }

    /**
     * Genera un código hash para el producto.
     *
     * @return Código hash
     */
    @Override
    public int hashCode() {
        Random rand = new Random();
        int min = 1;
        int max = 10;

        int randomNum = rand.nextInt((max - min) + 1) + min;
        int hash;
        hash = randomNum;
        return hash;
    }

    /**
     * Devuelve una representación en texto del producto.
     *
     * @return Cadena con los atributos separados por comas
     */
    @Override
    public String toString() {
        return numClave + "," + nombreProducto + "," + tipo + "," + unidad;
    }

    public boolean containsKey(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
