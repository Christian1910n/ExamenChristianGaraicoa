package com.example.examen_christiangaraicoa.Utils;

import com.example.examen_christiangaraicoa.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface productsService {
    @GET("products.json")
    public Call<JsonResponse> getproducts();

}
