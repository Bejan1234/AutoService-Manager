package com.example.bejanionut_1085;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private ProgressBar progressLoading;
    private View statsContainer;
    private TextView txtNoData;
    private TextView txtTotalAppointments;
    private TextView txtAvgDuration;
    private LinearLayout listStatsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Statistici");
        }

        progressLoading = findViewById(R.id.progressLoading);
        statsContainer = findViewById(R.id.statsContainer);
        txtNoData = findViewById(R.id.txtNoData);
        txtTotalAppointments = findViewById(R.id.txtTotalAppointments);
        txtAvgDuration = findViewById(R.id.txtAvgDuration);
        listStatsContainer = findViewById(R.id.listStatsContainer);

        showLoading(true);

        // Simulate loading (e.g., from DB or network)
        new Handler(Looper.getMainLooper()).postDelayed(() -> loadData(), 700);
    }

    private void showLoading(boolean loading) {
        if (progressLoading != null) progressLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
        // keep statsContainer visibility controlled by loadData()
        if (txtNoData != null) txtNoData.setVisibility(View.GONE);
    }

    private void loadData() {
        // loading finished
        showLoading(false);
        // Placeholder dummy data
        int totalAppointments = 42;
        String avgDuration = "1h 15m";
        List<String> details = new ArrayList<>();
        details.add("Schimb ulei — 12");
        details.add("Frâne — 7");
        details.add("Service general — 23");

        if (details == null || details.isEmpty()) {
            if (progressLoading != null) progressLoading.setVisibility(View.GONE);
            if (txtNoData != null) {
                txtNoData.setVisibility(View.VISIBLE);
                txtNoData.setText(getString(R.string.no_results));
            }
            return;
        }

        if (txtTotalAppointments != null) txtTotalAppointments.setText(String.valueOf(totalAppointments));
        if (txtAvgDuration != null) txtAvgDuration.setText(avgDuration);

        // Populează containerul vertical cu rânduri simple
        if (listStatsContainer != null) {
            listStatsContainer.removeAllViews();
            for (String row : details) {
                TextView tv = new TextView(this);
                tv.setText(row);
                tv.setTextSize(15);
                tv.setPadding(0, 8, 0, 8);
                listStatsContainer.addView(tv);
            }
        }

        if (progressLoading != null) progressLoading.setVisibility(View.GONE);
        if (statsContainer != null) statsContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
