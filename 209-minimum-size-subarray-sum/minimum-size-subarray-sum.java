class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int sum = 0;
        int low = 0;
        int high = 0;
        int res = Integer.MAX_VALUE;
        while (high < n) {
            sum = sum + arr[high];
            while (sum >= target) {
                int length = high - low + 1;
                res = Math.min(res, length);
                sum = sum - arr[low];
                low++;
            }
            high++;
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}