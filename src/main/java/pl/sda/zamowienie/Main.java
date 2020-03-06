package pl.sda.zamowienie;

public class Main {

    public static void main(String[] args) {
	    Pozycja order1 = new Pozycja("Daisy", 234, 2.33);
	    Pozycja order2 = new Pozycja("Dominika", 1, 100.11);
	    Pozycja order3 = new Pozycja("Adam", 1, 10.245655);
//        System.out.println(order1);
//        System.out.println(order2);
//        System.out.println(order3);
        Zamowienie z = new Zamowienie();
        z.dodajPozycje(order1);
        z.dodajPozycje(order2);
        z.dodajPozycje(order3);
        System.out.println(z.toString());
        System.out.println(String.format("%.2f",z.obliczWartosc()));
    }
}
