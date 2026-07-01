class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) return ans;

        int start, end;
        int windowSum = 0;

        if (k > 0) {
            // Initial window: indices 1 to k
            start = 1;
            end = k;

            for (int i = start; i <= end; i++) {
                windowSum += code[i % n];
            }

            for (int i = 0; i < n; i++) {
                ans[i] = windowSum;

                // Slide the window
                windowSum -= code[start % n];
                start++;
                end++;
                windowSum += code[end % n];
            }

        } else { // k < 0
            k = -k; // work with positive value

            // Initial window: previous k elements
            start = n - k;
            end = n - 1;

            for (int i = start; i <= end; i++) {
                windowSum += code[i % n];
            }

            for (int i = 0; i < n; i++) {
                ans[i] = windowSum;

                // Slide the window
                windowSum -= code[start % n];
                start++;
                end++;
                windowSum += code[end % n];
            }
        }

        return ans;
    }
}