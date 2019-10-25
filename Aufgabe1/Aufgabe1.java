package Aufgabe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Aufgabe1
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("abra",  "", "ka", "da", "bra",  "", "simsala",  "bim");
        
        long count = strings.stream()
            .filter(low -> low.matches(""))
            .count();

        List<String> result = strings.stream()
            .filter(low -> low.length() % 2 == 0 && low.length() > 1)
            .collect(Collectors.toList());

        System.out.println(count + " " + result);

        //////////////////////////////////////////////////////////
        
        List<Double> randomNumbers = new ArrayList<Double>();
         for(int i = 0; i < 10; i++){
            randomNumbers.add(Math.random());
        }

        randomNumbers = randomNumbers.stream()
            .map(k->k*=100)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Randoms: " + randomNumbers);

        /* 
        !Geht nur für Ints?!
        List<Integer> randomNumbers2 = new ArrayList<Integer>();
        randomNumbers2 = Stream
            .iterate(0, n -> n + 1)
            .limit(10)
            .map(k-> k = (int)(Math.random()*100))
            .sorted().
            collect(Collectors.toList());

        System.out.println(randomNumbers2); 
        */
    }
}