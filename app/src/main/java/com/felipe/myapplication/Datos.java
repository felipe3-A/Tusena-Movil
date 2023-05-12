package com.felipe.myapplication;

public class Datos {

    String id;
    String proyecto;
    String investigador;
    String identificacion;
    String productos;

    public Datos() {
    }

    public Datos(String id, String proyecto, String investigador, String identificacion, String productos) {
        this.id = id;
        this.proyecto = proyecto;
        this.investigador = investigador;
        this.identificacion = identificacion;
        this.productos = productos;
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

    @Override
    public String toString() {
        return "Datos{" +
                "id='" + id + '\'' +
                ", proyecto='" + proyecto + '\'' +
                ", investigador='" + investigador + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", productos='" + productos + '\'' +
                '}';
    }
}
