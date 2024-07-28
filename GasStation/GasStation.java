package GasStation;

public class GasStation {
    // https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150

    // time out

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        for (int i = 0; i < length; i++) {
            // try using i as start

            int remaining = 0;

            boolean success = true;

            for (int j = 0; j < length; j++) {
                int location = (i + j) % length;

                remaining += gas[location];

                remaining -= cost[location];

                if (remaining < 0) {
                    success = false;
                    break;
                }
            }

            if (success) {
                return i;
            }

        }

        return -1;
    }

}
