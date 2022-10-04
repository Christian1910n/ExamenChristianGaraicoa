package com.example.examen_christiangaraicoa;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.examen_christiangaraicoa.Utils.productsService;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<products>> productsList=new MutableLiveData<>();
    public LiveData<List<products>> getproductsList(){
        return productsList;
    }

    public void getproducts(){
        String URL_001="https://fipo.equisd.com/api/";
        productsService productsService;
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(URL_001).addConverterFactory(GsonConverterFactory.create()).build();
        productsService= retrofit.create(productsService.class);



        Call<JsonResponse> call=productsService.getproducts();

        call.enqueue(new Callback<JsonResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }
                JsonResponse jsonResponse= response.body();
                productsList.setValue(jsonResponse.getObjects());
            }


            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e("Response err: ", t.getMessage());
            }
        });


    }

}
