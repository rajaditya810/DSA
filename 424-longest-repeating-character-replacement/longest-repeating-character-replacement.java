class Solution {
    private int find(int[] f){
        int maxc = -1;
        for(int i=0;i<256;i++){
            maxc=Math.max(maxc, f[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int low=0;
        int res=Integer.MIN_VALUE;
        int n=s.length();
        int[] f=new int[256];

        for(int high=0;high<n;high++){
            f[s.charAt(high)]++;
            int maxcount = find(f);
            int length = high-low+1;
            int diff = length-maxcount;

            while(diff>k){
                f[s.charAt(low)]--;
                low++;
                maxcount = find(f);
                length = high-low+1;
                diff = length - maxcount;
            }
            length= high-low+1;
            res=Math.max(res, length);
        }
        return res;
    }
}