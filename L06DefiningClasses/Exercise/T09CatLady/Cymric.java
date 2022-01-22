package L06DefiningClasses.Exercise.T09CatLady;

public class Cymric extends Cat {
    private Double furLength;

    public Cymric(String name, Double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public Double getFurLength() {
        return furLength;
    }

    public void setFurLength(Double furLength) {
        this.furLength = furLength;
    }

    public String toString() {
        return String.format("Cymric %s %.2f", super.getName(), furLength);
    }
}
