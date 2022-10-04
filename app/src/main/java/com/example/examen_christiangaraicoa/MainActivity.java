package com.example.examen_christiangaraicoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.widget.Toast;

import com.example.examen_christiangaraicoa.databinding.ActivityMainBinding;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Adapter adapter = new Adapter();
        adapter.setOnItemClickListener(products -> {
                    Toast.makeText(MainActivity.this, products.getName(), Toast.LENGTH_SHORT);
                    int rotacion = getWindowManager().getDefaultDisplay().getRotation();
                    if (rotacion == Surface.ROTATION_0) {

                    } else {
                        binding.txtNombre.setText(products.getName());
                        binding.txtprecio.setText(products.getPrice());
                    }
                }

        );


        binding.recycler.setAdapter(adapter);


        viewModel.getproductsList().observe(this, list -> {
            adapter.submitList(list);

            if (list.isEmpty()) {
                System.out.println("Autores Vacios");
            } else {
                System.out.println("Funciona");
            }
        });


        viewModel.getproducts();


    }


}