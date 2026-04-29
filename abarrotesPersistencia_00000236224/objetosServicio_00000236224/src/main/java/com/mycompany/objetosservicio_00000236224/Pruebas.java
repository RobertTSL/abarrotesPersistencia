/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.objetosservicio_00000236224;

/**
 *
 * @author rober
 */
public class Pruebas {

    public static void main(String[] args) {
        GeneradorCodigosConsecutivos genCod =  new GeneradorCodigosConsecutivos();
        String codigoCon = genCod.generarCodigo();
        
        System.out.println(codigoCon);
        System.out.println(genCod.tieneFormatoValido(codigoCon));
        GeneradorCodigosAleatorios genCodAl =  new GeneradorCodigosAleatorios();
        String codigoAl;
        System.out.println(codigoAl = genCodAl.generarCodigo());
        ValidadorStrings validador = new ValidadorStrings();
        String test = "hola";
        boolean prueba = validador.estaVacio(test);
        System.out.println(prueba);
    }
}
