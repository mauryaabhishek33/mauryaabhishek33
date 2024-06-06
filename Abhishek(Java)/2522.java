class Solution {
    public int minimumPartition(String s, int k) {
         int n = s.length();
        int count = 0;
        int i = 0;
        while (i < n) {
            int start = i;
            // Try to form the largest valid substring
            while (i < n && Long.parseLong(s.substring(start, i + 1)) <= k) {
                i++;
            }
            // If we haven't moved, it means the single digit itself is greater than k
            if (start == i) {
                return -1;
            }
            // Increment the partition count
            count++;
        }
        return count;
    }
}
