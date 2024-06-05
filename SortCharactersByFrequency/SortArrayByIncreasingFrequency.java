package SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> unique = new ArrayList<Integer>(count.keySet());

        Collections.sort(unique, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                Integer count1 = count.get(num1);
                Integer count2 = count.get(num2);

                if (count1 == count2) {
                    return num2.compareTo(num1);
                } else {
                    return count1.compareTo(count2);
                }
            }
        });

        int[] output = new int[nums.length];
        int index = 0;

        for (int i = 0; i < unique.size(); i++) {
            int current = unique.get(i);

            for (int j = 0; j < count.get(current); j++) {
                output[index] = current;
                index++;
            }

        }

        return output;
    }

    public static void main(String[] args) {

        SortArrayByIncreasingFrequency sf = new SortArrayByIncreasingFrequency();

        // int[] nums = { 1, 1, 2, 2, 2, 3 };

        int[] nums = { 2, 3, 1, 3, 2 };

        System.out.println(Arrays.toString(sf.frequencySort(nums)));

    }
}
