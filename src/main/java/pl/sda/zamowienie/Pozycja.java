package pl.sda.zamowienie;

import java.util.Formatter;

public class Pozycja {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    public void setIleSztuk(int ileSztuk) {
        this.ileSztuk = ileSztuk;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public double obliczWartosc(){
        return ileSztuk*cena;
    }
    public String toString(){
        String a, b, c, d;
        a = String.format("%-20s", nazwaTowaru);
        b = String.format("%10.2f", cena);
        c = String.format("%4d", ileSztuk);
        d = String.format("%10.2f", obliczWartosc());
        String result = a+b+"zł" +c+ "szt."+d + "zł";
        return result ;
    }

}
