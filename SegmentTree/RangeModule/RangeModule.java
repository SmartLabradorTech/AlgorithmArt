package SegmentTree.RangeModule;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/range-module/description/

public class RangeModule {

    private Set<Integer> tracked;

    public RangeModule() {

        tracked = new HashSet<>();

    }

    public void addRange(int left, int right) {

        for (int i = left; i < right; i++) {
            tracked.add(i);
        }
    }

    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!tracked.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public void removeRange(int left, int right) {
        for (int i = left; i < right; i++) {
            tracked.remove(i);
        }
    }
}
