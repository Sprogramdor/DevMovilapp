package com.example.ejercicios_entre_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class Clase_22 extends AppCompatActivity {

    private String nSpinnerLabel = "";
    EditText txt_usuario, txt_apellido;
    EditText txt_cedula, txt_edad;
    EditText txt_nacimiento;
    RadioButton soltero, casado, union;
    Spinner spinner_genero;
    Spinner spinner_nacionalidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase22);
        txt_usuario=(EditText)findViewById(R.id.txt_nombre);
        txt_apellido=(EditText)findViewById(R.id.txt_apellidos);

        soltero =(RadioButton) findViewById(R.id.rbt_soltero);
        casado =(RadioButton) findViewById(R.id.rbt_casado);
        union =(RadioButton) findViewById(R.id.rbt_union);
        txt_cedula=(EditText)findViewById(R.id.txt_cedula);
        txt_edad=(EditText)findViewById(R.id.txt_edad);
        txt_nacimiento=(EditText)findViewById(R.id.dtm_fecha_nacimiento);
        spinner_genero =(Spinner) findViewById(R.id.spn_genero);
        spinner_nacionalidad =(Spinner) findViewById(R.id.spn_nacionalidad);
            //Spinner de Nacionalidad


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nacionalidades,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_nacionalidad.setAdapter(adapter);
        spinner_nacionalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
               nSpinnerLabel = parent.getItemAtPosition(position).toString();
             }

            @Override
             public void onNothingSelected(AdapterView<?> parent){

            }
        });

        //Spinner de Genero


        ArrayAdapter<CharSequence> adapter_g = ArrayAdapter.createFromResource(this, R.array.genero,android.R.layout.simple_spinner_item);
        adapter_g.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_genero.setAdapter(adapter_g);
        spinner_genero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                nSpinnerLabel = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });


    }

    public void botonregistrar(View view){

        if(txt_usuario.getText().toString().equals("")|| txt_apellido.getText().toString().equals("") || txt_edad.getText().toString().equals("") || txt_nacimiento.getText().toString().equals("") ||
        txt_cedula.getText().toString().equals("") || spinner_nacionalidad.getSelectedItemPosition()==0 || spinner_genero.getSelectedItemPosition()==0){
            Toast.makeText(view.getContext(), "Ingrese los datos correspondientes", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "El usuario  " + txt_apellido.getText().toString() +" "+txt_usuario.getText().toString() + " se ha registrado", Toast.LENGTH_SHORT).show();
        }

    }

    public void botoncancelar(View view){
        finish();
    }

    public void botonborrar(View view){
        txt_usuario.setText("");
        txt_cedula.setText("");
        txt_apellido.setText("");
        txt_edad.setText("");
        txt_nacimiento.setText("");
        spinner_genero.setSelection(0);
        spinner_nacionalidad.setSelection(0);
    }

    public void onRadioButtonClicked (View view){
        String cad="Has seleccionado: ";
        if (soltero.isChecked()==true){
            Toast.makeText(getApplicationContext(), cad+=soltero.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (casado.isChecked()==true){
            Toast.makeText(getApplicationContext(), cad+=casado.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (union.isChecked()==true){
            Toast.makeText(getApplicationContext(), cad+=union.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarCalendaario(View view){
        DatePickerDialog nac = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txt_nacimiento.setText(dayOfMonth+"/"+(month+1)+"/"+year+"");
            }
        }, 2023, 0, 1);
        nac.show();
    }


}