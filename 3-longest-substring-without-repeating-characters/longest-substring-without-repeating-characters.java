class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int low = 0;
        HashMap<Character,Integer> freq = new HashMap<>();

        for(int high = 0;high<n;high++){
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            int k = high-low+1;
            while (freq.size() < k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar)-1);
                if (freq.get(leftChar)==0) {
                    freq.remove(leftChar);
                }
                low++;
                k = high-low+1;
            }
            res = Math.max(res, k);
        }
        return res;
    }
}