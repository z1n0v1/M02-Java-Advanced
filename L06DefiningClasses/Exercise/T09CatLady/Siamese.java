package L06DefiningClasses.Exercise.T09CatLady;

public class Siamese extends Cat {
    private Double earSize;

    public Siamese(String name, Double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public Double getEarSize() {
        return earSize;
    }

    public void setEarSize(Double earSize) {
        this.earSize = earSize;
    }

    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), earSize);
    }
}
