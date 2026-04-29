/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author rober
 */
public class MovimientoGranel extends Movimiento {

    /** Producto a granel asociado al movimiento. */    
    private ProductoGranel producto;

    /**
     * Constructor por defecto.
     */
    public MovimientoGranel() {
        super();
    }

    /**
     * Constructor que recibe un producto a granel.
     * 
     * @param producto Producto a granel asociado
     */
    public MovimientoGranel(ProductoGranel producto) {
        this.producto = producto;
    }

    /**
     * Constructor que inicializa la clave y el producto.
     * 
     * @param cveMovimiento Clave del movimiento
     * @param producto Producto a granel asociado
     */
    public MovimientoGranel(String cveMovimiento, ProductoGranel producto) {
        super(cveMovimiento);

        this.producto = producto;
    }

    /**
     * Obtiene el producto a granel.
     * 
     * @return Producto a granel
     */
    public ProductoGranel getProductoGranel() {
        return this.producto;
    }

    /**
     * Establece el producto a granel.
     * 
     * @param producto Nuevo producto a granel
     */
    public void setProductoGranel(ProductoGranel producto) {
        this.producto = producto;
    }

    /**
     * Devuelve una representación en texto del movimiento a granel.
     * 
     * @return Cadena con los valores separados por comas
     */
    @Override
    public String toString() {
        return getCveMovimiento() + "," + getFecha() + "," + getProcesado() + "," + producto;
    }

}
