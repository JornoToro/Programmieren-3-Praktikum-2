package src.Aufgabe2;

import java.util.Objects;

@SuppressWarnings("PMD.DataClass")

public class ElderlyPeople {
    
    public static final double MINDISTANCE = 0.01;
    
    public static final int MINAGE = 60;

    private final String name;

    private int age;

    private double longJumpDistance;
    
    public ElderlyPeople(String name, int age, double longJumpDistance) {
        this.name = Objects.requireNonNull(name);
        setAge(age);
        setLongJumpDistance(longJumpDistance);
    }
    public double getLongJumpDistance() {
        return longJumpDistance;
    }

    public void setLongJumpDistance(double longJumpDistance) {
        if(longJumpDistance < MINDISTANCE)
            throw new IllegalArgumentException("Der Sprung muss wenigstens 0.01 m sein");
        this.longJumpDistance = longJumpDistance;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age < MINAGE)
            throw new IllegalArgumentException("nur Personen mit 60 Jahren und aelter werden beruecksichtigt");
        this.age = age;
    }

    @Override public String toString() {
        return "ElderlyPeople{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", longJumpDistance=" + longJumpDistance +
               '}';
    }
}
