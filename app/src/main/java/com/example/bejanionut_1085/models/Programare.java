package com.example.bejanionut_1085.models;

public class Programare {
    private int id;
    private String numeClient;
    private String telefon;
    private String marcaMasina;
    private String nrInmatriculare;
    private String tipReparatie;
    private String dataProgramarii;
    private String status;

    public Programare() {}

    public Programare(String numeClient, String telefon, String marcaMasina,
                      String nrInmatriculare, String tipReparatie, String dataProgramarii,
                      String status) {
        this.numeClient = numeClient;
        this.telefon = telefon;
        this.marcaMasina = marcaMasina;
        this.nrInmatriculare = nrInmatriculare;
        this.tipReparatie = tipReparatie;
        this.dataProgramarii = dataProgramarii;
        this.status = status;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumeClient() { return numeClient; }
    public void setNumeClient(String numeClient) { this.numeClient = numeClient; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getMarcaMasina() { return marcaMasina; }
    public void setMarcaMasina(String marcaMasina) { this.marcaMasina = marcaMasina; }

    public String getNrInmatriculare() { return nrInmatriculare; }
    public void setNrInmatriculare(String nrInmatriculare) { this.nrInmatriculare = nrInmatriculare; }

    public String getTipReparatie() { return tipReparatie; }
    public void setTipReparatie(String tipReparatie) { this.tipReparatie = tipReparatie; }

    public String getDataProgramarii() { return dataProgramarii; }
    public void setDataProgramarii(String dataProgramarii) { this.dataProgramarii = dataProgramarii; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return numeClient + " - " + marcaMasina + " - " + dataProgramarii;
    }
}
