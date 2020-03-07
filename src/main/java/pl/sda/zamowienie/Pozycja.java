package pl.sda.zamowienie;

import java.util.Formatter;

public class Pozycja {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;
    private int id;

    public Pozycja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double obliczWartosc(){
        return ileSztuk*cena;
    }
    public double obliczRabat(){
        double val = obliczWartosc();
        if (ileSztuk<5){
            return val;
        }else if (ileSztuk>=5 & ileSztuk<=10){
            double rabat = val*0.05;
            return  rabat;
        }else if (ileSztuk>=11 & ileSztuk<=20){
            double rabat = val*0.1;
            return  rabat;
        }else if (ileSztuk>20){
            double rabat = val*0.15;
            return  rabat;
        }
        return 0;
    }
    public double obliczWartoscZRabatem(){
        double val = obliczWartosc();
        if (ileSztuk<5){
            return val;
        }else if (ileSztuk>=5 & ileSztuk<=10){
            double rabat = val*0.05;
            return  val-rabat;
        }else if (ileSztuk>=11 & ileSztuk<=20){
            double rabat = val*0.1;
            return  val-rabat;
        }else if (ileSztuk>20){
            double rabat = val*0.15;
            return  val-rabat;
        }
        return 0;
    }

    public String toString(){
        String a, b, c, d, i;
        i = String.format("-3d", id);
        a = String.format("%-20s", nazwaTowaru);
        b = String.format("%10.2f", cena);
        c = String.format("%4d", ileSztuk);
        d = String.format("%10.2f", obliczWartosc());
        String result = id+a+b+"zł" +c+ "szt."+d + "zł";
        return result ;
    }

}
