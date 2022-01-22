package L03SetsAndMapsAdvanced.Exercise.T11LogsAggregator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> userDuration = new TreeMap<>();
        HashMap<String, TreeSet<String>> userIp = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            if(!userDuration.containsKey(user)) {
                userDuration.put(user, duration);
            } else {
                userDuration.put(user, userDuration.get(user) + duration);
            }
            if(!userIp.containsKey(user)) {
                TreeSet<String> ips = new TreeSet<>();
                ips.add(ip);
                userIp.put(user, ips);
            } else {
                userIp.get(user).add(ip);
            }
        }
        userDuration.forEach((user, duration) -> {
            System.out.printf("%s: %d %s%n", user, duration, userIp.get(user).toString());
        });

    }
}
