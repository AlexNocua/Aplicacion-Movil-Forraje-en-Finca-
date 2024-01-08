package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public double DTFV, DTLlote, DTAlote, DTWAnimal, DTNumAnimales, cont3, DTFranjas;

    //asi se instancian el dipo
    TextView Texto1, Texto2, MostrarDT;
    EditText FV, WAnimales, NumAnimales, Llote, Alote, CercasElectricas;
    Button Boton1, Boton2;
    CheckBox CheckSi, CheckNo;
FloatingActionButton Flver,FLinfo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;
        SharedPreferences Guardar = getSharedPreferences("Archivo", context.MODE_PRIVATE);
        SharedPreferences.Editor Editor = Guardar.edit();
        Bundle EnviarDT = new Bundle();

        CheckSi = (CheckBox) findViewById(R.id.checkSi);
        CheckNo = (CheckBox) findViewById(R.id.checkNo);


        FV = (EditText) findViewById(R.id.FV);
        WAnimales = (EditText) findViewById(R.id.WAnimales);
        NumAnimales = (EditText) findViewById(R.id.NumAnimales);
        Llote = (EditText) findViewById(R.id.Llote);
        Alote = (EditText) findViewById(R.id.Alote);


        //Desarollo de las operaciones:
        //MostrarDT=(TextView)findViewById(R.id
        //  Texto1 = (TextView) findViewById(R.id.Texto1);
        //  Texto2 = (TextView) findViewById(R.id.Texto2);


        Boton1 = (Button) findViewById(R.id.BotonGuardar);
        //Prueba contador



        //////////////////////
        Boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


try{

                cont3 =cont3 +1;
                DTFV = Double.parseDouble(FV.getText().toString());
                DTWAnimal = Double.parseDouble(WAnimales.getText().toString());
                DTLlote = Double.parseDouble(Llote.getText().toString());
                DTAlote = Double.parseDouble(Alote.getText().toString());
                DTNumAnimales = Integer.parseInt(NumAnimales.getText().toString());


//


                //Toast.makeText(getBaseContext(), "Datos Guardados", Toast.LENGTH_SHORT).show();
                Intent MDT = new Intent(MainActivity.this, Result.class);
                EnviarDT.putDouble("DTFV", DTFV);
                EnviarDT.putDouble("DTWanimal", DTWAnimal);
                EnviarDT.putDouble("DTLlote", DTLlote);
                EnviarDT.putDouble("DTAlote", DTAlote);
                EnviarDT.putDouble("DTNumAnimales", DTNumAnimales);
                EnviarDT.putDouble("cont3",cont3);
                MDT.putExtras(EnviarDT);


                //condiciones
                if (CheckNo.isChecked() == false && CheckSi.isChecked() == false) {
                    Toast.makeText(getBaseContext(), "Por favor seleccione alguna de las opciones.", Toast.LENGTH_SHORT).show();
                } else {
                    if (CheckNo.isChecked() == true && CheckSi.isChecked() == true) {
                        Toast.makeText(getBaseContext(), "Las dos opciones no se pueden elegir.", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getBaseContext(), "Por favor verifique su elección.", Toast.LENGTH_SHORT).show();
                    } else {
                        if (CheckNo.isChecked() == true) {
                            Toast.makeText(getBaseContext(), "Sin cerca eléctrica no se puede calcular el forraje.", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getBaseContext(), "Por favor verifique su elección.", Toast.LENGTH_SHORT).show();
                            startActivity(MDT);
                        } else {
                            if (CheckSi.isChecked() == true) {
                                startActivity(MDT);

                            } else {
                                startActivity(MDT);
                                Toast.makeText(getBaseContext(), "Por favor verifique su elección.", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                }


            }catch (Exception e){
    Toast.makeText(getBaseContext(), "Verifique si ingreso correctamente todos los datos.", Toast.LENGTH_SHORT).show();
}}
        });
        FLinfo = findViewById(R.id.FLinfo);
        FLinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Info = new Intent(MainActivity.this, Informacion.class);
                startActivity(Info);
            }
        });
        Flver = findViewById(R.id.FloVer);
        Flver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ver = new Intent(MainActivity.this, Ver_datos_guardados.class);
                startActivity(Ver);
            }
        });

    }


}