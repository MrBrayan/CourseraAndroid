package com.codeneitor.contactosandroid;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactoActivity extends AppCompatActivity {

    private TextView tv_nombre, tv_fecha, tv_telefono, tv_email, tv_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        tv_nombre = findViewById(R.id.tv_nombre);
        tv_fecha = findViewById(R.id.tv_fecha);
        tv_telefono = findViewById(R.id.tv_telefono);
        tv_email = findViewById(R.id.tv_email);
        tv_descripcion = findViewById(R.id.tv_descripcion);

        Bundle parametros = getIntent().getExtras();
        final String nombre, fecha, telefono, email, descripcion;
        nombre = parametros.getString(getResources().getString(R.string.pnombre));
        fecha = parametros.getString(getResources().getString(R.string.pfecha));
        telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        email = parametros.getString(getResources().getString(R.string.pemail));
        descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        tv_nombre.setText(nombre);
        tv_fecha.setText(fecha);
        tv_telefono.setText(telefono);
        tv_email.setText(email);
        tv_descripcion.setText(descripcion);
        Button bt_editar = findViewById(R.id.bt_editar);

        bt_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pregunta = getResources().getString(R.string.pregVolver);
                Snackbar.make(v, pregunta, Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.volver), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("CONTACTO-SNACKBAR","Volver a editar los datos del contacto");
                                finish();
                            }
                        })
                        .show();
            }
        });
    }

}
