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
 * Clase que genera códigos consecutivos con formato: CON-1, CON-2, ..., CON-N
 */
public class GeneradorCodigosConsecutivos extends GeneradorCodigos {

    /**
     * Variable estática que lleva el conteo de los códigos generados.
     */
    private static int consecutivo = 1;

    /**
     * Constructor que inicializa el prefijo como "CON".
     */
    public GeneradorCodigosConsecutivos() {
        super("CON");
    }

    /**
     * Incrementa el valor del consecutivo en 1.
     */
    public static void incrementarConsecutivo() {
        consecutivo++;
    }

    /**
     * Valida si un código cumple con el formato CON-N,
     * donde N es un número entero.
     * 
     * @param codigo Código a validar
     * @return true si el formato es válido, false en caso contrario
     */
    @Override
    public boolean tieneFormatoValido(String codigo) {
        if (codigo == null) {
            return false;
        }

        if (!codigo.startsWith("CON-")) {
            return false;
        }

        String numero = codigo.substring(4);

        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Genera un código consecutivo con el formato CON-N.
     * 
     * @return código generado
     */
    @Override
    public String generarCodigo() {
        String codigo = "CON-" + consecutivo;
        incrementarConsecutivo();
        return codigo;
    }

}
