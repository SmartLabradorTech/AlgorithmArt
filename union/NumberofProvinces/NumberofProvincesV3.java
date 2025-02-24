package union.NumberofProvinces;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-provinces/
// redo root based

public class NumberofProvincesV3 {
    public int findCircleNum(int[][] isConnected) {

        Map<Integer, Integer> cityToProvice = new HashMap<>();

        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            cityToProvice.put(i, i);
        }

        for (int i = 0; i < n; i++) {
            int firstRoot = findRoot(cityToProvice, i);

            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    int secondRoot = findRoot(cityToProvice, j);

                    if (firstRoot != secondRoot) {
                        cityToProvice.put(secondRoot, firstRoot);
                    }

                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (findRoot(cityToProvice, i) == i) {
                count++;
            }
        }

        return count;
    }

    private int findRoot(Map<Integer, Integer> cityToProvice, int city) {
        int currentProvince = cityToProvice.get(city);

        if (currentProvince == city) {
            return city;
        }

        return findRoot(cityToProvice, currentProvince);
    }
}
