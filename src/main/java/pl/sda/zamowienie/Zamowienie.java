package pl.sda.zamowienie;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private Pozycja[] pozycje;
    private int ileDodanych;
    private int maksRozmiar;

    public Zamowienie() {
        maksRozmiar = 10;
        ileDodanych = 0;
        pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        ileDodanych = 0;
        pozycje = new Pozycja[this.maksRozmiar];
    }

    public void dodajPozycje(Pozycja p){
        pozycje[ileDodanych] = p;
        ++ileDodanych;
    }
    public double obliczWartosc(){
        double suma = 0;
        for (int x=0; x <ileDodanych; x++){
            suma += pozycje[x].obliczWartosc();
        }
        return suma;
    }
    public String toString(){
        String a,b,c,d;
        a = String.format("%-20s", "Nazwa Towaru");
        b = String.format("%12s", "Cena");
        c = String.format("%7s", "Sztuk");
        d = String.format("%13s", "Razem");
        System.out.println(a+b+c+d);
        for (int x=0; x<ileDodanych; x++){
            System.out.println(pozycje[x].toString());
        }

        String result = (String.format("%41s" ,"Wartość zamówienia: ") + String.format("%9.2f", obliczWartosc()) + "zł");
        return result;
    }
}
