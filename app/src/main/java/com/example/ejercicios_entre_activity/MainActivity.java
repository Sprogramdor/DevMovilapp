package com.example.ejercicios_entre_activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText txt_usuario;
    EditText txt_clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //acceder al toolbar
        setContentView(R.layout.activity_main);
        Toolbar myToolbar= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    //acceder a los botones
        Button btn_aceptar = (Button)findViewById(R.id.btn_aceptar);


    }


/// Creacion de Menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.mn,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
       int id= item.getItemId();
       if(id == R.id.acercaid) {
           Intent call = new Intent(this, About.class);
           startActivity(call);
       }else{
           Toast.makeText(this, "Configuraciones", Toast.LENGTH_SHORT).show();
       }
   return super.onOptionsItemSelected(item);
    }

    public void botonAceptar(View v){
        txt_usuario=(EditText)findViewById(R.id.txt_user);
        txt_clave=(EditText)findViewById(R.id.txt_pass);
        String[] usuario = { "Emily", "Fabrizio", "Jesus" };
        String[] contraseñas = {"123","456","789" };
        if(txt_usuario.getText().toString().equals("")&& txt_clave.getText().toString().equals("") ||
                txt_usuario.getText().toString().equals("") || txt_clave.getText().toString().equals("")){
            Toast.makeText(v.getContext(), "INGRESE USUARIO Y CONTRASEÑA I", Toast.LENGTH_SHORT).show();
        }
        else if(!txt_usuario.getText().toString().isEmpty() && !txt_clave.getText().toString().isEmpty()){
            boolean encontrado = userPass(usuario, contraseñas, txt_usuario.getText().toString(), txt_clave.getText().toString());
            if (encontrado) {
                Intent call = new Intent(this, integrantes.class);
                call.putExtra( "usuario",txt_usuario.getText().toString());
                call.putExtra("clave",txt_clave.getText().toString());
                startActivity(call);
            } else {
                Toast.makeText(v.getContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(v.getContext(), "hay un problema", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean userPass (String[] usuario, String[] contraseña, String elemento, String elemento2) {
        if (usuario.length != contraseña.length) {
            throw new IllegalArgumentException("Los arreglos no tienen la misma longitud");
        }

        // Buscar los elementos en los arreglos y comparar sus posiciones
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i].equals(elemento) && contraseña[i].equals(elemento2)) {
                return true;
            }
        }

        return false;
    }


    public void botonCancelar(View v){
        Toast toast = Toast.makeText(v.getContext(), "Ha salido de la aplicación",Toast.LENGTH_LONG);
        toast.show();
        finish();
    }

    public void botonCuenta(View v){
        Intent call = new Intent(this, Clase_22.class);
        startActivity(call);
    }
}