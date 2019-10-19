
/**
 * Aufgabe1
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("abra",  "", "ka", "da", "bra",  "", "simsala",  "bim");
        
        int count = (Integer) strings.stream()
            .filter(low -> low.matches(""))
            .count();
        System.out.println(count);

    }
}