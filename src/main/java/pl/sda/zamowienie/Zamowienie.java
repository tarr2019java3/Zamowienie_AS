package pl.sda.zamowienie;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private Pozycja[] pozycje;
    private int ileDodanych = 0;
    private int maksRozmiar;

    public Zamowienie() {
        maksRozmiar = 10;
        pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        pozycje = new Pozycja[this.maksRozmiar];
    }

    public void dodajPozycje(Pozycja p){
        pozycje[ileDodanych] = p;
        ileDodanych++;
    }
    public double obliczWartosc(){
        double suma = 0;
        for (int x=0; x <ileDodanych; x++){
            suma += pozycje[x].obliczWartosc();
        }
        return suma;
    }
    public String toString(){
        String result = " ";  
        return result;
    }
}
