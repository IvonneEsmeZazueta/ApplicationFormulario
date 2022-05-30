package com.ivonne.applicationformulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnEnviar;
    EditText etNombre, etFecha, etEmail, etTelefono, etDescripcion;
    TextInputLayout tilNombre, tilEmail, tilTelefono, tilDescripcion;
    private int dia, mes, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        tilDescripcion = (TextInputLayout) findViewById(R.id.tilDescripcion);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        recibirMensajeEdiado();

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuffer strBuf = new StringBuffer();
                        strBuf.append(year);
                        strBuf.append("/");
                        strBuf.append(month+1);
                        strBuf.append("/");
                        strBuf.append(dayOfMonth);
                        etFecha.setText(strBuf.toString());
                    }
                };

                final Calendar now = Calendar.getInstance();
                int year = now.get(java.util.Calendar.YEAR);
                int month = now.get(java.util.Calendar.MONTH);
                int day = now.get(java.util.Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, onDateSetListener, year, month, day);
                datePickerDialog.setTitle("Fecha Nacimiento");
                datePickerDialog.show();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarInfo();
            }
        });
    }

    public void enviarInfo(){
        String nombre = etNombre.getText().toString();
        String email = etEmail.getText().toString();
        String fecha = etFecha.getText().toString();
        String telefono = etTelefono.getText().toString();
        String descripcion = etDescripcion.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(this, "Ingresa el nombre",Toast.LENGTH_SHORT).show();
        } else {
            if(fecha.isEmpty()){
                Toast.makeText(this, "Ingresa la fecha",Toast.LENGTH_SHORT).show();
            } else {
                if(telefono.isEmpty()){
                    Toast.makeText(this, "Ingresa el telefono",Toast.LENGTH_SHORT).show();
                } else {
                    if (email.isEmpty()){
                        Toast.makeText(this, "Ingresa el email",Toast.LENGTH_SHORT).show();
                    } else {
                        if (descripcion.isEmpty()){
                            Toast.makeText(this, "Ingresa la descripción",Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                Intent intent1 = new Intent(this, SecondActivity.class);
                                intent1.putExtra("nombre", nombre);
                                intent1.putExtra("email", email);
                                intent1.putExtra("fecha", fecha);
                                intent1.putExtra("telefono", telefono);
                                intent1.putExtra("descripcion", descripcion);
                                startActivity(intent1);
                            } catch (Exception e){
                                Toast.makeText(this, "Ocurrio un error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        }
    }

    public void recibirMensajeEdiado(){
        Intent intent2 = getIntent();
        String nombre = intent2.getStringExtra("nombre");
        String email = intent2.getStringExtra("email");
        String fecha = intent2.getStringExtra("fecha");
        String telefono = intent2.getStringExtra("telefono");
        String descripcion = intent2.getStringExtra("descripcion");

        etNombre.setText(nombre);
        etEmail.setText(email);
        etFecha.setText(fecha);
        etTelefono.setText(telefono);
        etDescripcion.setText(descripcion);
    }
}