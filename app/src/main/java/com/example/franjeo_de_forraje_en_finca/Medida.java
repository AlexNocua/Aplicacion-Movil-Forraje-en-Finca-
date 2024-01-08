package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Medida extends AppCompatActivity {
    RelativeLayout Dibujo;
    Button BotonVDatos, BotonRegistro;
    TextView TVL, TVA, TVA4, TVAVD, Ancho, Largo, Avance, TAvance4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DecimalFormat df = new DecimalFormat("#.00");
        super.onCreate(savedInstanceState);

        Bundle Recibir = getIntent().getExtras();
        setContentView(R.layout.activity_medida);
        TVL = findViewById(R.id.TVL);
        TVA = findViewById(R.id.TVA);
        TVA4 = findViewById(R.id.TVAvance4);
        TVAVD = findViewById(R.id.TVAVD);
        Largo = findViewById(R.id.Largo);
        Ancho = findViewById(R.id.Ancho);
        Avance = findViewById(R.id.Avance);
        TAvance4 = findViewById(R.id.Avance4);
        Dibujo();


        double LFranja = Recibir.getDouble("LF");
        double Ll = Recibir.getDouble("LL");
        double Al = Recibir.getDouble("AL");
        double Avance4 = Recibir.getDouble("A4");
        double Arm = Recibir.getDouble("AR");
        TVL.setText("Largo: " + df.format(Ll) + " mtrs");
        TVA.setText("Ancho: " + df.format(Al) + " mtrs");
        TVAVD.setText("Avance Diario: " + df.format(Arm) + " mtrs");
        TVA4.setText("Avance en 4 h: " + df.format(Avance4) + " mtrs");

        Largo.setText("Largo: " + df.format(Ll) + " mtrs");
        Ancho.setText("Ancho: " + df.format(Al) + " mtrs");
        Avance.setText("Avance Diario: " + df.format(Arm) + " mtrs");
        TAvance4.setText("Avance en 4 h: " + df.format(Avance4) + " mtrs");


        BotonRegistro = findViewById(R.id.BotonRegistro);
        BotonRegistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Recibir.clear();
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("LF", LFranja);
                    returnIntent.putExtra("LL", Ll);
                    returnIntent.putExtra("AL", Al);
                    returnIntent.putExtra("A4", Avance4);
                    returnIntent.putExtra("AR", Arm);
                    setResult(RESULT_OK, returnIntent);

                TVL.setText("No hay datos.");
                TVA.setText("No hay datos.");
                TVAVD.setText("No hay datos.");
                TVA4.setText("No hay datos.");

                Largo.setText("No hay datos.");
                Ancho.setText("No hay datos.");
                Avance.setText("No hay datos.");
                TAvance4.setText("No hay datos.");
                    finish();


            }
        });

    }


    public void Dibujo() {
        try {

            Bitmap bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint2 = new Paint();
            paint2.setColor(Color.rgb(230, 81, 0));
            Paint paint3 = new Paint();
            paint3.setColor(Color.rgb(245, 127, 23));
            Paint paint4 = new Paint();
            paint4.setColor(Color.rgb(0, 137, 123));
            Paint paint1 = new Paint();
            paint1.setColor(Color.rgb(67, 160, 71));

            Paint paint = new Paint();
            paint.setColor(Color.rgb(124, 179, 66));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            paint.setAntiAlias(true);


            ImageView imagen = new ImageView(this);
            imagen = findViewById(R.id.Dibujo);
            canvas.drawRect(60, 10, 150, 250, paint);
            canvas.drawLine(60, 110, 172, 110, paint);
            canvas.drawLine(60, 36, 172, 36, paint);
            canvas.drawLine(154, 10, 154, 36, paint1);
            canvas.drawLine(154, 36, 154, 110, paint4);
            canvas.drawLine(56, 10, 56, 250, paint2);
            canvas.drawLine(60, 252, 150, 252, paint3);
            imagen.setImageBitmap(bitmap);

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }
}