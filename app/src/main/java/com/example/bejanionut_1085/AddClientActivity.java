package com.example.bejanionut_1085;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bejanionut_1085.models.Programare;
import com.example.bejanionut_1085.utils.ProgramareManager;

public class AddClientActivity extends AppCompatActivity {

    EditText etNume, etTelefon, etMarca, etNumar;
    Spinner spinnerReparatie;
    DatePicker datePicker;
    Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        etNume = findViewById(R.id.etNume);
        etTelefon = findViewById(R.id.etTelefon);
        etMarca = findViewById(R.id.etMarca);
        etNumar = findViewById(R.id.etNumar);
        spinnerReparatie = findViewById(R.id.spinnerReparatie);
        datePicker = findViewById(R.id.datePicker);
        btnSalveaza = findViewById(R.id.btnSalveaza);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tip_reparatii,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReparatie.setAdapter(adapter);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nume = etNume.getText().toString();
                String tel = etTelefon.getText().toString();
                String marca = etMarca.getText().toString();
                String nr = etNumar.getText().toString();
                String tip = spinnerReparatie.getSelectedItem().toString();

                int zi = datePicker.getDayOfMonth();
                int luna = datePicker.getMonth() + 1;
                int an = datePicker.getYear();

                String data = zi + "/" + luna + "/" + an;

                if (nume.isEmpty() || tel.isEmpty()) {
                    Toast.makeText(AddClientActivity.this,
                            "Completeaza toate campurile!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Programare p = new Programare(
                        nume, tel, marca, nr, tip, data, "in asteptare"
                );

                ProgramareManager.addProgramare(p);
                ProgramareManager.saveToJSON(AddClientActivity.this);

                Toast.makeText(AddClientActivity.this,
                        "Programare salvata!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
