package com.example.clienteandroid.model;

public class Resposta {

    public int cord1;
    public int cord2;
    public int torn;
    public byte cap;
    public String resultat;
    public int guanyador;

    public Resposta(){

    }
    public Resposta(int torn, byte cap, int cord1, int cord2, String resultat){
        this.torn = torn;
        this.cap = cap;
        this.cord1 = cord1;
        this.cord2 = cord2;
        this.resultat = resultat;
    }
    public Resposta(byte cap, int cord1, int cord2, String resultat){
        this.cap = cap;
        this.cord1 = cord1;
        this.cord2 = cord2;
        this.resultat = resultat;
    }
    public Resposta(byte cap, int guanyador, int cord1, int cord2, String resultat){
        this.cap = cap;
        this.guanyador = guanyador;
        this.cord1 = cord1;
        this.cord2 = cord2;
        this.resultat = resultat;
    }
    public Resposta(byte cap, int guanyador, String resultat){
        this.cap = cap;
        this.guanyador = guanyador;
        this.resultat = resultat;
    }


    public int getTorn() {
        return torn;
    }

    public void setTorn(int torn) {
        this.torn = torn;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public int getCord1() {
        return cord1;
    }

    public void setCord1(int cord1) {
        this.cord1 = cord1;
    }

    public int getCord2() {
        return cord2;
    }

    public void setCord2(int cord2) {
        this.cord2 = cord2;
    }

    public byte getCap() {
        return cap;
    }

    public void setCap(byte cap) {
        this.cap = cap;
    }
}
