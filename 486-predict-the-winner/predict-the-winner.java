class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return predict(nums, 0, nums.length - 1, dp) >= 0;
    }

    public int predict(int[] nums, int left, int right, int[][] dp) {
        if (left == right) return nums[left];

        if (dp[left][right] != Integer.MIN_VALUE) return dp[left][right];

        int pickLeft = nums[left] - predict(nums, left + 1, right, dp);
        int pickRight = nums[right] - predict(nums, left, right - 1, dp);

        return dp[left][right] = Math.max(pickLeft, pickRight);
    }
}
