package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Ver_datos_guardados extends AppCompatActivity {
    TextView Dato1, Dato2, Dato3, Dato4, Dato5;
    Button volver;
    public String Guardar1, Guardar2, Guardar3, Guardar4, Guardar5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_guardados);
        Context context = this;
        SharedPreferences Guardar = getSharedPreferences("Archivo", context.MODE_PRIVATE);
        SharedPreferences.Editor Editor = Guardar.edit();

        Dato1 = findViewById(R.id.Datos1);
        Dato2 = findViewById(R.id.Datos2);
        Dato3 = findViewById(R.id.Datos3);
        Dato4 = findViewById(R.id.Datos4);
        Dato5 = findViewById(R.id.Datos5);

        Guardar1 = Guardar.getString("Check1", "No hay dato");
        Guardar2 = Guardar.getString("Check2", "No hay dato");
        Guardar3 = Guardar.getString("Check3", "No hay dato");
        Guardar4 = Guardar.getString("Check4", "No hay dato");
        Guardar5 = Guardar.getString("Check5", "No hay dato");
        Dato1.setText(Guardar1);
        Dato2.setText(Guardar2);
        Dato3.setText(Guardar3);
        Dato4.setText(Guardar4);
        Dato5.setText(Guardar5);

        volver = findViewById(R.id.BTVolver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MDT = new Intent(Ver_datos_guardados.this, MainActivity.class);
                startActivity(MDT);
                finish();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Check1", Guardar1);
        outState.putString("Check2", Guardar2);
        outState.putString("Check3", Guardar3);
        outState.putString("Check4", Guardar4);
        outState.putString("Check5", Guardar5);


    }
}