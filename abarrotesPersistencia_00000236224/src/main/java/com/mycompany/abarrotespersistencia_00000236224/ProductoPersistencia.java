/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abarrotespersistencia_00000236224;

import com.mycompany.objetosservicio_00000236224.ValidadorStrings;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import objetosNegocio.Producto;

/**
 *
 * @author rober
 */
public class ProductoPersistencia {

    // Agregar producto
    
    /*Coleccion donde el primer valor que es tipo String el cual sera la clave del producto
      y por siguiente sera el resto del producto
    */
    private final Map<String, Producto> productos;

    
    public ProductoPersistencia() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) throws PersistenciaException {
        
        //Revisa que no exista un producto con la misma clave
        if (productos.containsKey(producto.getClave())) {
            throw new PersistenciaException("Ya existe un producto con esa clave");
        }
        
        //Agrega el producto a la coleccion
        productos.put(producto.getClave(), producto);
    }

    public Producto consultarProducto(String clave) throws PersistenciaException {
        
        //Checa si la clave est vacia
        if (ValidadorStrings.estaVacio(clave)) {
            throw new PersistenciaException("La clave no puede estar vacía");
        }
        
        //Revisa que exista un producto con la clave especificada
        Producto producto = productos.get(clave);
        if (producto == null) {
            throw new PersistenciaException("No existe un producto con la clave: " + clave);
        }

        return producto;
    }

    public void actualizarProducto(Producto producto) throws PersistenciaException {
        //Revisa que el producto que sobrescribira al producto anterior tenga un formato valido
        validarProducto(producto);
        //Luego se revisa que el producto que se quiere actualizar exista
        if (!productos.containsKey(producto.getClave())) {
            throw new PersistenciaException("No existe el producto");
        }

        productos.put(producto.getClave(), producto);
    }

    public void eliminarProducto(String clave) throws PersistenciaException {
        //Se revisa que no este vacia la clave
        if (ValidadorStrings.estaVacio(clave)) {
            throw new PersistenciaException("La clave no puede estar vacía");
        }
        //Se revisa que exista el producto con la clave
        if (!productos.containsKey(clave)) {
            throw new PersistenciaException("No existe un producto con la clave: " + clave);
        }

        productos.remove(clave);
    }

    public List<Producto> consultarProductos(char tipo, String unidad) throws PersistenciaException {
        
        //Estos dos filtros sirven para dar True o False para las siguientes condiciones
        boolean filtrarTipo = (tipo == 'E' || tipo == 'G');
        boolean filtrarUnidad = !ValidadorStrings.estaVacio(unidad);

        /*en caso de que el tipo este vacio p no equivalga a E o G tirara excepcion */
        if (tipo != '\0' && !filtrarTipo) {
            throw new PersistenciaException("Tipo inválido. Debe ser E o G");
        }
        /*En caso de que el tipo de Unidad o no equivalga a KG,L o PZ dara excepcion*/
        if (filtrarUnidad && !unidad.equals("KG") && !unidad.equals("L") && !unidad.equals("PZ")) {
            throw new PersistenciaException("Unidad inválida. Debe ser KG, L o PZ");
        }
        
        //Se inicializa un arreglo para el listado de productos a consultar
        List<Producto> resultado = new ArrayList<>();

        //Aca ya se insertan todos los productos que cumplen con los filtros
        for (Producto p : productos.values()) {
            boolean coincideTipo = !filtrarTipo || p.getTipo() == tipo;
            boolean coincideUnidad = !filtrarUnidad || p.getUnidad().equals(unidad);

            if (coincideTipo && coincideUnidad) {
                resultado.add(p);

            }

        }
        return resultado;
    }

    private void validarProducto(Producto producto) throws PersistenciaException {

        if (producto == null) {
            throw new PersistenciaException("El producto no puede ser nulo");
        }

        // Clave: formato AA### (dos letras mayúsculas + tres dígitos)
        if (ValidadorStrings.estaVacio(producto.getClave())|| !producto.getClave().matches("[A-Z]{2}[0-9]{3}")) {
            throw new PersistenciaException("La clave debe tener el formato AA###. Ejemplo: AT001");
        }

        // Nombre y tipo no pueden estar vacíos
        if (ValidadorStrings.estaVacio(producto.getNombreProducto())) {
            throw new PersistenciaException("El producto debe tener nombre");
        }

        if (producto.getTipo() == '\0' || producto.getTipo() == ' ') {
            throw new PersistenciaException("El producto debe tener tipo");
        }

        // Tipo: solo E o G
        if (producto.getTipo() != 'E' && producto.getTipo() != 'G') {
            throw new PersistenciaException("El tipo debe ser E (empacado) o G (granel)");
        }

        // Unidad: solo KG, L o PZ
        String unidad = producto.getUnidad();
        
        if (ValidadorStrings.estaVacio(unidad)|| (!unidad.equals("KG") && !unidad.equals("L") && !unidad.equals("PZ"))) {
            throw new PersistenciaException("La unidad debe ser KG, L o PZ");

        }

    }

}
