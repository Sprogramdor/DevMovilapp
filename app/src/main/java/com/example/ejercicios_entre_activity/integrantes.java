package com.example.ejercicios_entre_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class integrantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);
        TextView txtjugador = (TextView) findViewById(R.id.txt_welcome);
        Bundle bundle = getIntent().getExtras();
        String nombre_user=bundle.getString("usuario");
        txtjugador.setText("Bienvenid@, "+nombre_user+" estos son los integrantes de tu grupo");
   }

    public void borrarDatosOnClick(View v) {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("usuario");
        editor.remove("clave");
        editor.apply();
    }

}