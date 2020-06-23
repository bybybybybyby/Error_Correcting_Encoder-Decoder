package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String TEST = "11122233344455566677788899";
//        Scanner sc = new Scanner(TEST);

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        StringBuilder sbTripled = new StringBuilder();
        StringBuilder sbDecoded = new StringBuilder();
        Random random = new Random();
        String charErrors = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
        int len = charErrors.length();

        // Output original input
        System.out.println(sb.toString());

        // Output triple characters
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < 3; j++) {
                sbTripled.append(sb.charAt(i));
            }
        }
        System.out.println(sbTripled);

        // Create errors in every triple
        for (int i = 0; i < sbTripled.length(); i += 3) {
            int randPlace = random.nextInt(3);
            if (randPlace < sbTripled.length()) {
                sbTripled.replace(i + randPlace, i + randPlace + 1,
                        String.valueOf(charErrors.charAt(random.nextInt(len - 1))));
            }
        }
        System.out.println(sbTripled.toString());

        // Decode back correct message
        for (int i = 0; i < sbTripled.length(); i += 3) {
            if (sbTripled.charAt(i) == sbTripled.charAt(i + 1)) {
                sbDecoded.append(sbTripled.charAt(i));
            } else if (sbTripled.charAt(i) == sbTripled.charAt(i + 2)) {
                sbDecoded.append(sbTripled.charAt(i));
            } else if (sbTripled.charAt(i + 1) == sbTripled.charAt(i + 2)) {
                sbDecoded.append(sbTripled.charAt(i + 1));
            }
        }
        System.out.println(sbDecoded.toString());

    }
}

