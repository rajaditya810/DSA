class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int res = -1;
        int low = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            int i = fruits[high];
            freq.put(i, freq.getOrDefault(i, 0) + 1);

            while (freq.size() > 2) {
                int leftInt = fruits[low];
                freq.put(leftInt, freq.get(leftInt) - 1);
                if (freq.get(leftInt) == 0) {
                    freq.remove(leftInt);
                }
                low++;
            }
            int length = high - low + 1;
            res = Math.max(res, length);
        }
        return res;
    }
}