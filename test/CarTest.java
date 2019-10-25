package test;

import src.aufgabe3.car.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CarTest
 */
public class CarTest {

    @Test
    public void buildYearMethodCorrect() {
        Car ein = new Car("Jonas",Maker.Audi,1995);
        int x = ein.requireValidBuildingYear(ein.getBuildingYear());
        assertEquals(1995, x);
    }

    @Test
    public void buildYearMethodUnder() {
        Car ein = new Car("Jonas",Maker.Audi,1949);
        int x = ein.requireValidBuildingYear(ein.getBuildingYear());
        assertEquals(0, x);
    }

    @Test
    public void buildYearMethodUpper() {
        Car ein = new Car("Jonas",Maker.Audi,2020);
        int x = ein.requireValidBuildingYear(ein.getBuildingYear());
        assertEquals(0, x);
    }

    @Test
    public void setOwenerCorrect() {
        Car ein = new Car("Jonas",Maker.Audi,2020);
        ein.setOwner("Peter");
        assertEquals("Peter", ein.getOwner());
    }

    @Test
    public void setOwenerNull() {
        Car ein = new Car("Jonas",Maker.Audi,2020);
        ein.setOwner(null);
        assertEquals("Jonas", ein.getOwner());
    }

    @Test
    public void setOwenerEmpty() {
        Car ein = new Car("Jonas",Maker.Audi,2020);
        ein.setOwner("");
        assertEquals("Jonas", ein.getOwner());
    }
    
}