class Solution {
    public int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    int closestSum = arr[0] + arr[1] + arr[2];
    int n = arr.length;
    for (int i = 0; i < n - 2; i++) {
      int left = i + 1;
      int right = n - 1;

      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];

        if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
          closestSum = sum;
        }
        
        if (sum == target) {
          return closestSum;
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return closestSum;
    }
}