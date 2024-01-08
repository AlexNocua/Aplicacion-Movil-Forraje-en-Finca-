package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Informacion extends AppCompatActivity {
Button BTVolverM;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        BTVolverM = findViewById(R.id.BTVolverM);
        BTVolverM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MDT = new Intent(Informacion.this, MainActivity.class);
                startActivity(MDT);
                finish();
            }
        });
    }
}