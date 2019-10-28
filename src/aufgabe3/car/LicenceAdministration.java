package src.aufgabe3.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Verwaltungssoftware zur Zuordnung von Autokennzeichen auf einen Besitzer.
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 */
public class LicenceAdministration {
    /** Bildet Autokennzeichen auf das zugehoerige Fahrzeug ab. */
    private Map<String, Car> platesToCar = new HashMap<>();

    /**
     * Kopiert eine gesamte andere Autokennzeichenverwaltung, alle Zulassungen.
     * 
     * @param entries Abbildung von Autokennzeichen auf Autos.
     * @throw NullpointerException, falls entries null ist.
     */
    public void register(Map<String, Car> entries) {
        if (entries.isEmpty()) {
            throw new NullPointerException("entries cannot be null");
        } else {
            platesToCar = entries;
        }
    }

    /**
     * Fuegt einen neuen Eintrag in die Autokennzeichenverwaltung ein.
     *
     * @param licence ein gueltiges Autokennzeichen.
     * @param car     ein Auto.
     * @throw IllegalArgumentException, falls das Auto bereits registriert ist.
     */
    public void register(String licence, Car car) {
        Iterator<Entry<String, Car>> iterator = platesToCar.entrySet().iterator();
        if (platesToCar.isEmpty()) {
            platesToCar.put(licence, car);
        } else {
            while (iterator.hasNext()) {
                Map.Entry<String, Car> pair = (Map.Entry<String, Car>) iterator.next();
                if (pair.getValue() != null && !(pair.getValue().equals(car))) {
                    platesToCar.put(requireValidLicencePlate(licence), car);
                }
                if (pair.getValue().equals(car)) {
                    throw new IllegalArgumentException("car alread in");
                }
            }
        }
    }

    /**
     * Liefert die Anzahl der Zulassungen.
     *
     * @return Anzahl der Zulassungen.
     */
    public int size() {
        return platesToCar.size();
    }

    /**
     * Liefert eine unveraenderliche Sicht auf die Abbildung der Zulassungen.
     * 
     * @return unveraenderliche Sicht auf die Zulassungen.
     */
    Map<String, Car> getPlatesToCar() {
        return platesToCar;
    }

    /**
     * Liefert die unveraenderliche Menge aller Autokennzeichen.
     * 
     * @return die unveraenderliche Menge aller Autokennzeichen.
     */
    public Set<String> getLicencePlates() {
        Set<String> allPlates = new HashSet<String>();

        for (String key : platesToCar.keySet()) {
            allPlates.add(key);
        }

        return allPlates;
    }

    /**
     * Liefert fuer einen Besitzer (owner) eine Liste aller Autokennzeichen.
     * 
     * @param owner der Besitzer eines Autos, nicht null, nicht leer.
     * @return Liste aller autokennzeichen eines Besitzer.
     */
    public List<String> getLicencesOfOwner(String owner) {
        List<String> allLicences = new ArrayList<String>();

        if (owner != null) {
            allLicences = platesToCar.entrySet().stream().filter(x -> x.getValue().getOwner().equals(owner))
                    .map(map -> map.getKey()).collect(Collectors.toList());
        }
        return allLicences;
    }

    /**
     * Liefert eine sortierte Liste der Nummernschilder fuer Autos aelter als year.
     * 
     * @param beforeYear Jahresangabe.
     * @return sortierte Liste von Nummernschildern.
     */
    public List<String> getLicencesOlderThan(int beforeYear) {
        List<String> olderCars = new ArrayList<String>();

        if (beforeYear != 0) {
            olderCars = platesToCar.entrySet().stream().filter(x -> x.getValue().getBuildingYear() < beforeYear)
                    .map(map -> map.getKey()).sorted().collect(Collectors.toList());
        }
        return olderCars;
    }

    /**
     * Verschrottet ein Auto, dessen Erstellungsjahr vor einem bestimmten Jahr
     * liegt.
     * 
     * @param year ein Herstellungsjahr.
     */
    public void keepLicenceNewerThan(int year) {
        if (!platesToCar.isEmpty()) {
            platesToCar = platesToCar.entrySet().stream()
                .filter(x -> x.getValue()
                .getBuildingYear() > year)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
    }

    /**
     * Ueberprueft den String fuer ein Nummernschild auf einen korrekten Aufbau.
     * 
     * @param string ein Nummernschild.
     * @return ein korrektes Nummernschild
     * @throw IllegalArgumentException, falls das Nummernschild nicht den Regeln
     *        entspricht.
     */
    public static String requireValidLicencePlate(String string) {
        // EH-HS 321
        if (string != null && Pattern.matches("[A-Z][A-Z]-[A-Z][A-Z]\\s[1-9][1-9][1-9]", string)) {
            return string;
        } else {
            throw new IllegalArgumentException("no valid plate");
        }
    }

}
