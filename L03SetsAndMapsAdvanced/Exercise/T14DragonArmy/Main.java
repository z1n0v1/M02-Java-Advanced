package L03SetsAndMapsAdvanced.Exercise.T14DragonArmy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> nameType = new TreeMap<>();
        LinkedHashSet<String> types = new LinkedHashSet<>();
        LinkedHashMap<String, HashMap<String, Integer>> stats = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            Integer damage = data[2].equals("null") ? 45 : Integer.parseInt(data[2]);
            Integer health = data[3].equals("null") ? 250 : Integer.parseInt(data[3]);
            Integer armor = data[4].equals("null") ? 10 : Integer.parseInt(data[4]);

            nameType.put(name, type);
            types.add(type);
            if (!stats.containsKey(name))
                stats.put(name, new HashMap<String, Integer>());
            stats.get(name).put("damage", damage);
            stats.get(name).put("health", health);
            stats.get(name).put("armor", armor);
        }

        types.forEach(type -> {
            double avgDamage = 0, avgHealth = 0, avgArmor = 0;
            double numDragons = 0;
            for (Map.Entry dragon : nameType.entrySet()) {
                if(type.equals(dragon.getValue())) {
                    numDragons++;
                    avgDamage += stats.get(dragon.getKey()).get("damage");
                    avgHealth += stats.get(dragon.getKey()).get("health");
                    avgArmor += stats.get(dragon.getKey()).get("armor");
                }
            }
            avgDamage /= numDragons;
            avgHealth /= numDragons;
            avgArmor /= numDragons;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);
            nameType.forEach((name, dragonType) -> {
                if(dragonType.equals(type)) {
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name,
                            stats.get(name).get("damage"),
                            stats.get(name).get("health"),
                            stats.get(name).get("armor")
                            );
                }
            });
        });

//        types.forEach((name, type) -> {
//            double avgDamage = 0, avgHealth = 0, avgArmor = 0;
//            double numDragons = 0;
//            for (Map.Entry dragon : nameType.entrySet()) {
//                if (dragon.getValue().equals(type)) {
//                    numDragons++;
//                    avgDamage += stats.get(name).get("damage");
//                    avgHealth += stats.get(name).get("health");
//                    avgArmor += stats.get(name).get("armor");
//                }
//            }
//            avgDamage /= numDragons;
//            avgHealth /= numDragons;
//            avgArmor /= numDragons;
//
//
//        });

    }
}
