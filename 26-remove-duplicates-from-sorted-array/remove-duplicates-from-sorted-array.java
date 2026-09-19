class Solution {
    public int removeDuplicates(int[] arr) {
    int n = arr.length;
    int off = 0;
    int uniq = 1;
    int cm = 1;

    while(cm<n){
      if(arr[cm] == arr[cm-1]){
        cm++;
        continue;
      }else{
        arr[off+1] = arr[cm];
        off++;
        uniq++;
        cm++;
      }
    }

    return uniq;
    }
}