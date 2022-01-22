package L06DefiningClasses.Exercise.T06PokemonTrainer;

public class Pokemon {
    String name;
    String element;
    Integer health;

    public Pokemon(String name, String element, Integer health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public Integer getHealth() {
        return health;
    }

    public boolean hit() {
        health -= 10;
        if (health <= 0)
            return true;
        return false;
    }
}
