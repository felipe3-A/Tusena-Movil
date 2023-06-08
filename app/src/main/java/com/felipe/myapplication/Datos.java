package com.felipe.myapplication;

public class Datos {
    String contenedor;
    String id;
    String proyecto;
    String investigador;
    String identificacion;
    String productos;
    String tipocodigoproducto;
    String numerodelproyecto;

    public Datos() {
    }



    public Datos(String contenedor,String id, String proyecto, String investigador, String identificacion, String productos, String tipocodigoproducto, String numerodelproyecto) {
        this.contenedor=contenedor;
        this.id = id;
        this.proyecto = proyecto;
        this.investigador = investigador;
        this.identificacion = identificacion;
        this.productos = productos;
        this.tipocodigoproducto = tipocodigoproducto;
        this.numerodelproyecto = numerodelproyecto;
    }

    public String getContenedor() {
        return contenedor;
    }


    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getInvestigador() {
        return investigador;
    }

    public void setInvestigador(String investigador) {
        this.investigador = investigador;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getTipocodigoproducto() {
        return tipocodigoproducto;
    }

    public void setTipocodigoproducto(String tipocodigoproducto) {
        this.tipocodigoproducto = tipocodigoproducto;
    }

    public String getNumerodelproyecto() {
        return numerodelproyecto;
    }

    public void setNumerodelproyecto(String numerodelproyecto) {
        this.numerodelproyecto = numerodelproyecto;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "contenedor='" + contenedor + '\'' +
                ", id='" + id + '\'' +
                ", proyecto='" + proyecto + '\'' +
                ", investigador='" + investigador + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", productos='" + productos + '\'' +
                ", tipocodigoproducto='" + tipocodigoproducto + '\'' +
                ", numerodelproyecto='" + numerodelproyecto + '\'' +
                '}';
    }
}
