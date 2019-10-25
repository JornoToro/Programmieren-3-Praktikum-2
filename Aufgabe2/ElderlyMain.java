package Aufgabe2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//CHECKSTYLE:OFF MagicNumber
/**Hauptklasse zur Verarbeitung aelterer Menschen mit Weitsprungergebnissen.
 * Aufgabenblatt2 Lambdas, Streams WS 2109/20
 * @author G. Schiedermeier, gschied@haw-landshut.de
 * @version 2019-10-13
 */
public class ElderlyMain {
    public static List<ElderlyPeople> getOlderSeventy (List<ElderlyPeople> elderly){
        elderly = elderly.stream()
            .filter(k -> k.getAge() > 70 && k.getLongJumpDistance() > 1.5)
            .collect(Collectors.toList());
        return elderly;
    }

    public static void main(String... args) {

    List<ElderlyPeople> elderly = new ArrayList<>();

    elderly.add(new ElderlyPeople("Hubert", 83, 1.25));
    elderly.add(new ElderlyPeople("Maria", 79, 1.11));
    elderly.add(new ElderlyPeople("Alois", 95, 1.65));
    elderly.add(new ElderlyPeople("Josefine", 76, 2.01));

    List<ElderlyPeople> olderSeventyelderlys = new ArrayList<>();
    olderSeventyelderlys = getOlderSeventy(elderly);

    System.out.println(olderSeventyelderlys);
    }

}

