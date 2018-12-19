package com.codeneitor.contactosandroid;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Contacto contacto;
    private TextInputEditText et_nombre, et_fecha, et_telefono, et_email, et_descripcion;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = findViewById(R.id.et_nombre);
        et_telefono = findViewById(R.id.et_telefono);
        et_email = findViewById(R.id.et_email);
        et_descripcion = findViewById(R.id.et_descripcion);
        et_fecha = findViewById(R.id.et_fecha);
        et_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int agno = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialogo = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        agno,mes,dia);
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();
            }
        });
        Button bt_siguiente = findViewById(R.id.bt_siguiente);
        bt_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, fecha, telefono, email, descripcion;
                nombre= et_nombre.getText().toString();
                fecha = et_fecha.getText().toString();
                telefono = et_telefono.getText().toString();
                email = et_email.getText().toString();
                descripcion = et_descripcion.getText().toString();
                contacto = new Contacto(nombre, fecha, telefono, email, descripcion);
                Intent i = new Intent(MainActivity.this, ContactoActivity.class);
                i.putExtra(getResources().getString(R.string.pnombre),contacto.getNombre());
                i.putExtra(getResources().getString(R.string.pfecha),contacto.getFechaN());
                i.putExtra(getResources().getString(R.string.ptelefono),contacto.getTelefono());
                i.putExtra(getResources().getString(R.string.pemail),contacto.getEmail());
                i.putExtra(getResources().getString(R.string.pdescripcion),contacto.getDescripcion());
                startActivity(i);
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int agno, int mes, int dia) {
                mes = mes+1;
                String fecha = mes+ "/"+dia+"/"+agno;
                et_fecha.setText(fecha);
            }
        };
    }
}
