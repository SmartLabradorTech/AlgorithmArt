package union.NumberofProvinces;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-provinces/
// purely redo

public class NumberofProvincesV2 {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        int[] center = new int[n];

        for (int i = 0; i < n; i++) {
            center[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {
                    // we detecte an edge

                    if (center[i] != center[j]) {
                        int oldCenter = center[j];
                        for (int m = 0; m < n; m++) {
                            if (center[m] == oldCenter) {
                                center[m] = center[i];
                            }
                        }
                    }
                }

            }
        }

        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            unique.add(center[i]);
        }

        return unique.size();

    }

}
