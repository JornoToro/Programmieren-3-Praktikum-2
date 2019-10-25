package test;

import src.aufgabe2.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ElderMainTest
 */
public class ElderMainTest {

    @Test
    public void olderSeventyTwo() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 83, 1.25));
        elderly.add(new ElderlyPeople("Maria", 79, 1.11));
        elderly.add(new ElderlyPeople("Alois", 95, 1.65));
        elderly.add(new ElderlyPeople("Josefine", 76, 2.01));        
        
        List<ElderlyPeople> olderSeventyelderlys = new ArrayList<>();
        olderSeventyelderlys = ElderlyMain.getOlderSeventy(elderly);
        int x = olderSeventyelderlys.size();
        assertEquals(2, x);
    }

    @Test
    public void olderSeventyThree() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 83, 1.25));
        elderly.add(new ElderlyPeople("Maria", 79, 1.51));
        elderly.add(new ElderlyPeople("Alois", 95, 1.65));
        elderly.add(new ElderlyPeople("Josefine", 76, 2.01));        
        
        List<ElderlyPeople> olderSeventyelderlys = new ArrayList<>();
        olderSeventyelderlys = ElderlyMain.getOlderSeventy(elderly);
        int x = olderSeventyelderlys.size();
        assertEquals(3, x);
    }

    @Test(expected = IllegalArgumentException.class)
    public void olderSeventyEmpty() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 50, 1.25));
        elderly.add(new ElderlyPeople("Maria", 30, 1.11));
        elderly.add(new ElderlyPeople("Alois", 20, 1.65));
        elderly.add(new ElderlyPeople("Josefine", 10, 2.01));        
        
        ElderlyMain.getOlderSeventy(elderly);
    }

    @Test
    public void olderSeventyEmpty2() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 82, 1.25));
        elderly.add(new ElderlyPeople("Maria", 90, 1.11));
        elderly.add(new ElderlyPeople("Alois", 74, 1.35));
        elderly.add(new ElderlyPeople("Josefine", 98, 1.01));        
        
        List<ElderlyPeople> olderSeventyelderlys = new ArrayList<>();
        olderSeventyelderlys = ElderlyMain.getOlderSeventy(elderly);
        int x = olderSeventyelderlys.size();
        assertEquals(0, x);
    }

    @Test(expected = IllegalArgumentException.class)
    public void distanceHopper() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 82, 1.25));
        elderly.add(new ElderlyPeople("Maria", 90, 1.11));
        elderly.add(new ElderlyPeople("Alois", 74, 1.35));
        elderly.add(new ElderlyPeople("Josefine", 98, 1.01));        
        
        ElderlyMain.getBestLongDistanceHopper(elderly);
    }

    @Test
    public void distanceHopper2() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 83, 1.25));
        elderly.add(new ElderlyPeople("Maria", 79, 1.11));
        elderly.add(new ElderlyPeople("Alois", 95, 1.65));
        elderly.add(new ElderlyPeople("Josefine", 76, 2.01));        
        
        ElderlyPeople bestHopper = ElderlyMain.getBestLongDistanceHopper(elderly);
        String name = bestHopper.getName();
        assertEquals("Josefine", name);
    }

    @Test
    public void distanceHopper3() {
        List<ElderlyPeople> elderly = new ArrayList<>();
        elderly.add(new ElderlyPeople("Hubert", 83, 1.25));
        elderly.add(new ElderlyPeople("Maria", 79, 1.11));
        elderly.add(new ElderlyPeople("Alois", 95, 3.65));
        elderly.add(new ElderlyPeople("Josefine", 76, 2.01));        
        
        ElderlyPeople bestHopper = ElderlyMain.getBestLongDistanceHopper(elderly);
        String name = bestHopper.getName();
        assertEquals("Alois", name);
    }
}