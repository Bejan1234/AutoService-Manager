package com.example.bejanionut_1085.utils;

import android.content.Context;

import com.example.bejanionut_1085.models.Programare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProgramareManager {

    public static ArrayList<Programare> programari = new ArrayList<>();

    public static void addProgramare(Programare p) {
        programari.add(p);
    }

    public static void removeProgramare(int index) {
        programari.remove(index);
    }

    public static void saveToJSON(Context ctx) {
        JSONArray array = new JSONArray();

        for (Programare p : programari) {
            JSONObject obj = new JSONObject();
            try {
                obj.put("numeClient", p.getNumeClient());
                obj.put("telefon", p.getTelefon());
                obj.put("marcaMasina", p.getMarcaMasina());
                obj.put("nrInmatriculare", p.getNrInmatriculare());
                obj.put("tipReparatie", p.getTipReparatie());
                obj.put("dataProgramarii", p.getDataProgramarii());
                obj.put("status", p.getStatus());
            } catch (JSONException e) { e.printStackTrace(); }

            array.put(obj);
        }

        FileHelper.writeToFile(array.toString(), ctx);
    }

    public static void loadFromJSON(Context ctx) {
        programari.clear();

        String json = FileHelper.readFromFile(ctx);
        if (json.isEmpty()) return;

        try {
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject o = array.getJSONObject(i);

                Programare p = new Programare(
                        o.getString("numeClient"),
                        o.getString("telefon"),
                        o.getString("marcaMasina"),
                        o.getString("nrInmatriculare"),
                        o.getString("tipReparatie"),
                        o.getString("dataProgramarii"),
                        o.getString("status")
                );

                programari.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
