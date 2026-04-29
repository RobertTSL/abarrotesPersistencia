/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio_00000236224;

/**
 *
 * @author rober
 */
public class ValidadorStrings {

    /**
     * Verifica si un texto supera un tamaño máximo.
     * 
     * @param texto Texto a evaluar
     * @param max Tamaño máximo permitido
     * @return true si el texto es mayor al máximo, false en caso contrario
     */
    public static boolean superaTamanioMaximo(String texto, int max) {
        if (texto == null) {
            return false;
        }
        return texto.length() > max;
    }
    
    /**
     * Verifica si un texto no alcanza el tamaño mínimo requerido.
     * 
     * @param texto Texto a evaluar
     * @param min Tamaño mínimo requerido
     * @return true si el texto es menor al mínimo, false en caso contrario
     */
    public static boolean careceTamanioMinimo(String texto, int min) {
        if (texto == null) {
            return true;
        }
        return texto.length() < min;
    }

    /**
     * Verifica si un texto está vacío, es nulo o contiene solo espacios.
     * 
     * @param texto Texto a evaluar
     * @return true si está vacío o solo contiene espacios, false en caso contrario
     */
    public static boolean estaVacio(String texto) {
        if (texto == null) {
            return true;
        }

        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isWhitespace(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un texto contiene únicamente números.
     * 
     * @param texto Texto a evaluar
     * @return true si contiene solo dígitos, false en caso contrario
     */
    public static boolean contieneSoloNumeros(String texto) {
        if (texto == null || texto.length() == 0) {
            return false;
        }

        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un texto contiene únicamente letras y espacios.
     * 
     * @param texto Texto a evaluar
     * @return true si contiene solo letras, false en caso contrario
     */
    public static boolean contieneSoloLetras(String texto) {
        if (texto == null || texto.length() == 0) {
            return false;
        }

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (!(Character.isLetter(c) || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida si un texto cumple con el formato de contraseña.
     * Requisitos:
     * - Entre 8 y 12 caracteres
     * - Al menos una mayúscula
     * - Al menos una minúscula
     * - Al menos un número
     * - Al menos un carácter especial ($%-_#@)
     * 
     * @param texto Contraseña a evaluar
     * @return true si cumple con los requisitos, false en caso contrario
     */
    public static boolean esPasswordValido(String texto) {
        if (texto == null) {
            return false;
        }

        if (texto.length() < 8 || texto.length() > 12) {
            return false;
        }

        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        String especiales = "$%-_#@";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (Character.isUpperCase(c)) {
                tieneMayus = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinus = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (especiales.indexOf(c) != -1) {
                tieneEspecial = true;
            }
        }

        return tieneMayus && tieneMinus && tieneNumero && tieneEspecial;
    }

    /**
     * Verifica si un texto tiene formato de fecha válido (dd/mm/yyyy).
     * No considera años bisiestos.
     * 
     * @param texto Texto a evaluar
     * @return true si la fecha es válida, false en caso contrario
     */
    public static boolean esFechaValida(String texto) {
        if (texto == null || texto.length() != 10) {
            return false;
        }

        // formato dd/mm/yyyy
        if (texto.charAt(2) != '/' || texto.charAt(5) != '/') {
            return false;
        }

        String diaStr = texto.substring(0, 2);
        String mesStr = texto.substring(3, 5);
        String anioStr = texto.substring(6, 10);

        if (!contieneSoloNumeros(diaStr)
                || !contieneSoloNumeros(mesStr)
                || !contieneSoloNumeros(anioStr)) {
            return false;
        }

        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);

        if (mes < 1 || mes > 12) {
            return false;
        }
        return !(dia < 1 || dia > 31);
    }

    /**
     * Verifica si un texto es un palíndromo (ignora espacios y mayúsculas).
     * 
     * @param texto Texto a evaluar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null) {
            return false;
        }

        String limpio = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c != ' ') {
                limpio += Character.toLowerCase(c);
            }
        }

        int i = 0;
        int j = limpio.length() - 1;

        while (i < j) {
            if (limpio.charAt(i) != limpio.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
