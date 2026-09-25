package main.java.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            if (word.isEmpty()) {
                continue;
            }

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(
                        word,
                        frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        Collections.sort(
                entries,
                new Comparator<Map.Entry<String, Integer>>() {

                    @Override
                    public int compare(
                            Map.Entry<String, Integer> a,
                            Map.Entry<String, Integer> b) {

                        return b.getValue()
                                .compareTo(a.getValue());
                    }
                }
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}