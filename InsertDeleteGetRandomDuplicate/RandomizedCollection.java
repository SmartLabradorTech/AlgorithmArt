package InsertDeleteGetRandomDuplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

public class RandomizedCollection {

    List<Integer> data;

    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {

        this.data = new ArrayList<>();

        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean exists = !map.containsKey(val);

        data.add(val);

        Set<Integer> indices = map.get(val);

        if (indices == null) {
            indices = new HashSet<>();
        }

        indices.add(data.size() - 1);

        map.put(val, indices);

        return exists;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> indices = map.get(val);

        int pickedIndex = indices.iterator().next();

        indices.remove(pickedIndex);

        if (indices.isEmpty()) {
            map.remove(val);
        }

        int allLastIndex = data.size() - 1;
        int allLastElement = data.getLast();

        if (pickedIndex == allLastIndex) {
            data.removeLast();
        } else {

            data.set(pickedIndex, allLastElement);

            map.get(allLastElement).remove(allLastIndex);
            map.get(allLastElement).add(pickedIndex);

            data.removeLast();
        }

        return true;
    }

    public int getRandom() {
        Random random = new Random();

        int index = random.nextInt(data.size());

        return data.get(index);
    }

}
