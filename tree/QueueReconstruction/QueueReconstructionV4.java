package tree.QueueReconstruction;

import java.util.Arrays;

public class QueueReconstructionV4 {
    // this is a solution copied from
    // https://leetcode.cn/problems/queue-reconstruction-by-height/solutions/1684497/yukiyama-shu-zhuang-shu-zu-er-fen-by-yuk-1ovu/
    // the purpose is to understand how to handle the equal situation.
    // why there is no need to add special logic to handle?

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] res = new int[n][2];
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0])
                return p1[0] - p2[0]; // h升序
            else
                return p2[1] - p1[1]; // k降序
        });
        BIT bit = new BIT(n);
        int k = 0;
        for (int[] p : people) {
            k = p[1];
            int l = 1, r = n;
            while (l <= r) { // 二分查找模版一：大于等于
                int c = l + (r - l) / 2;
                if (c - bit.query(c) < k + 1)
                    l = c + 1;
                else
                    r = c - 1;
            } // l为插入位置，对应到res中要减1
            res[l - 1] = p;
            bit.add(l, 1); // 先查询后插入，与 Offer51 题逻辑一致
        }
        return res;

    }

    public void print(int[][] people) {
        System.out.println("print");

        for (int i = 0; i < people.length; i++) {
            System.out.println(Arrays.toString(people[i]));
        }
    }

    public static void main(String[] args) {

        QueueReconstructionV4 qs = new QueueReconstructionV4();
        int[][] test = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        qs.print(qs.reconstructQueue(test));
    }

}

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public int query(int k) {
        int ans = 0;
        for (int i = k; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public void add(int k, int x) {
        for (int i = k; i <= n; i += lowbit(i)) {
            tree[i] += x;
        }
    }

    private int lowbit(int i) {
        return i & -i;
    }
}
