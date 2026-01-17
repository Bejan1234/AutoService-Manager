package com.example.bejanionut_1085;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bejanionut_1085.utils.ProgramareManager;

public class ListProgramariActivity extends AppCompatActivity {

    RecyclerView recyclerProgramari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_programari);

        recyclerProgramari = findViewById(R.id.recyclerProgramari);

        // încarcă datele din JSON
        ProgramareManager.loadFromJSON(this);

        ProgramareAdapter adapter = new ProgramareAdapter(ProgramareManager.programari);

        recyclerProgramari.setLayoutManager(new LinearLayoutManager(this));
        recyclerProgramari.setAdapter(adapter);
    }
}
