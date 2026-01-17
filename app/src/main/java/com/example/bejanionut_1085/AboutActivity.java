package com.example.bejanionut_1085;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private TextView txtAboutTitle;
    private TextView txtAboutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.about_title));
        }

        txtAboutTitle = findViewById(R.id.txtAboutTitle);
        txtAboutContent = findViewById(R.id.txtAboutContent);

        txtAboutTitle.setText(getString(R.string.about_title));
        txtAboutContent.setText(getString(R.string.about_content));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

