package InsertDeleteGetRandomDuplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

public class RandomizedCollection {

    List<Integer> data;

    Map<Integer, List<Integer>> map;

    public RandomizedCollection() {

        this.data = new ArrayList<>();

        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean exists = false;
        if (map.containsKey(val)) {
            exists = true;
        }

    }

    public boolean remove(int val) {

    }

    public int getRandom() {

    }

}
