/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author rober
 */
public class ProductoGranel extends Producto {

    private float cantidad;
    
    /**
     * Constructor por defecto.
     */
    public ProductoGranel() {
        super();
        this.cantidad = 0.0f;
    }

    /**
     * Constructor que recibe el producto y la cantidad.
     * 
     * @param producto Producto asociado
     * @param cantidad Cantidad disponible del producto
     */
    public ProductoGranel(Producto producto, float cantidad) {
        super(producto);

        if (producto != null && producto.getClave().startsWith("GR")) {
            this.cantidad = ((cantidad >= 0.01f) ? cantidad : 0.01f);
        }
    }

    /**
     * Constructor que inicializa el producto y la cantidad.
     * 
     * @param producto Producto asociado
     * 
     */
    public ProductoGranel(Producto producto) {
        super(producto);
        this.cantidad = 0.0f;
    }

    /**
     * Obtiene la cantidad del producto.
     * 
     * @return Cantidad del producto
     */
    public double getCantidad() {
        return cantidad;
    }
    /**
     * Establece la cantidad del producto.
     * 
     * @param cantidad Cantidad disponible del producto
     */
    public void setCantidad(float cantidad) {
        if (cantidad >= 0.01f) {
            this.cantidad = cantidad;
        }
    }

    /**
     * Devuelve una representación en texto del producto a granel.
     * 
     * @return Cadena con los valores separados por comas
     */
    @Override
    public String toString() {
        return super.toString() + "," + cantidad;
    }
}
