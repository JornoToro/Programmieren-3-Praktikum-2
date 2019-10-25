import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
    }
}