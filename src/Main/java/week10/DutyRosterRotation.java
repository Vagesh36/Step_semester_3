package main.java.week10;
import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        String[] result1 = rotateRoster(names, 2);
        System.out.println(Arrays.toString(result1));

        String[] result2 = rotateRoster(names, 7);
        System.out.println(Arrays.toString(result2));
    }
}
