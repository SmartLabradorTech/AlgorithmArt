package GasStation;

public class GasStationV2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int length = gas.length;

        for (int i = 0; i < length; i++) {
            // try using i as start

            int remaining = 0;

            boolean success = true;

            int j = 0;

            for (; j < length; j++) {
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
            } else {

                if (i + j >= length) {
                    return -1;
                }

                i = i + j;
            }

        }

        return -1;
    }
}
