package InsertDeleteGetRandom;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    int[] data;

    Map<Integer, Integer> map;

    int right;

    public RandomizedSet() {
        this.data = new int[200000];

        this.map = new HashMap<Integer, Integer>();

        this.right = -1;

    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            // already exist
            return false;
        }

        right++;

        data[right] = val;

        map.put(val, right);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int currentIndex = map.get(val);

        map.remove(val);

        if (currentIndex == right) {
            right--;
        } else {
            data[currentIndex] = data[right];
            map.put(data[right], currentIndex);
            right--;
        }

        return true;
    }

    public int getRandom() {

        int count = right + 1;

        Random random = new Random();

        int r = random.nextInt(count);

        return data[r];

    }

    private void print(int[] nums, int right) {

        String out = "";

        for (int i = 0; i <= right; i++) {
            out += nums[i];
            out += ",";
        }

        System.out.println(out);
    }

    public static void main(String[] args) {

        RandomizedSet rs = new RandomizedSet();

        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);

        System.out.println(rs.getRandom());

    }

}
