package L06DefiningClasses.Exercise.T07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        company = null;
        car = null;
        parents = new ArrayList<>();
        children = new ArrayList<>();
        pokemons = new ArrayList<>();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(String.format("%s%n", name));
        string.append(String.format("Company:%n"));
        if (company != null)
            string.append(String.format("%s%n", company));
        string.append(String.format("Car:%n"));
        if (car != null)
            string.append(String.format("%s%n", car));
        string.append(String.format("Pokemon:%n"));
        for (Pokemon pokemon : pokemons)
            string.append(String.format("%s%n", pokemon));
        string.append(String.format("Parents:%n"));
        for (Parent parent : parents)
            string.append(String.format("%s%n", parent));
        string.append(String.format("Children:%n"));
        for (Child child : children)
            string.append(String.format("%s%n", child));
        return string.toString();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public void addChild(Child child) {
        children.add(child);
    }

}

