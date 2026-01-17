package com.example.bejanionut_1085;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bejanionut_1085.models.Programare;

public class DetaliiProgramareActivity extends AppCompatActivity {

    TextView textDetalii;
    Button btnStart;

    Programare programare;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_programare);

        textDetalii = findViewById(R.id.textDetalii);
        btnStart = findViewById(R.id.btnStartReparatie);

        // primim indexul programării
        index = getIntent().getIntExtra("index", -1);

        if (index != -1) {
            programare = com.example.bejanionut_1085.utils.ProgramareManager.programari.get(index);

            textDetalii.setText(
                    programare.getNumeClient() + "\n" +
                            programare.getMarcaMasina() + " - " +
                            programare.getNrInmatriculare() + "\n" +
                            "Data: " + programare.getDataProgramarii() + "\n" +
                            "Status: " + programare.getStatus()
            );
        }

        btnStart.setOnClickListener(v -> {

            new android.app.AlertDialog.Builder(DetaliiProgramareActivity.this)
                    .setTitle("Reparație finalizata")
                    .setMessage("Reparația a fost efectuată cu succes!")
                    .setPositiveButton("OK", (dialog, which) -> {

                        // Ștergem programarea din listă
                        com.example.bejanionut_1085.utils.ProgramareManager.programari.remove(index);

                        // Salvăm noua listă în JSON
                        com.example.bejanionut_1085.utils.ProgramareManager.saveToJSON(DetaliiProgramareActivity.this);

                        // Închidem activitatea
                        finish();

                    })
                    .setCancelable(false)
                    .show();
        });

    }
}
