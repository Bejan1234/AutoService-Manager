package com.example.bejanionut_1085.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHelper {

    public static void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter os = new OutputStreamWriter(
                    context.openFileOutput("programari.json", Context.MODE_PRIVATE));
            os.write(data);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(Context context) {
        StringBuilder content = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.openFileInput("programari.json"))
            );

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }

            br.close();

        } catch (Exception e) {
            return "";
        }

        return content.toString();
    }
}
