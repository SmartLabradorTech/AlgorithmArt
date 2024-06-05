package SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

// https://leetcode.com/problems/sort-characters-by-frequency/

public class SortCharactersByFrequency {
    public String frequencySort(String s) {

        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int newCount = 1;

            Character current = s.charAt(i);

            if (count.containsKey(current)) {
                newCount = count.get(current) + 1;
            }

            count.put(current, newCount);
        }

        List<Character> list = new ArrayList<>(count.keySet());

        Collections.sort(list, new Comparator<Character>() {
            public int compare(Character ch1, Character ch2) {
                return count.get(ch2).compareTo(count.get(ch1));
            }
        });

        String output = "";

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < count.get(list.get(i)); j++) {
                output += list.get(i);
            }
        }

        return output;
    }

    public static void main(String[] args) {

        SortCharactersByFrequency sf = new SortCharactersByFrequency();

        System.out.println(sf.frequencySort("cccaaa"));

    }
}
