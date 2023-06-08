package com.felipe.myapplication.Interfaces;

import com.model.Producto;
import com.model.ProductoRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProducctoService {
    @GET("productos/{id}")
    Call<List<Producto>> obtenerListaProducto(@Path("id")String  id);
}
