package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.Arrays;

public class RegidstrosGuardados extends AppCompatActivity {
    public double DTLlote;
    public double DTAlote;
    public double LFanja;
    public double Arml;
    public double Avance4;
    double cont = 0, PromAl, PromLl, PromLf, PromA4, PromAr;
    public String Guardar1, Guardar2, Guardar3, Guardar4, Guardar5;
    TextView Dato1, Dato2, Dato3, Dato4, Dato5;
    CheckBox Check1, Check2, Check3, Check4, Check5;
    Button BotonVisualizar,BotonRes;
    FloatingActionButton FABEliminar, FABProm;
    private static final int REQUEST_CODE = 1;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //FABProm=findViewById(R.id.FABProm);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regidstros_guardados);

        ////////////////////////////////////////////////
        Context context = this;
        SharedPreferences Guardar = getSharedPreferences("Archivo", context.MODE_PRIVATE);
        SharedPreferences.Editor Editor = Guardar.edit();
        ///////////////////////////////////////////////
        Bundle EnviarV = new Bundle();
        Bundle RecibirR = getIntent().getExtras();
        DecimalFormat df = new DecimalFormat("#.00");
        BotonVisualizar = findViewById(R.id.Botonvisualizar);
////////////////////////////////////////

/*SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
SharedPreferences.Editor editor = prefs.edit();
double[] myArray = { 1.2, 3.4, 5.6 };
String arrayString = TextUtils.join(",", myArray);
editor.putString("myArrayKey", arrayString);
editor.apply();

// Acceder al arreglo de Double desde SharedPreferences
String savedArrayString = prefs.getString("myArrayKey", "");
String[] savedArray = savedArrayString.split(",");
double[] retrievedArray = new double[savedArray.length];
for (int i = 0; i < savedArray.length; i++) {
    retrievedArray[i] = Double.parseDouble(savedArray[i]);
}*/
        ///////////////////////////////////////
        double[] AL = new double[5];
        double[] LL = new double[5];
        double[] LF = new double[5];
        double[] A4 = new double[5];
        double[] AR = new double[5];
        double[] arregloGuardadoAL = new double[5];
        double[] arregloGuardadoLL = new double[5];
        double[] arregloGuardadoLF = new double[5];
        double[] arregloGuardadoA4 = new double[5];
        double[] arregloGuardadoAR = new double[5];
        cont = RecibirR.getDouble("cont");
        Dato1 = findViewById(R.id.Datos1);
        Dato2 = findViewById(R.id.Datos2);
        Dato3 = findViewById(R.id.Datos3);
        Dato4 = findViewById(R.id.Datos4);
        Dato5 = findViewById(R.id.Datos5);

        Guardar1 = Guardar.getString("Check1", "No hay datos.");
        Guardar2 = Guardar.getString("Check2", "No hay datos.");
        Guardar3 = Guardar.getString("Check3", "No hay datos.");
        Guardar4 = Guardar.getString("Check4", "No hay datos.");
        Guardar5 = Guardar.getString("Check5", "No hay datos.");

        Dato1.setText(Guardar1);
        Dato2.setText(Guardar2);
        Dato3.setText(Guardar3);
        Dato4.setText(Guardar4);
        Dato5.setText(Guardar5);
        try {


            switch ((int) cont) {
                case 1:

                    AL[0] = RecibirR.getDouble("DTAlote");
                    LL[0] = RecibirR.getDouble("DTLlote");
                    LF[0] = RecibirR.getDouble("L_Fanja");
                    A4[0] = RecibirR.getDouble("Avance4");
                    AR[0] = RecibirR.getDouble("ArmL");
                    Dato1.setText("Ancho Lote: " + df.format(AL[0]) + "\nLargo lote: " + df.format(LL[0])+" mts." + "\nArmar lotes de: " + df.format(AR[0])+" mts^2."  + "\nLongitud de la franja: " + df.format(LF[0]) +" mts^2." + "\nAva En 4 horas:  " + df.format(A4[0])+" mts^2." );

                    Editor.putFloat("AL0" + 1, (float) AL[0]);
                    Editor.putFloat("LL0" + 1, (float) LL[0]);
                    Editor.putFloat("LF0" + 1, (float) LF[0]);
                    Editor.putFloat("A40" + 1, (float) A4[0]);
                    Editor.putFloat("AR0" + 1, (float) AR[0]);

                    //Editor.putInt("DTAlote", Integer.parseInt(String.valueOf(AL[0])));
                    Editor.putString("Check1", Dato1.getText().toString());
                    Editor.apply();
                    break;

                case 2:

                    AL[1] = RecibirR.getDouble("DTAlote");
                    LL[1] = RecibirR.getDouble("DTLlote");
                    LF[1] = RecibirR.getDouble("L_Fanja");
                    A4[1] = RecibirR.getDouble("Avance4");
                    AR[1] = RecibirR.getDouble("Arml");
                    Dato2.setText("Ancho Lote: " + df.format(AL[1]) +" mts." + "\nLargo lote: " + df.format(LL[1]) +" mts." + "\nArmar lotes de: " + df.format(AR[1]) +" mts^2." + "\nLongitud de la franja: " + df.format(LF[1])+" mts^2."  + "\nAva En 4 horas: " + df.format(A4[1])+" mts^2." );
                    Editor.putString("Check2", Dato2.getText().toString());
                    Editor.putFloat("AL1" + 2, (float) AL[1]);
                    Editor.putFloat("LL1" + 2, (float) LL[1]);
                    Editor.putFloat("LF1" + 2, (float) LF[1]);
                    Editor.putFloat("A41" + 2, (float) A4[1]);
                    Editor.putFloat("AR1" + 2, (float) AR[1]);
                    Editor.apply();
                    break;
                case 3:

                    AL[2] = RecibirR.getDouble("DTAlote");
                    LL[2] = RecibirR.getDouble("DTLlote");
                    LF[2] = RecibirR.getDouble("L_Fanja");
                    A4[2] = RecibirR.getDouble("Avance4");
                    AR[2] = RecibirR.getDouble("Arml");
                    Dato3.setText("Ancho Lote: " + df.format(AL[2])+" mts."  + "\nLargo lote: " + df.format(LL[2])+" mts."  + "\nArmar lotes de: " + df.format(AR[2]) +" mts^2." + "\nLongitud de la franja: " + df.format(LF[2]) +" mts^2." + "\nAva En 4 horas:  " + df.format(A4[2])+" mts^2." );
                    Editor.putString("Check3", Dato3.getText().toString());
                    Editor.putFloat("AL2" + 3, (float) AL[2]);
                    Editor.putFloat("LL2" + 3, (float) LL[2]);
                    Editor.putFloat("LF2" + 3, (float) LF[2]);
                    Editor.putFloat("A42" + 3, (float) A4[2]);
                    Editor.putFloat("AR2" + 3, (float) AR[2]);
                    Editor.apply();
                    break;
                case 4:

                    AL[3] = RecibirR.getDouble("DTAlote");
                    LL[3] = RecibirR.getDouble("DTLlote");
                    LF[3] = RecibirR.getDouble("L_Fanja");
                    A4[3] = RecibirR.getDouble("Avance4");
                    AR[3] = RecibirR.getDouble("Arml");
                    Dato4.setText("Ancho Lote: " + df.format(AL[3]) +" mts." + "\nLargo lote: " + df.format(LL[3])+" mts."  + "\nArmar lotes de: " + df.format(AR[3]) +" mts^2." + "\nLongitud de la franja: " + df.format(LF[3]) +" mts^2." + "\nAva En 4 horas:  " + df.format(A4[3])+" mmts^2." );
                    Editor.putString("Check4", Dato4.getText().toString());
                    Editor.putFloat("AL3" + 4, (float) AL[3]);
                    Editor.putFloat("LL3" + 4, (float) LL[3]);
                    Editor.putFloat("LF3" + 4, (float) LF[3]);
                    Editor.putFloat("A43" + 4, (float) A4[3]);
                    Editor.putFloat("AR3" + 4, (float) AR[3]);
                    Editor.apply();
                    break;
                case 5:

                    AL[4] = RecibirR.getDouble("DTAlote");
                    LL[4] = RecibirR.getDouble("DTLlote");
                    LF[4] = RecibirR.getDouble("L_Fanja");
                    A4[4] = RecibirR.getDouble("Avance4");
                    AR[4] = RecibirR.getDouble("Arml");
                    Dato5.setText("Ancho Lote: " + df.format(AL[4]) +" mts." + "\nLargo lote: " + df.format(LL[4]) +" mts." + "\nArmar lotes de: " + df.format(AR[4])+" mts^2."  + "\nLongitud de la franja: " + df.format(LF[4]) +" mts^2." + "\nAva En 4 horas:  " + df.format(A4[4])+" mts^2." );
                    Editor.putString("Check5", Dato5.getText().toString());
                    Editor.putFloat("AL4" + 5, (float) AL[4]);
                    Editor.putFloat("LL4" + 5, (float) LL[4]);
                    Editor.putFloat("LF4" + 5, (float) LF[4]);
                    Editor.putFloat("A44" + 5, (float) A4[4]);
                    Editor.putFloat("AR4" + 5, (float) AR[4]);
                    Editor.apply();
                    break;
                default:
                    Toast.makeText(getBaseContext(), "Limite de datos alcanzado." + DTLlote, Toast.LENGTH_SHORT).show();

            }


        } catch (Exception e) {
            Toast.makeText(getBaseContext(), " Error", Toast.LENGTH_SHORT).show();
        }


        FABEliminar = findViewById(R.id.Borrar);
        FABEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(RegidstrosGuardados.this);
                alerta.setMessage("¿Quiere eliminar los registros?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Dato1.setText("No hay Datos.");
                                Dato2.setText("No hay Datos.");
                                Dato3.setText("No hay Datos.");
                                Dato4.setText("No hay Datos.");
                                Dato5.setText("No hay Datos.");
                                Editor.clear().commit();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog Titulo = alerta.create();
                Titulo.setTitle("Confirmar");
                Titulo.show();
            }
        });
        FABProm = findViewById(R.id.FABPROM);
        FABProm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try {



                    arregloGuardadoLF[0] = Guardar.getFloat("AL0" + 1, 0.0f);
                    arregloGuardadoLL[0] = Guardar.getFloat("LL0" + 1, 0.0f);
                    arregloGuardadoAL[0] = Guardar.getFloat("AL0" + 1, 0.0f);
                    arregloGuardadoA4[0] = Guardar.getFloat("A40" + 1, 0.0f);
                    arregloGuardadoAR[0] = Guardar.getFloat("AR0" + 1, 0.0f);
                    arregloGuardadoLF[1] = Guardar.getFloat("AL1" + 2, 0.0f);
                    arregloGuardadoLL[1] = Guardar.getFloat("LL1" + 2, 0.0f);
                    arregloGuardadoAL[1] = Guardar.getFloat("AL1" + 2, 0.0f);
                    arregloGuardadoA4[1] = Guardar.getFloat("A41" + 2, 0.0f);
                    arregloGuardadoAR[1] = Guardar.getFloat("AR1" + 2, 0.0f);
                    arregloGuardadoLF[2] = Guardar.getFloat("AL2" + 3, 0.0f);
                    arregloGuardadoLL[2] = Guardar.getFloat("LL2" + 3, 0.0f);
                    arregloGuardadoAL[2] = Guardar.getFloat("AL2" + 3, 0.0f);
                    arregloGuardadoA4[2] = Guardar.getFloat("A42" + 3, 0.0f);
                    arregloGuardadoAR[2] = Guardar.getFloat("AR2" + 3, 0.0f);
                    arregloGuardadoLF[3] = Guardar.getFloat("AL3" + 4, 0.0f);
                    arregloGuardadoLL[3] = Guardar.getFloat("LL3" + 4, 0.0f);
                    arregloGuardadoAL[3] = Guardar.getFloat("AL3" + 4, 0.0f);
                    arregloGuardadoA4[3] = Guardar.getFloat("A43" + 4, 0.0f);
                    arregloGuardadoAR[3] = Guardar.getFloat("AR3" + 4, 0.0f);
                    arregloGuardadoLF[4] = Guardar.getFloat("AL4" + 5, 0.0f);
                    arregloGuardadoLL[4] = Guardar.getFloat("LL4" + 5, 0.0f);
                    arregloGuardadoAL[4] = Guardar.getFloat("AL4" + 5, 0.0f);
                    arregloGuardadoA4[4] = Guardar.getFloat("A44" + 5, 0.0f);
                    arregloGuardadoAR[4] = Guardar.getFloat("AR4" + 5, 0.0f);


                    PromAl = Arrays.stream(arregloGuardadoAL).average().orElse(Double.NaN);
                    PromLl = Arrays.stream(arregloGuardadoLL).average().orElse(Double.NaN);
                    PromLf = Arrays.stream(arregloGuardadoLF).average().orElse(Double.NaN);
                    PromA4 = Arrays.stream(arregloGuardadoA4).average().orElse(Double.NaN);
                    PromAr = Arrays.stream(arregloGuardadoAR).average().orElse(Double.NaN);
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "No se puede realizar un promedio si no están ingresados todos los datos." + DTLlote, Toast.LENGTH_SHORT).show();
                }
                AlertDialog.Builder alerta = new AlertDialog.Builder(RegidstrosGuardados.this);
                alerta.setMessage("Largo del lote: " + df.format(PromAl) + "\nAncho del lote: " + df.format(PromLf) + "\nLongitud de franja: " + df.format(PromLf) + "\nArmar lotes: " + df.format(PromAr) + "\nAvance en 4hrs: " + df.format(PromA4))
                        .setCancelable(false)
                        .setPositiveButton("Ok.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog Titulo = alerta.create();
                Titulo.setTitle("Promedio de todos los registros");
                Titulo.show();
            }
        });


        Check1 = (CheckBox) findViewById(R.id.check1);
        Check2 = (CheckBox) findViewById(R.id.check2);
        Check3 = (CheckBox) findViewById(R.id.check3);
        Check4 = (CheckBox) findViewById(R.id.check4);
        Check5 = (CheckBox) findViewById(R.id.check5);

        BotonVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle EnviarDT = new Bundle();
                Intent INDT = new Intent(RegidstrosGuardados.this, Medida.class);
                try {
                    if (Check1.isChecked() == true) {

                        arregloGuardadoLF[0] = Guardar.getFloat("AL0" + 1, 0.0f);
                        arregloGuardadoLL[0] = Guardar.getFloat("LL0" + 1, 0.0f);
                        arregloGuardadoAL[0] = Guardar.getFloat("AL0" + 1, 0.0f);
                        arregloGuardadoA4[0] = Guardar.getFloat("A40" + 1, 0.0f);
                        arregloGuardadoAR[0] = Guardar.getFloat("AR0" + 1, 0.0f);


                        EnviarDT.putDouble("LF", arregloGuardadoLF[0]);
                        EnviarDT.putDouble("LL", arregloGuardadoLL[0]);
                        EnviarDT.putDouble("AL", arregloGuardadoAL[0]);
                        EnviarDT.putDouble("A4", arregloGuardadoA4[0]);
                        EnviarDT.putDouble("AR", arregloGuardadoAR[0]);
                        INDT.putExtras(EnviarDT);
                        startActivity(INDT);
                    } else {
                        if (Check2.isChecked() == true) {
                            arregloGuardadoLF[1] = Guardar.getFloat("AL1" + 2, 0.0f);
                            arregloGuardadoLL[1] = Guardar.getFloat("LL1" + 2, 0.0f);
                            arregloGuardadoAL[1] = Guardar.getFloat("AL1" + 2, 0.0f);
                            arregloGuardadoA4[1] = Guardar.getFloat("A41" + 2, 0.0f);
                            arregloGuardadoAR[1] = Guardar.getFloat("AR1" + 2, 0.0f);


                            EnviarDT.putDouble("LF", arregloGuardadoLF[1]);
                            EnviarDT.putDouble("LL", arregloGuardadoLL[1]);
                            EnviarDT.putDouble("AL", arregloGuardadoAL[1]);
                            EnviarDT.putDouble("A4", arregloGuardadoA4[1]);
                            EnviarDT.putDouble("AR", arregloGuardadoAR[1]);
                            INDT.putExtras(EnviarDT);
                            startActivity(INDT);

                        } else {
                            if (Check3.isChecked() == true) {


                                arregloGuardadoLF[2] = Guardar.getFloat("AL2" + 3, 0.0f);
                                arregloGuardadoLL[2] = Guardar.getFloat("LL2" + 3, 0.0f);
                                arregloGuardadoAL[2] = Guardar.getFloat("AL2" + 3, 0.0f);
                                arregloGuardadoA4[2] = Guardar.getFloat("A42" + 3, 0.0f);
                                arregloGuardadoAR[2] = Guardar.getFloat("AR2" + 3, 0.0f);


                                EnviarDT.putDouble("LF", arregloGuardadoLF[2]);
                                EnviarDT.putDouble("LL", arregloGuardadoLL[2]);
                                EnviarDT.putDouble("AL", arregloGuardadoAL[2]);
                                EnviarDT.putDouble("A4", arregloGuardadoA4[2]);
                                EnviarDT.putDouble("AR", arregloGuardadoAR[2]);
                                INDT.putExtras(EnviarDT);
                                startActivity(INDT);
                            } else {
                                if (Check4.isChecked() == true) {


                                    arregloGuardadoLF[3] = Guardar.getFloat("AL3" + 4, 0.0f);
                                    arregloGuardadoLL[3] = Guardar.getFloat("LL3" + 4, 0.0f);
                                    arregloGuardadoAL[3] = Guardar.getFloat("AL3" + 4, 0.0f);
                                    arregloGuardadoA4[3] = Guardar.getFloat("A43" + 4, 0.0f);
                                    arregloGuardadoAR[3] = Guardar.getFloat("AR3" + 4, 0.0f);


                                    EnviarDT.putDouble("LF", arregloGuardadoLF[3]);
                                    EnviarDT.putDouble("LL", arregloGuardadoLL[3]);
                                    EnviarDT.putDouble("AL", arregloGuardadoAL[3]);
                                    EnviarDT.putDouble("A4", arregloGuardadoA4[3]);
                                    EnviarDT.putDouble("AR", arregloGuardadoAR[3]);
                                    INDT.putExtras(EnviarDT);
                                    startActivity(INDT);

                                } else {
                                    if (Check5.isChecked() == true) {


                                        arregloGuardadoLF[4] = Guardar.getFloat("AL4" + 5, 0.0f);
                                        arregloGuardadoLL[4] = Guardar.getFloat("LL4" + 5, 0.0f);
                                        arregloGuardadoAL[4] = Guardar.getFloat("AL4" + 5, 0.0f);
                                        arregloGuardadoA4[4] = Guardar.getFloat("A44" + 5, 0.0f);
                                        arregloGuardadoAR[4] = Guardar.getFloat("AR4" + 5, 0.0f);


                                        EnviarDT.putDouble("LF", arregloGuardadoLF[4]);
                                        EnviarDT.putDouble("LL", arregloGuardadoLL[4]);
                                        EnviarDT.putDouble("AL", arregloGuardadoAL[4]);
                                        EnviarDT.putDouble("A4", arregloGuardadoA4[4]);
                                        EnviarDT.putDouble("AR", arregloGuardadoAR[4]);
                                        INDT.putExtras(EnviarDT);
                                        startActivity(INDT);
                                    }
                                }
                            }
                        }
                    }


                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "No se puede realizar un promedio si no están ingresados todos los datos." + DTLlote, Toast.LENGTH_SHORT).show();

                }


            }
        });
        BotonRes = findViewById(R.id.BotonRes);
        BotonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Medida.RESULT_OK) {
                Double a = Double.valueOf(data.getStringExtra("LL"));
                Double e = Double.valueOf(data.getStringExtra("AL"));
                Double i = Double.valueOf(data.getStringExtra("A4"));
                Double o = Double.valueOf(data.getStringExtra("AR"));
                Double u = Double.valueOf(data.getStringExtra("LF"));





            }
        }

    }

}

