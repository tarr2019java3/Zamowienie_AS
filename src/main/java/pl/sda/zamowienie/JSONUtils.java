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
            String a,b,c,d;
            double suma = 0;
            for (int x = 0; x < elements.length; x++) {
                a = String.format("%-20s", elements[x].getNazwaTowaru());
                b = String.format("%10.2f", elements[x].getCena());
                c = String.format("%6d", elements[x].getIleSztuk());
                d = String.format("%10.2f", elements[x].obliczWartosc());
                suma += elements[x].obliczWartosc();
                System.out.println(a+b+"zł"+c+"szt."+d+"zł");
            }
            System.out.println((String.format("%43s" ,"Wartość zamówienia: ") + String.format("%9.2f", suma) + "zł"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

