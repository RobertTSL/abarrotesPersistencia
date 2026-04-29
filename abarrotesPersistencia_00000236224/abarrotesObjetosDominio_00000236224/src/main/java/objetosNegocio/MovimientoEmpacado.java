/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author rober
 */
public class MovimientoEmpacado extends Movimiento {

    /** Producto empacado asociado al movimiento. */
    private ProductoEmpacado producto;
    
    /**
     * Constructor por defecto.
     */
    public MovimientoEmpacado() {
        super();
    }

    /**
     * Constructor que recibe un producto empacado.
     * 
     * @param producto Producto empacado asociado
     */
    public MovimientoEmpacado(ProductoEmpacado producto) {
        this.producto = producto;
    }

    /**
     * Constructor que inicializa la clave y el producto.
     * 
     * @param cveMovimiento Clave del movimiento
     * @param producto Producto empacado asociado
     */
    public MovimientoEmpacado(String cveMovimiento, ProductoEmpacado producto) {
        super(cveMovimiento);

        this.producto = producto;
    }

    /**
     * Obtiene el producto empacado.
     * 
     * @return Producto empacado
     */
    public ProductoEmpacado getProductoEmpacado() {
        return this.producto;
    }
    
    /**
     * Establece el producto empacado.
     * 
     * @param producto Nuevo producto empacado
     */
    public void setProductoEmpacado(ProductoEmpacado producto) {
        this.producto = producto;
    }

    /**
     * Devuelve una representación en texto del movimiento empacado.
     * 
     * @return Cadena con los valores separados por comas
     */
    @Override
    public String toString() {
        return getCveMovimiento() + "," + getFecha() + "," + getProcesado() + "," + producto;
    }

}
