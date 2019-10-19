import java.util.Arrays;
import java.util.List;

/**
 * Aufgabe1
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("abra",  "", "ka", "da", "bra",  "", "simsala",  "bim");
        
        long count = strings.stream()
            .filter(low -> low.matches(""))
            .count();
        System.out.println(count);

        strings.stream()
            .filter(low -> low.length() > 1)
            .filter(low -> low.length() / 2 == 0);

        System.out.println(strings);
    }
}