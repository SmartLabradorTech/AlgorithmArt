package union.NumberofProvinces;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-provinces/description/

public class NumberofProvinces {

    public int findCircleNum(int[][] isConnected) {

        Map<Integer, Integer> cityToProvice = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            // initially everyone belongs to itself.
            cityToProvice.put(i, i);
        }

        for (int i = 0; i < isConnected.length; i++) {
            int first = find(cityToProvice, i);
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {

                    int second = find(cityToProvice, j);

                    if (first == second) {
                        // already belong to same group
                    } else {
                        cityToProvice.put(second, first);
                    }
                }
            }

        }

        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (cityToProvice.get(i) == i) {
                result++;
            }
        }

        return result;
    }

    private int find(Map<Integer, Integer> cityToProvice, int city) {

        if (cityToProvice.get(city) == city) {
            // find an end
            return city;
        }

        return find(cityToProvice, cityToProvice.get(city));
    }

}
