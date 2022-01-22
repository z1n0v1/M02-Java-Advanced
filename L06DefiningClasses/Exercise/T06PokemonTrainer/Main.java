package L06DefiningClasses.Exercise.T06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        List<String> trainerPosition = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            Integer health = Integer.parseInt(data[3]);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
                trainerPosition.add(trainerName);
            }
            trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, element, health));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> trainer: trainers.entrySet()) {
                trainer.getValue().turn(input);
            }
            input = scanner.nextLine();
        }
        trainers.entrySet().stream().sorted((a, b) -> {
            if(b.getValue().getNumBadges().equals(a.getValue().getNumBadges())) {
                return trainerPosition.indexOf(a.getKey()) - trainerPosition.indexOf(b.getKey());
            }
            return b.getValue().getNumBadges().compareTo(a.getValue().getNumBadges());
        }).forEach(trainer -> {
            System.out.println(trainer.getValue());
        });
    }
}
