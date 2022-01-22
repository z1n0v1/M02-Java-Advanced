package L03SetsAndMapsAdvanced.Exercise.T14T2DragonArmy;

import java.util.*;

public class Main {
    static LinkedHashMap<String, TreeMap<String, HashMap<String, Integer>>> types;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        types = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            Integer damage = data[2].equals("null") ? 45 : Integer.parseInt(data[2]);
            Integer health = data[3].equals("null") ? 250 : Integer.parseInt(data[3]);
            Integer armor = data[4].equals("null") ? 10 : Integer.parseInt(data[4]);
            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("damage", damage);
            stats.put("health", health);
            stats.put("armor", armor);

            if (!types.containsKey(type)) {
                List<LinkedHashMap<String, HashMap<String, Integer>>> dragons = new ArrayList<>();
                TreeMap<String, HashMap<String, Integer>> names = new TreeMap<>();

                names.put(name, stats);
//                dragons.add(names);
                types.put(type, names);
            } else {
                types.get(type).put(name, stats);
//                int dragonIndex = getDragonIndex(type, name);
//                if(dragonIndex == -1) {
//                    LinkedHashMap<String, HashMap<String, Integer>> names = new LinkedHashMap<>();
//                    names.put(name, stats);
//                    types.get(type).add(names);


//                } else {
//                    types.get(type).get(dragonIndex).put(name, stats);
//                }
            }
        }

        types.forEach((type, dragons) -> {
            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            double numDragons = 0;

            for (Map.Entry<String, HashMap<String, Integer>> dragon : dragons.entrySet()) {
                numDragons++;
                avgDamage += dragon.getValue().get("damage");
                avgHealth += dragon.getValue().get("health");
                avgArmor += dragon.getValue().get("armor");
            }
            avgDamage /= numDragons;
            avgHealth /= numDragons;
            avgArmor /= numDragons;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);

            dragons.forEach((name, stats) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name,
                        stats.get("damage"),
                        stats.get("health"),
                        stats.get("armor")
                );
            });
        });
    }
}
