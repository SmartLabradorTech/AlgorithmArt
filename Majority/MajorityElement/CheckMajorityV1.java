package Majority.MajorityElement;

public class CheckMajorityV1 {

    public boolean isMajorityElement(int[] nums, int target) {

        int leftIndex = findLeft(nums, 0, nums.length - 1, target);

        if (leftIndex == -1) {
            return false;
        }

        int right = nums.length / 2 + leftIndex;

        return right < nums.length && nums[right] == target;
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        if (left == right && nums[left] == target) {
            return left;
        }

        if (target < nums[left]) {
            return -1;
        }

        if (target > nums[right]) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target > nums[mid]) {
            return findLeft(nums, mid + 1, right, target);
        } else if (target < nums[mid]) {
            return findLeft(nums, left, mid - 1, target);
        } else {
            return findLeft(nums, left, mid, target);
        }
    }

    // private int findRight(int[] nums, int left, int right, int target) {

    // if (left > right) {
    // return -1;
    // }

    // if (left == right) {
    // if (nums[left] == target) {
    // return left;
    // }

    // return -1;
    // }

    // if (target < nums[left]) {
    // return -1;
    // }

    // if (target > nums[right]) {
    // return -1;
    // }

    // int mid = (left + right) / 2;

    // if (target > nums[mid]) {
    // return findRight(nums, mid + 1, right, target);
    // } else if (target < nums[mid]) {
    // return findRight(nums, left, mid - 1, target);
    // } else {
    // return findRight(nums, mid, right, target);
    // }
    // }

    public static void main(String[] args) {
        CheckMajorityV1 cm = new CheckMajorityV1();

        int[] nums = { 2, 4, 5, 5, 5, 5, 5, 6, 6 };

        int target = 5;

        System.out.println(cm.isMajorityElement(nums, target));

    }

}
