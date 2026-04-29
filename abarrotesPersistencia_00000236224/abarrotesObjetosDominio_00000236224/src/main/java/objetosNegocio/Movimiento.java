/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import java.util.Date;

import java.util.Random;

/**
 *
 * @author rober
 */
public class Movimiento {

    /**
     * Clave única del movimiento (formato MV###).
     */
    private String cveMovimiento;

    /**
     * Fecha en la que se realizó el movimiento.
     */
    private Date fecha;

    /**
     * Indica si el movimiento ya fue procesado.
     */
    private boolean procesado;
    //private static int contador = 1;

    /**
     * Constructor por defecto.
     */
    public Movimiento() {
    }

    /**
     * Constructor que inicializa todos los atributos del movimiento.
     *
     * @param cveMovimiento Clave del movimiento (formato MV###)
     * @param fecha Fecha del movimiento (no puede ser futura)
     * @param procesado Indica si el movimiento ya fue procesado
     */
    public Movimiento(String cveMovimiento, Date fecha, boolean procesado) {
        //this.cveMovimiento = String.format("MV%03d", contador++);
        if (cveMovimiento != null && cveMovimiento.matches("MV[0-9]{3}")) {
            this.cveMovimiento = cveMovimiento;
        }
        if (fecha != null && !fecha.after(new Date())) {
            this.fecha = fecha;
        }
        this.procesado = procesado;
    }

    /**
     * Constructor que inicializa solo la clave del movimiento. Los demás
     * atributos se inicializan a valores por defecto.
     *
     * @param cveMovimiento Clave del movimiento
     */
    public Movimiento(String cveMovimiento) {

        if (cveMovimiento != null && cveMovimiento.matches("MV[0-9]{3}")) {
            this.cveMovimiento = cveMovimiento;
        }
        this.fecha = null;
        this.procesado = false;
    }

    /**
     * Obtiene la clave del movimiento.
     *
     * @return Clave del movimiento
     */
    public String getCveMovimiento() {
        return this.cveMovimiento;
    }

    /**
     * Establece la clave del movimiento.
     *
     * @param cveMovimiento Nueva clave del movimiento
     */
    public void setCveMovimiento(String cveMovimiento) {
        if (cveMovimiento != null && cveMovimiento.matches("MV[0-9]{3}")) {
            this.cveMovimiento = cveMovimiento;
        }
    }

    /**
     * Obtiene la fecha del movimiento.
     *
     * @return Fecha del movimiento
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Establece la fecha del movimiento.
     *
     * @param fecha Nueva fecha (no puede ser futura)
     */

    public void setFecha(Date fecha) {
        if (fecha != null && !fecha.after(new Date())) {
            this.fecha = fecha;
        }
    }

    /**
     * Indica si el movimiento ha sido procesado.
     *
     * @return true si está procesado, false en caso contrario
     */

    public boolean getProcesado() {
        return this.procesado;
    }

    /**
     * Establece el estado de procesamiento del movimiento.
     *
     * @param procesado Estado del movimiento
     */
    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    /**
     * Compara dos movimientos por su clave.
     *
     * @param otroObjeto Objeto a comparar
     * @return true si son del mismo tipo y tienen la misma clave
     */
    @Override
    public boolean equals(Object otroObjeto) {

        if (otroObjeto == null) {
            return false;
        }

        if (this.getClass() != otroObjeto.getClass()) {
            return false;
        }

        Movimiento otroProducto = (Movimiento) otroObjeto;
        return this.cveMovimiento.equals(otroProducto.cveMovimiento);
    }

    /**
     * Genera un código hash para el objeto.
     *
     * @return Código hash del movimiento
     */
    @Override
    public int hashCode() {
        Random rand = new Random();
        int min = 1;
        int max = 10;

        int randomNum = rand.nextInt((max - min) + 1) + min;
        int hash;
        hash = randomNum;
        return hash;
    }

    /**
     * Devuelve una representación en texto del movimiento.
     *
     * @return Cadena con los valores separados por comas
     */
    @Override
    public String toString() {
        return cveMovimiento + "," + fecha + "," + procesado;
    }

}

/*
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof Movimiento)) {
            return false;
        }

        Movimiento otro = (Movimiento) object;
        return Objects.equals(this.cveMovimiento, otro.cveMovimiento);
 */
