class Solution {
    public int[] sortedSquares(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) { // Seprating negative and positive Arrays
      if (arr[i] < 0) {
        neg.add(arr[i]);
      } else {
        pos.add(arr[i]);
      }
    }

    // No negative number
    if (neg.size() == 0) {
      for (int i = 0; i < pos.size(); i++) {
        pos.set(i, pos.get(i) * pos.get(i));
      }
      return pos.stream().mapToInt(Integer::intValue).toArray();
    }

    // No Positive number
    if (pos.size() == 0) {
      for (int i = 0; i < neg.size(); i++) {
        neg.set(i, neg.get(i) * neg.get(i));
      }
      Collections.reverse(neg);
      return neg.stream().mapToInt(Integer::intValue).toArray();
    }

    // Both negative and positive number are present
    int i = 0;
    int j = 0;
    int m = pos.size();
    int n = neg.size();
    int[] res = new int[m + n];
    int idx = 0;

    for (int a = 0; a < pos.size(); a++) {
      pos.set(a, pos.get(a) * pos.get(a));
    }
    for (int b = 0; b < neg.size(); b++) {
      neg.set(b, neg.get(b) * neg.get(b));
    }
    Collections.reverse(neg);

    while (i < m && j < n) {
      if (pos.get(i) < neg.get(j)) {
        res[idx] = pos.get(i);
        i++;
        idx++;
      } else {
        res[idx] = neg.get(j);
        j++;
        idx++;
      }
    }
    while (i < m) {
      res[idx] = pos.get(i);
      i++;
      idx++;
    }
    while (j < n) {
      res[idx] = neg.get(j);
      j++;
      idx++;
    }
    return res;
    }
}