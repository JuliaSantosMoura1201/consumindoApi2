package com.julia.consumindoapi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textResposta;
    private ModeloService modeloService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResposta = findViewById(R.id.textResposta);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        modeloService = (ModeloService) retrofit.create(ModeloService.class);
        getPosts();
    }

    private void getPosts(){
        Call<Modelo> call = modeloService.getModelo();

        call.enqueue(new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                Modelo modelo = response.body();

                textResposta.setText(modelo.toString());
            }

            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {

            }
        });
    }
}
