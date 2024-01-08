package com.example.franjeo_de_forraje_en_finca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class Result extends AppCompatActivity {


    public double dcs, cont, cont2, Avance4, L_Franja, DTLlote, DTAlote, ArmL;
    Button BotonVolver, Volver, BotonGuardarDT;
    TextView Cargas_S_Tolera, Armar_Tolerar, LFranja_SINCerca, Metros_Diario_4H, M2, VT2;

    public double Dato(double DatoDCS, double DatoLF, double DatoAR, double DatoA4) {

        /**Toast.makeText(getBaseContext(), "malp"+DatoDCS, Toast.LENGTH_SHORT).show();
         Toast.makeText(getBaseContext(), "malp"+DatoLF, Toast.LENGTH_SHORT).show();
         Toast.makeText(getBaseContext(), "malp"+DatoAR, Toast.LENGTH_SHORT).show();
         Toast.makeText(getBaseContext(), "malp"+DatoA4, Toast.LENGTH_SHORT).show();**/

        BotonGuardarDT = findViewById(R.id.BotonGuardarDT);
        BotonGuardarDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle Recibir = getIntent().getExtras();
                cont = Recibir.getDouble("cont3");
                Intent INDT = new Intent(Result.this, RegidstrosGuardados.class);
                Bundle EnviarDT = new Bundle();


                if (cont > 5) {
                    Toast.makeText(getBaseContext(), "límite de registros alcanzados.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), "Límite de registros 5.", Toast.LENGTH_SHORT).show();
                    startActivity(INDT);
                } else {

                    EnviarDT.putDouble("ArmL", DatoAR);
                    EnviarDT.putDouble("Avance4", DatoA4);
                    EnviarDT.putDouble("DTAlote", DTAlote);
                    EnviarDT.putDouble("DTLlote", DTLlote);
                    EnviarDT.putDouble("L_Fanja", DatoLF);


                    EnviarDT.putDouble("cont", cont);
                    Toast.makeText(getBaseContext(), "Registro " + cont + " guardado.", Toast.LENGTH_SHORT).show();
                    INDT.putExtras(EnviarDT);
                    startActivity(INDT);
                }


            }
        });
        return DatoDCS;
    }



    /////////////////////////////////////////////////////////////////////////////////////////////


    //


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        Bundle EnviarDT = new Bundle();
        Bundle Recibir = getIntent().getExtras();
        cont = Recibir.getDouble("cont3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Toast.makeText(getBaseContext(), "" + cont2, Toast.LENGTH_SHORT).show();
        //TextVieW
        M2 = findViewById(R.id.M2);
        Cargas_S_Tolera = findViewById(R.id.Cargas_S_Tolera);
        Armar_Tolerar = findViewById(R.id.Armar_Tolerar);
        LFranja_SINCerca = findViewById(R.id.LFranja_SINCerca);
        Metros_Diario_4H = findViewById(R.id.Metros_Diario_4H);
        VT2 = findViewById(R.id.VT);

        //Buttons
        Volver = findViewById(R.id.Volver);

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BotonVolver = findViewById(R.id.BotonVolver);


        BotonVolver.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View view) {
                                               Bundle EnviarDT = new Bundle();
                                               Bundle EnviarDTM = new Bundle();
                                               Intent INDT = new Intent(Result.this, MainActivity.class);
                                               Intent INDTM = new Intent(Result.this, MainActivity.class);
                                               EnviarDT.putDouble("cont", cont);
                                               EnviarDTM.putDouble("cont", cont);
                                               INDTM.putExtras(EnviarDT);
                                               INDT.putExtras(EnviarDT);
                                               startActivity(INDT);
                                           }
                                       }
        );
        DecimalFormat df = new DecimalFormat("#.00");


        double DTFV = Recibir.getDouble("DTFV");
        DTLlote = Recibir.getDouble("DTLlote");
        DTAlote = Recibir.getDouble("DTAlote");
        double DTWAnimal = Recibir.getDouble("DTWanimal");
        double DTNumAnimales = Recibir.getDouble("DTNumAnimales");
        double DTCercaElectrica = 1;

        double CVFV_ANIMAL = (DTWAnimal) * 0.125;
        double CONSTOTFV_Dia = CVFV_ANIMAL * DTNumAnimales;
        double M2_Dia = CONSTOTFV_Dia * DTCercaElectrica / DTFV;
        double Relacion = DTAlote / (Math.sqrt(M2_Dia));
        L_Franja = (Math.sqrt(M2_Dia)) / Relacion;
        double Dato_1 = DTFV * (DTLlote * DTAlote);
        double Dato_2 = DTNumAnimales * Dato_1;
        double Dias_Carga = Dato_1 / CONSTOTFV_Dia;

        dcs = Dias_Carga - (Dias_Carga * 0.2);
        boolean Si = false;
        double DTFranjas = 55 / dcs;


        ArmL = (DTLlote / dcs);
        Avance4 = ArmL / 3;
        // Importar resultados
        Dato(dcs, L_Franja, ArmL, Avance4);

        M2.setText("Datos ingresados: \nFV/M2:" + DTFV + "WAnimales:" + DTWAnimal + "\nNumero de Animales:" + DTNumAnimales + "\nLargo del lote:" + DTLlote + "\nAncho del lote:" + DTAlote + "\nCerca Electrica:" + DTCercaElectrica + "\nFranjas:" + DTFranjas);
        VT2.setText("CVFT/Animal:" + CVFV_ANIMAL + "ConstoFV/Dia:" + CONSTOTFV_Dia + "\nDias de Carga:" + Dias_Carga + "\nFranjas\nM2/Dia:" + M2_Dia + "\nRelacion:" + Relacion + "\nLongitud de franja:" + L_Franja);
        if (DTCercaElectrica <= 0.5) {

            Cargas_S_Tolera.setText("Días de carga que soporta:\n " +(Math.round(dcs))+" dias");
        } else {

            Cargas_S_Tolera.setText("Días que puede tolerar:\n " + (Math.round(dcs))+" dias");
        }
        if (DTCercaElectrica >= 0.5) {

            if (DTCercaElectrica > 0.09) {
                LFranja_SINCerca.setText("Longitud de franja:\n" + df.format(Math.round(L_Franja))+" mtrs^2");
            } else {
                L_Franja = 0.0;
                LFranja_SINCerca.setText("Longitud de franja:\n" + df.format(Math.round(L_Franja))+" mtrs^2");
                Si = true;
            }
        } else {
            LFranja_SINCerca.setText("Sin cerca eléctrica no hay avance.");
            Si = false;
        }
        Metros_Diario_4H.setText("Metros de avance diario:\n" + (Math.round(ArmL)) +" mtrs^2"+ "\nAvance en metros cada 4 horas:\n" + df.format((ArmL / 3))+" mtrs^2");

        //Revisar a detalle con pruebas de escritorio:
        if (DTCercaElectrica >= 0.5) {


            if (DTLlote < 100.5) {

                Armar_Tolerar.setText("Armar lotes de:\n " + df.format((ArmL))+" mtrs^2");
            } else {
                if (DTCercaElectrica < 0.5) {
                }
                Armar_Tolerar.setText("Puede tolerar:\n " + Si);
            }
        } else {
            Armar_Tolerar.setText("Armar lotes de:" + Si);
        }
        DTFranjas = 55 / dcs;


    }
}
