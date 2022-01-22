package L06DefiningClasses.Exercise.T09CatLady;

public class StreetExtraordinaire extends Cat {
    Double decibelsOfMeows;

    public StreetExtraordinaire(String name, Double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public Double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(Double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.getName(), decibelsOfMeows);
    }
}
