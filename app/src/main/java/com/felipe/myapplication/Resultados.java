package com.felipe.myapplication;

public class Resultados {
    public static String id;
    public  static String investigador;
    public static  String producto;

<<<<<<< HEAD
    String id_producto;
    String proyecto;
    String nivel;
=======
    public  static  String id_producto;
    public  static  String proyecto;
    public  static String nivel;
>>>>>>> fc68081c294d879b74f5fd5be51a87ece6d4dccb
    public static int porcentaje;

    String tipo_producto;
    String subtipo;
    String anio;
    String id_investigador;


    public Resultados() {
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getId_investigador() {
        return id_investigador;
    }

    public void setId_investigador(String id_investigador) {
        this.id_investigador = id_investigador;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvestigador() {
        return investigador;
    }

    public void setInvestigador(String investigador) {
        this.investigador = investigador;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getId_producto() {return id_producto;}

    public void setId_producto(String id_producto) {this.id_producto = id_producto;}


    @Override
    public String toString() {
        return "Resultados{" +
                "id='" + id + '\'' +
                ", investigador='" + investigador + '\'' +
                ", producto='" + producto + '\'' +
                ", proyecto='" + proyecto + '\'' +
                ", porcentaje=" + porcentaje +
                id_producto+
                ", nivel='" + nivel + '\'' ;

    }
}