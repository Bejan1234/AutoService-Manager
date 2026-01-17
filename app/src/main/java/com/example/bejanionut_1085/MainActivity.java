package com.example.bejanionut_1085;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "app_prefs";
    private static final String PREF_DARK_MODE = "pref_dark_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Aplică tema preferată înainte de setContentView
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean dark = prefs.getBoolean(PREF_DARK_MODE, false);
        AppCompatDelegate.setDefaultNightMode(dark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fabSupport);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSupportDialog();
            }
        });

        // Initializează switch-ul Dark Mode și listener (folosim SwitchCompat)
        SwitchCompat switchDark = findViewById(R.id.switchDarkMode);
        if (switchDark != null) {
            switchDark.setChecked(dark);
            switchDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Aplică tema și salvează preferința
                    AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putBoolean(PREF_DARK_MODE, isChecked);
                    editor.apply();
                    // Recreate activity so theme is applied immediately
                    recreate();
                }
            });
        }


    }
    private void showSupportDialog() {

        String message = "Ai nevoie de ajutor?\n\n" +
                "📧 Email: ingo23@gmail.com\n" +
                "📞 Telefon: 07xx xxx xxx\n" +
                "🛠️ Suport tehnic disponibil 24/7\n";

        new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this)
                .setTitle("Suport & Contact")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .setIcon(android.R.drawable.ic_menu_help)
                .show();
    }


    public void openAddClient(View view) {
        Intent intent = new Intent(MainActivity.this, AddClientActivity.class);
        startActivity(intent);
    }

    public void openList(View view) {
        Intent intent = new Intent(MainActivity.this, ListProgramariActivity.class);
        startActivity(intent);
    }

    public void openStats(View view) {
        // Open the new StatisticsActivity
        Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void openAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
    public void openTestListView(View view) {
        Intent intent = new Intent(MainActivity.this, TestListViewActivity.class);
        startActivity(intent);
    }


}
