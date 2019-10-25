package src.aufgabe3.car;

import java.time.Year;
import java.util.Objects;


/**
 * Ein einfaches Auto.
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 */
public class Car {
    /** Fruehestes gueltiges Zulassungsjahr. */
    private static final int EARLIEST_BUILDING_YEAR = 1950;

    /** Eigentuemer eines Autos, nicht null, nicht leer. */
    private String owner;

    /** Hersteller eines Autos, nicht null. */
    private final Maker maker;

    /**
     * Baujahr des Autos, nicht vor EARLIEST_BUILDING_YEAR, nicht nach aktuellem
     * Jahr.
     */
    private final int buildingYear;

    /** Erzeugt ein neues Auto.
     * @param owner der Eigentuermer, nicht null.
     * @param maker der Herstelle, nicht null.
     * @param buildingYear ein gueltiges Baujahr.
     */
    public Car(String owner, Maker maker, int buildingYear) {
        //if(requireValidOwner(owner) != null && maker != null && requireValidBuildingYear(buildingYear) != 0){
         if(maker != null){
            this.owner = requireValidOwner(owner);
            this.maker = maker;
            this.buildingYear = requireValidBuildingYear(buildingYear);
        }else{
            this.owner = null;
            this.maker = null;
            this.buildingYear = 0;
        }
    }

    /**
     * Kopiert ein anderes Auto.
     * 
     * @param other ein anderes Auto.
     */
    public Car(Car other) {
        this.owner = other.getOwner();
        this.maker = other.getMaker();
        this.buildingYear = other.getBuildingYear();
    }

    public String getOwner() {
        return this.owner;
    }

    /**
     * Setzt den Eigentuemer des Autos.
     * 
     * @param owner der Eigentuemer des Autos, nicht null, nicht leer.
     */
    public void setOwner(String owner) {
        if(requireValidOwner(owner) != null){
            this.owner = owner;
        }

    }

    public Maker getMaker() {
        return this.maker;
    }

    public int getBuildingYear() {
        return this.buildingYear;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.owner);
        hash = 47 * hash + Objects.hashCode(this.maker);
        hash = 47 * hash + this.buildingYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
	
        final Car carobj = (Car)obj;
        return carobj.getOwner().equals(owner) && carobj.getMaker().equals(maker) && carobj.getBuildingYear() == buildingYear;
    }

    @Override
    public String toString() {
        return "Owner: " + this.owner + ", Maker: " + this.maker + ", BuildingYear: " + this.buildingYear;
    }

    /**
     * Ueberprueft das Herstellungsjahr auf gueltige Werte.
     * 
     * @param year das Herstellungsjahr, nicht vor EARLIEST_BUILDING_YEAR, nicht
     *             nach aktuellem Jahr.
     * @return ein gueltiges Herstellungsjahr.
     */
    public static int requireValidBuildingYear(int year) {
        final int actualYear = Year.now().getValue();
        System.out.println("actual year: " + actualYear);
        System.out.println("year: " + year);

        int backYear = 0;
        if(year >= EARLIEST_BUILDING_YEAR && year <= actualYear){
            backYear = year;
        }
        return backYear;
    }

    /**
     * Ueberprueft den Eigner des Autos auf einen gueltigen Wert.
     * 
     * @param string der Eigner des Autos, nicht null, nicht leer.
     * @return der gueltige Name des Eigners.
     */
    public static String requireValidOwner(String string) {
        String backString = null;
        if(string != null && string.length() > 2){
            backString = string;
        }
        return backString;
    }
}