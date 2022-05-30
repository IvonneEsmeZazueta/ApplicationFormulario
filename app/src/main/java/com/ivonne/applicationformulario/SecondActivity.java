package com.ivonne.applicationformulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnEditar;
    TextView tvInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnEditar = (Button) findViewById(R.id.btnEditar);
        tvInformacion = (TextView) findViewById(R.id.tvInformacion);

        recibirMensaje();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarInfo();
            }
        });
    }

    public void recibirMensaje(){
        Intent intent2 = getIntent();
        String nombre = intent2.getStringExtra("nombre");
        String email = intent2.getStringExtra("email");
        String fecha = intent2.getStringExtra("fecha");
        String telefono = intent2.getStringExtra("telefono");
        String descripcion = intent2.getStringExtra("descripcion");

        tvInformacion.setText(nombre + "\nFecha de nacimiento: " + fecha + "\nTel. " + telefono + "\nEmail: " + email + "\nDescripción: " + descripcion);
    }

    public void editarInfo(){
        Intent intent2 = getIntent();
        String nombre = intent2.getStringExtra("nombre");
        String email = intent2.getStringExtra("email");
        String fecha = intent2.getStringExtra("fecha");
        String telefono = intent2.getStringExtra("telefono");
        String descripcion = intent2.getStringExtra("descripcion");

        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.putExtra("nombre", nombre);
        intent1.putExtra("email", email);
        intent1.putExtra("fecha", fecha);
        intent1.putExtra("telefono", telefono);
        intent1.putExtra("descripcion", descripcion);
        startActivity(intent1);
    }
}