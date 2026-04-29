    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio_00000236224;

import java.util.Random;

/**
 *
 * @author rober
 */


/**
 * Clase que genera códigos aleatorios con formato: ALE-XXXX
 * donde XXXX es un número de 4 dígitos.
 */
public class GeneradorCodigosAleatorios extends GeneradorCodigos {

    /**
     * Constructor que inicializa el prefijo como "ALE".
     */
    public GeneradorCodigosAleatorios() {
        super("ALE");
    }

    /**
     * Genera un número aleatorio entre 0001 y 9999 en formato String de 4 dígitos.
     * 
     * @return número aleatorio formateado
     */
    public static String obtenerAleatorio() {
        Random r = new Random();
        int numero = r.nextInt(9999) + 1;

        return String.format("%04d", numero);
    }

    /**
     * Valida si un código cumple con el formato ALE-XXXX,
     * donde XXXX son 4 dígitos numéricos.
     * 
     * @param codigo Código a validar
     * @return true si el formato es válido, false en caso contrario
     */
    @Override
    public boolean tieneFormatoValido(String codigo) {
        if (codigo == null) {
            return false;
        }

        if (!codigo.startsWith("ALE-")) {
            return false;
        }

        String numero = codigo.substring(4);

        if (numero.length() != 4) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Genera un código aleatorio con formato ALE-XXXX.
     * 
     * @return código generado
     */
    @Override
    public String generarCodigo() {
        return "ALE-" + obtenerAleatorio();
    }
}
