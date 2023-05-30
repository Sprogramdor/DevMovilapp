package com.example.ejercicios_entre_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

}