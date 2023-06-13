package com.felipe.myapplication;

public class Resultados {


    String id;
    String investigador;
    String producto;
    String valor;
    String proyecto;
    int porcentaje;
    String nivel;

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public Resultados() {
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

    public String getProducto(String producto) {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Resultados{" +
                "id='" + id + '\'' +
                ", investigador='" + investigador + '\'' +
                ", producto='" + producto + '\'' +
                ", valor='" + valor + '\'' +
                ", proyecto='" + proyecto + '\'' +
                ", porcentaje=" + porcentaje +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}