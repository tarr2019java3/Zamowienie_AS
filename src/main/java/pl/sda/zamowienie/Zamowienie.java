package pl.sda.zamowienie;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private List<Pozycja> elements = new ArrayList<>();
    //private Pozycja[] pozycje;
    private int ileDodanych;
    private int id;

    public List<Pozycja> getElements() {
        return elements;
    }

    private int maksRozmiar;

    public Zamowienie() {
        maksRozmiar = 10;
        ileDodanych = 0;
        //pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        ileDodanych = 0;
        //pozycje = new Pozycja[this.maksRozmiar];

    }

    public void dodajPozycje(Pozycja p){
        //pozycje[ileDodanych] = p;
        p.setId(ileDodanych+1);
        elements.add(p);
        //pozycje[ileDodanych].setId(ileDodanych+1);
        ++ileDodanych;
    }
    public void usunPozycje(int index){
        for (int x=0; x<ileDodanych; x++){
           int id = elements.get(x).getId();
           if (id == index){
             elements.remove(x);
             ileDodanych--;
             for (int y=0; y<ileDodanych;y++){
                 elements.get(y).setId(y+1);
             }
           }
        }
    }
    public void modyfikujPozycje(int index, String nazwaTowaru, int ileSztuk, double cena){
        for (int x=0; x<ileDodanych; x++){
            int id = elements.get(x).getId();
            if (id == index){
                elements.get(x).setNazwaTowaru(nazwaTowaru);
                elements.get(x).setIleSztuk(ileSztuk);
                elements.get(x).setCena(cena);
            }
        }
    }
    public void modyfikujPozycje(int index, String nazwaTowaru){
        for (int x=0; x<ileDodanych; x++){
            int id = elements.get(x).getId();
            if (id == index){
                elements.get(x).setNazwaTowaru(nazwaTowaru);
            }
        }
    }public void modyfikujPozycje(int index, int ileSztuk){
        for (int x=0; x<ileDodanych; x++){
            int id = elements.get(x).getId();
            if (id == index){
                elements.get(x).setIleSztuk(ileSztuk);
            }
        }
    }public void modyfikujPozycje(int index, double cena){
        for (int x=0; x<ileDodanych; x++){
            int id = elements.get(x).getId();
            if (id == index){
                elements.get(x).setCena(cena);
            }
        }
    }
    public double obliczWartosc(){
        double suma = 0;
        for (int x=0; x < ileDodanych; x++){
             suma += elements.get(x).obliczWartosc();
            //suma += pozycje[x].obliczWartosc();
        }
        return suma;
    }
    public double obliczRabat(){
        double suma = 0;
        for (int x=0; x < ileDodanych; x++){
            suma += elements.get(x).obliczRabat();
            //suma += pozycje[x].obliczWartosc();
        }
        return suma;
    }
    public void eksportJSON(){
        int x = 1;
        String filename = "Zamowienie_"+x+ ".json";
        x++;
        JSONUtils json = new JSONUtils();
        json.writeList(filename, getElements());
    }
    public void importJSON(int orderNumber){
        String filename = "Zamowienie_"+ orderNumber + ".json";
        System.out.println(filename);
        JSONUtils json = new JSONUtils();
        json.readList(filename);
    }
    public String toString(){
        String a,b,c,d;
        a = String.format("%-20s", "Nazwa Towaru");
        b = String.format("%12s", "Cena");
        c = String.format("%7s", "Sztuk");
        d = String.format("%13s", "Razem");
        System.out.println(a+b+c+d);
        for (int x=0; x<ileDodanych; x++){
            System.out.println(elements.get(x).toString());
            //System.out.println(pozycje[x].toString());
        }
        System.out.println(String.format("%41s", "Rabat: ")+String.format("%9.2f",obliczRabat()) + "zł");
        String result = (String.format("%41s" ,"Wartość zamówienia: ") + String.format("%9.2f", obliczWartosc()) + "zł");
        return result;
    }
}
