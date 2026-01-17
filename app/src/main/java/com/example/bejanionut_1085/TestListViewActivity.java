package com.example.bejanionut_1085;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TestListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listview);

        listView = findViewById(R.id.listViewTest);

        String[] exemple = {
                "Reparatie frane",
                "Schimb ulei",
                "Verificare motor",
                "Diagnoza computer",
                "Schimb anvelope"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                exemple
        );

        listView.setAdapter(adapter);
    }
}
