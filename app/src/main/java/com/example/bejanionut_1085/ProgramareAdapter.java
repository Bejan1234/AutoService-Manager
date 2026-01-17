package com.example.bejanionut_1085;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bejanionut_1085.models.Programare;

import java.util.ArrayList;

public class ProgramareAdapter extends RecyclerView.Adapter<ProgramareAdapter.ProgramareViewHolder> {

    private ArrayList<Programare> list;

    public ProgramareAdapter(ArrayList<Programare> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProgramareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_programare, parent, false);
        return new ProgramareViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramareViewHolder holder, int position) {
        Programare p = list.get(position);

        holder.txtNume.setText(p.getNumeClient());
        holder.txtDetalii.setText(
                p.getMarcaMasina() + " • " +
                        p.getNrInmatriculare() + " • " +
                        p.getDataProgramarii()
        );
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetaliiProgramareActivity.class);
            intent.putExtra("index", holder.getAdapterPosition());
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProgramareViewHolder extends RecyclerView.ViewHolder {
        TextView txtNume, txtDetalii;

        public ProgramareViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNume = itemView.findViewById(R.id.txtNume);
            txtDetalii = itemView.findViewById(R.id.txtDetalii);
        }
    }
}
