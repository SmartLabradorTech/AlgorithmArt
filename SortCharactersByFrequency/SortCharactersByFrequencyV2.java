package SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

import java.util.Map;

class SortCharactersByFrequencyV2 {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        int maxFrequency = 0;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            count.put(current, count.getOrDefault(current, 0) + 1);

            maxFrequency = Math.max(maxFrequency, count.get(current));
        }

        List<List<Character>> buckets = new ArrayList<>();

        for (int i = 0; i <= maxFrequency; i++) {
            buckets.add(null);
        }

        for (Character character : count.keySet()) {

            int frequency = count.get(character);

            List<Character> currentBucket = buckets.get(frequency);

            if (currentBucket == null) {
                currentBucket = new ArrayList<>();
                buckets.set(frequency, currentBucket);
            }

            currentBucket.add(character);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = maxFrequency; i >= 1; i--) {

            List<Character> currentList = buckets.get(i);

            if (currentList != null) {

                for (int j = 0; j < currentList.size(); j++) {

                    for (int k = 0; k < i; k++) {
                        builder.append(currentList.get(j));
                    }

                }
            }

        }

        return builder.toString();
    }

    public static void main(String[] args) {

        SortCharactersByFrequencyV2 sc = new SortCharactersByFrequencyV2();

        System.out.println(sc.frequencySort("cccaaa"));

    }
}