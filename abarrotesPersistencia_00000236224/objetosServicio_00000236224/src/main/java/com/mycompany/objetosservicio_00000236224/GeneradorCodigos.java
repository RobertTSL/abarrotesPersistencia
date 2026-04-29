/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio_00000236224;

/**
 *
 * @author rober
 */
/**
 * Clase abstracta base para la generación de códigos. Define la estructura
 * general que deben seguir los distintos tipos de generadores.
 */
public abstract class GeneradorCodigos {

    /**
     * Prefijo que identifica el tipo de código.
     */
    protected String prefijo;

    /**
     * Constructor de la clase.
     *
     * @param prefijo Cadena inicial que tendrán los códigos generados
     */
    public GeneradorCodigos(String prefijo) {
        this.prefijo = prefijo;
    }

    /**
     * Obtiene el prefijo del generador.
     *
     * @return prefijo del código
     */
    public String getPrefijo() {
        return prefijo;
    }

    /**
     * Método abstracto validador. Verifica si un código cumple con el formato
     * correspondiente.
     *
     * @param codigo Código a validar
     * @return true si el formato es válido, false en caso contrario
     */
    public abstract boolean tieneFormatoValido(String codigo);

    /**
     * Genera un código con el formato definido por la clase hija.
     *
     * @return código generado
     */
    public abstract String generarCodigo();
}
