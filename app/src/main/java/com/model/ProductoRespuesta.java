package com.model;

import java.util.ArrayList;

public class ProductoRespuesta {

    private ArrayList<Producto> producto;

    public ProductoRespuesta() {

    }

    public ProductoRespuesta(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String  toString() {
        return "ProductoRespuesta{" +
                "productos=" + producto +
                '}';
    }
}
