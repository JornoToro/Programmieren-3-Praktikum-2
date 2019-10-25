package test;

import src.aufgabe3.car.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * LicenceAdministrationTest
 */
public class LicenceAdministrationTest {

    @Test(expected = NullPointerException.class)
    public void ifCompleteRegisterNull() {
        LicenceAdministration administration = new LicenceAdministration();
        Map<String, Car> emptyMap = new HashMap<String, Car>();
        administration.register(emptyMap);
    }

    @Test
    public void ifCompleteRegisterSuccess() {
        LicenceAdministration administration = new LicenceAdministration();
        Map<String, Car> regCars = new HashMap<String, Car>();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Peter",Maker.Audi,1994);

        regCars.put("EI-HS 192", ein);
        regCars.put("EI-HS 111", zwei);

        administration.register(regCars);
        
        int size = administration.size();
        assertEquals(2, size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifSingleIsAlreadyRegist() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        administration.register("EI-HS 192", ein);
        administration.register("EI-BS 172", ein);
    }

    @Test
    public void ifSingleSuccess() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        administration.register("EI-HS 192", ein);
        int size = administration.size();
        assertEquals(1, size);
    }

    
    @Test
    public void getAllLicencesOfOwner() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Jonas",Maker.BMW,1993);
        administration.register("EI-HS 192", ein);
        administration.register("EI-HS 193", zwei);

        List<String> allLicencesOfOwner = new ArrayList<String>();
        allLicencesOfOwner = administration.getLicencesOfOwner("Jonas");


        int size = allLicencesOfOwner.size();
    
        assertEquals(2, size);
    }


    @Test
    public void getAllLicencesOlderThan() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Jonas",Maker.BMW,1993);
        administration.register("EI-HS 192", ein);
        administration.register("EI-HS 193", zwei);

        List<String> sortetListofAllPlatesBeforeYear = new ArrayList<String>();
        sortetListofAllPlatesBeforeYear = administration.getLicencesOlderThan(2000);


        int size = sortetListofAllPlatesBeforeYear.size();
    
        assertEquals(2, size);
    }

    @Test
    public void getAllLicencesOlderThanFalse() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Jonas",Maker.BMW,1993);
        administration.register("EI-HS 192", ein);
        administration.register("EI-HS 193", zwei);

        List<String> sortetListofAllPlatesBeforeYear = new ArrayList<String>();
        sortetListofAllPlatesBeforeYear = administration.getLicencesOlderThan(1900);


        int size = sortetListofAllPlatesBeforeYear.size();
    
        assertEquals(0, size);
    }

    @Test
    public void keepNewerThan() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Jonas",Maker.BMW,1993);
        administration.register("EI-HS 192", ein);
        administration.register("EI-HS 193", zwei);

        administration.keepLicenceNewerThan(1994);

        int size = administration.size();
    
        assertEquals(1, size);
    }

    @Test
    public void keepNewerThan2() {
        LicenceAdministration administration = new LicenceAdministration();
        Car ein = new Car("Jonas",Maker.Audi,1995);
        Car zwei = new Car("Jonas",Maker.BMW,1993);
        administration.register("EI-HS 192", ein);
        administration.register("EI-HS 193", zwei);

        administration.keepLicenceNewerThan(1990);

        int size = administration.size();
    
        assertEquals(2, size);
    }

    @Test
    public void validPlate() {
        LicenceAdministration administration = new LicenceAdministration();
        String plate = administration.requireValidLicencePlate("EI-HS 124");    
        assertEquals("EI-HS 124", plate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validPlateFalse() {
        LicenceAdministration administration = new LicenceAdministration();
        String plate = administration.requireValidLicencePlate("EI-HS YO");    
    }

    @Test(expected = IllegalArgumentException.class)
    public void validPlateRandom() {
        LicenceAdministration administration = new LicenceAdministration();
        String plate = administration.requireValidLicencePlate("asdasd 123");    
    }

    @Test(expected = IllegalArgumentException.class)
    public void validPlateNull() {
        LicenceAdministration administration = new LicenceAdministration();
        String plate = administration.requireValidLicencePlate("");    
    }
}