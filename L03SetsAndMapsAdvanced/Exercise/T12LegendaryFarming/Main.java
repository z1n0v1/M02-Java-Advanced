package L03SetsAndMapsAdvanced.Exercise.T12LegendaryFarming;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> materials = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        boolean hasLegendary = false;
        String legendary = "";
        materials.put("shards", 0);
        materials.put("motes", 0);
        materials.put("fragments", 0);

        while (!hasLegendary) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i += 2) {
                String material = data[i + 1].toLowerCase(Locale.ROOT);
                int quantity = Integer.parseInt(data[i]);
                if (material.equals("fragments") || material.equals("shards") || material.equals("motes")) {
                    if (!materials.containsKey(material)) {
                        materials.put(material, quantity);
                    } else {
                        materials.put(material, materials.get(material) + quantity);
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                }
                if (materials.containsKey("fragments") && materials.get("fragments") >= 250) {
                    hasLegendary = true;
                    legendary = "Valanyr";
                    materials.put("fragments", materials.get("fragments") - 250);
                    break;
                } else if (materials.containsKey("shards") && materials.get("shards") >= 250) {
                    hasLegendary = true;
                    legendary = "Shadowmourne";
                    materials.put("shards", materials.get("shards") - 250);
                    break;
                } else if (materials.containsKey("motes") && materials.get("motes") >= 250) {
                    hasLegendary = true;
                    legendary = "Dragonwrath";
                    materials.put("motes", materials.get("motes") - 250);
                    break;
                }
            }
        }
        System.out.printf("%s obtained!%n", legendary);
        materials.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return a.getKey().compareTo(b.getKey());
            return b.getValue().compareTo(a.getValue());
        }).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
        junk.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));
    }
}
