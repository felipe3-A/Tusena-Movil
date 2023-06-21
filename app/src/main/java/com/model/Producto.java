package com.model;

public class Producto {

    String producto_titulo;
    String producto_ano;
    String producto_tipo;
    String producto_subtipo;

    String producto_id;
    String funcionario_iden;
    String funcionario_nombre;
    String funcionario_apellido;
    String proyecto_nombre;

    public Producto() {
    }

    public Producto(String producto_titulo, String producto_ano, String producto_tipo, String producto_subtipo, String funcionario_iden, String funcionario_nombre, String funcionario_apellido, String proyecto_nombre,String producto_id) {
        this.producto_titulo = producto_titulo;
        this.producto_ano = producto_ano;
        this.producto_tipo = producto_tipo;
        this.producto_id=producto_id;
        this.producto_subtipo = producto_subtipo;
        this.funcionario_iden = funcionario_iden;
        this.funcionario_nombre = funcionario_nombre;
        this.funcionario_apellido = funcionario_apellido;
        this.proyecto_nombre = proyecto_nombre;
    }

    public String getProducto_id() {return producto_id;}

    public void setProducto_id(String producto_id) {this.producto_id = producto_id;}
    public String getProducto_titulo() {
        return producto_titulo;
    }

    public void setProducto_titulo(String producto_titulo) {
        this.producto_titulo = producto_titulo;
    }

    public String getProducto_ano() {
        return producto_ano;
    }

    public void setProducto_ano(String producto_ano) {
        this.producto_ano = producto_ano;
    }

    public String getProducto_tipo() {
        return producto_tipo;
    }

    public void setProducto_tipo(String producto_tipo) {
        this.producto_tipo = producto_tipo;
    }

    public String getProducto_subtipo() {
        return producto_subtipo;
    }

    public void setProducto_subtipo(String producto_subtipo) {
        this.producto_subtipo = producto_subtipo;
    }

    public String getFuncionario_iden() {
        return funcionario_iden;
    }

    public void setFuncionario_iden(String funcionario_iden) {
        this.funcionario_iden = funcionario_iden;
    }

    public String getFuncionario_nombre() {
        return funcionario_nombre;
    }

    public void setFuncionario_nombre(String funcionario_nombre) {
        this.funcionario_nombre = funcionario_nombre;
    }

    public String getFuncionario_apellido() {
        return funcionario_apellido;
    }

    public void setFuncionario_apellido(String funcionario_apellido) {
        this.funcionario_apellido = funcionario_apellido;
    }

    public String getProyecto_nombre() {
        return proyecto_nombre;
    }

    public void setProyecto_nombre(String proyecto_nombre) {
        this.proyecto_nombre = proyecto_nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "producto_titulo='" + producto_titulo + '\'' +
                ", producto_ano='" + producto_ano + '\'' +
                ", producto_tipo='" + producto_tipo + '\'' +
                ", producto_subtipo='" + producto_subtipo + '\'' +
                ", funcionario_iden='" + funcionario_iden + '\'' +
                ", funcionario_nombre='" + funcionario_nombre + '\'' +
                ", funcionario_apellido='" + funcionario_apellido + '\'' +
                ", proyecto_nombre='" + proyecto_nombre + '\'' +producto_id+
                '}';
    }
}
