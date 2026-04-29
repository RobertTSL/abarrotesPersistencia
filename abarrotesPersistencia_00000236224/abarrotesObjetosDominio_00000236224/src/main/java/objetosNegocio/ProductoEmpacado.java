/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author rober
 */
public class ProductoEmpacado extends Producto {

    private int cantidad;

    /**
     * Constructor por defecto.
     */
    public ProductoEmpacado() {
        super();
        this.cantidad = 0;
    }

    /**
     * Constructor que recibe el producto y la cantidad.
     *
     * @param producto Producto asociado
     * @param cantidad Cantidad disponible del producto
     */
    public ProductoEmpacado(Producto producto, int cantidad) {
        super(producto);
        this.cantidad = cantidad;

        if (producto != null && producto.getClave().startsWith("EM")) {
            this.cantidad = (cantidad >= 1) ? cantidad : 1;
        }
    }

    /**
     * Constructor que inicializa el producto y la cantidad.
     *
     * @param producto Producto asociado
     *
     */
    public ProductoEmpacado(Producto producto) {
        super(producto);
        this.cantidad = 0;
    }

    /**
     * Obtiene la cantidad del producto.
     *
     * @return Cantidad del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     *
     * @param cantidad Cantidad disponible del producto
     */
    public void setCantidad(int cantidad) {
        if (cantidad >= 1) {
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
