class Solution {
    private static void  swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low =0, mid =0, high = n-1;

        while(mid<= high){
            if(arr[mid] == 0){
                swap(arr, low, mid );
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, high, mid);
                high--;
            }
        }
    }
}
