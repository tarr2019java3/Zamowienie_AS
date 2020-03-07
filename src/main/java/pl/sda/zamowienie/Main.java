package pl.sda.zamowienie;

public class Main {

    public static void main(String[] args) {
	    Pozycja order1 = new Pozycja("Daisy", 234, 2.33);
	    Pozycja order2 = new Pozycja("Dominika", 21, 100.11);
	    Pozycja order3 = new Pozycja("Adam", 14, 10.245655);
//        System.out.println(order1);
//        System.out.println(order2);
//        System.out.println(order3);
        Zamowienie z = new Zamowienie();
        z.dodajPozycje(order1);
        z.dodajPozycje(order2);
        z.dodajPozycje(order3);
//        System.out.println(z.toString());
//        System.out.println(String.format("%.2f",z.obliczWartosc()));
        z.eksportJSON();
        z.importJSON(1);
        z.usunPozycje(1);
        z.modyfikujPozycje(1,50.0);
        z.eksportJSON();
        z.importJSON(1);
    }
}
