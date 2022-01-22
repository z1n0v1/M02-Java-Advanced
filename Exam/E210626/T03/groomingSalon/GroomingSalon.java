package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(capacity > 0) {
            data.add(pet);
            capacity--;
        }
    }

    public boolean remove(String name) {
        if(data.removeIf(pet -> pet.getName().equals(name))) {
            capacity++;
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner))
                return pet;
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(" The grooming salon has the following clients:%n"));
        for (Pet pet : data) {
            builder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
//            builder.append(pet).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
