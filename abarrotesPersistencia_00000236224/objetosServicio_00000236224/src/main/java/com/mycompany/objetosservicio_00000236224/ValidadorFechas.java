/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio_00000236224;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author rober
 */
public class ValidadorFechas {
    
    /**
     * Determina si una fecha es futura respecto a la fecha actual del sistema.
     * 
     * @param fecha Fecha a evaluar
     * @return true si la fecha es posterior a la actual, false en caso contrario
     */
    public static boolean esFechaFutura(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }
    
    /**
     * Determina si una fecha es pasada respecto a la fecha actual del sistema.
     * 
     * @param fecha Fecha a evaluar
     * @return true si la fecha es anterior a la actual, false en caso contrario
     */
    public static boolean esFechaPasada(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }
    /**
     * Determina si una persona es mayor de edad (18 años o más)
     * en base a su fecha de nacimiento.
     * 
     * @param fechaNacimiento Fecha de nacimiento
     * @return true si tiene 18 años o más, false en caso contrario
     */

    public static boolean esMayorEdad(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - fechaNacimiento.getYear();

        if (hoy.getMonthValue() < fechaNacimiento.getMonthValue()
                || (hoy.getMonthValue() == fechaNacimiento.getMonthValue()
                && hoy.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
            edad--;
        }

        return edad >= 18;
    }
    /**
     * Determina si una fecha se encuentra dentro de un rango dado.
     * 
     * @param fecha Fecha a evaluar
     * @param desde Fecha inicial del rango
     * @param hasta Fecha final del rango
     * @return true si está dentro del rango (incluyendo límites), false en caso contrario
     */
    public static boolean estaDentroRango(LocalDate fecha, LocalDate desde, LocalDate hasta) {
        return (fecha.isEqual(desde) || fecha.isAfter(desde))
                && (fecha.isEqual(hasta) || fecha.isBefore(hasta));
    }
    /**
     * Determina si una fecha corresponde a fin de semana.
     * 
     * @param fecha Fecha a evaluar
     * @return true si es sábado o domingo, false en caso contrario
     */
    public static boolean esFinSemana(LocalDate fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }
    /**
     * Determina si una fecha y hora se encuentra dentro del horario laboral.
     * 
     * Horarios:
     * Lunes a Viernes: 08:00 - 18:00
     * Sábado: 08:00 - 13:00
     * Domingo: no laboral
     * 
     * @param fecha Fecha y hora a evaluar
     * @return true si está dentro del horario laboral, false en caso contrario
     */
    public static boolean esHorarioLaboral(LocalDateTime fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        int hora = fecha.getHour();

        switch (dia) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                return hora >= 8 && hora < 18;
            }
            case SATURDAY -> {
                return hora >= 8 && hora < 13;
            }
            case SUNDAY -> {
                return false;
            }
        }

        return false;
    }

}
