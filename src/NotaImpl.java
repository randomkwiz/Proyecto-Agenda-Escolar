/*
 * Propiedades
 *   Basicas
 *          UsuarioImpl usuario
 *          Modulo modulo
 *          double calificacion
 *          String observaciones
 *          GregorianCalendar fecha
 *
 *
 *   Derivadas
 *   Compartidas
 * Requisitos:
 *
 * Metodos interface
 * Metodos añadidos
 * Metodos object y otros:
 * */

import java.util.GregorianCalendar;

public class NotaImpl {

    private UsuarioImpl usuario;
    private Modulo modulo;
    private double calificacion;
    private String observaciones;
    private GregorianCalendar fecha;

    public NotaImpl(UsuarioImpl usuario, Modulo modulo, double calificacion, String observaciones, GregorianCalendar fecha) {
        this.usuario = usuario;
        this.modulo = modulo;
        this.calificacion = calificacion;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public UsuarioImpl getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioImpl usuario) {
        this.usuario = usuario;
    }
    public String getNombreUsuario() {
        return usuario.getNombre();
    }

    public Modulo getModulo() {
        return modulo;
    }
    public String getNombreModulo() {
        return modulo.name();
    }
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
