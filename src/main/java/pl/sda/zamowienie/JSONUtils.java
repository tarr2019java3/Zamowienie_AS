package pl.sda.zamowienie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtils {

    public void writeList(String filename, List<Pozycja> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readList(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filename);
        try {
            Pozycja[] elements = mapper.readValue(file, Pozycja[].class);
            String a,b,c,d,i;
            double suma = 0;
            double rabat = 0;
            for (int x = 0; x < elements.length; x++) {
                i = String.format("%2d", elements[x].getId());
                a = String.format("%-20s", elements[x].getNazwaTowaru());
                b = String.format("%10.2f", elements[x].getCena());
                c = String.format("%6d", elements[x].getIleSztuk());
                d = String.format("%10.2f", elements[x].obliczWartosc());
                suma += elements[x].obliczWartoscZRabatem();
                rabat += elements[x].obliczRabat();
                System.out.println(i+". "+a+b+"zł"+c+"szt."+d+"zł");
            }
            System.out.println(String.format("%47s", "Rabat: ")+String.format("%9.2f", rabat) + "zł");
            System.out.println((String.format("%47s" ,"Wartość zamówienia: ") + String.format("%9.2f", suma) + "zł"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

