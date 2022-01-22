package L03SetsAndMapsAdvanced.Exercise.T09UserLogs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("IP=(?<ip>[^\\s]+)\\s[^\\s]+\\suser=(?<user>[^\\s]*)");
//        Pattern pattern = Pattern.compile("IP=(?<ip>[0-9A-F\\.\\:]+)\\s[^\\s]+\\suser=(?<user>[^\\s]*)");
        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        String s = scanner.nextLine();
        while (!s.equals("end")) {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                String ip = matcher.group("ip");
                String user = matcher.group("user");

                if (!logs.containsKey(user))
                    logs.put(user, new LinkedHashMap<>());
                if (!logs.get(user).containsKey(ip))
                    logs.get(user).put(ip, 1);
                else logs.get(user).put(ip, logs.get(user).get(ip) + 1);
            }
            s = scanner.nextLine();
        }
        logs.forEach((user, ip) -> {
            System.out.printf("%s:%n", user);
            if (ip.size() > 1) {
                for (int i = 0; i < ip.size() - 1; i++) {
                    String currentIp = (String) ip.keySet().toArray()[i];
                    int count = ip.get(currentIp);
                    System.out.printf("%s => %d, ", currentIp, count);
                }
                String currentIp = (String) ip.keySet().toArray()[ip.size() - 1];
                int count = ip.get(currentIp);
                System.out.printf("%s => %d.%n", currentIp, count);

            } else {
                ip.forEach((currentIp, count) -> {
                    System.out.printf("%s => %d.%n", currentIp, count);
                });
//                System.out.printf("%s => %d.%n", currentIp, count);
            }

//            ip.forEach((currentIp, count) -> {
//                System.out.printf("%s => %d.%n", currentIp, count);
//            });
        });


    }
}
