class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        int[] windowSum = new int[n-k+1];
        int sum = 0;
        for(int i = 0; i<k; i++){
          sum+= nums[i];
        }
       windowSum[0] = sum;
        for(int i = k; i<n; i++){
            sum+=nums[i];
            sum-=nums[i-k];
            windowSum[i-k+1] = sum;
        }
        int [] left = new int[windowSum.length];
        int best = 0;
        left[0] = 0;
        for(int i = 1; i<windowSum.length; i++){
            if(windowSum[i]>windowSum[best]){
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[windowSum.length];
        best = windowSum.length - 1;
        right[windowSum.length-1] = best;
        for(int i = windowSum.length - 2; i>=0; i--){
            if(windowSum[i]>=windowSum[best]){
                best = i;
            }
            right[i] = best;
        }
        int [] ans = new int[3];
        int maxSum = 0;
        for(int mid = k; mid<windowSum.length - k; mid++){
            int leftt = left[mid - k];
            int rightt = right[mid+ k];
           int total = windowSum[leftt] + windowSum[mid] + windowSum[rightt];

           if(total>maxSum){
            maxSum = total;
            ans[0] = leftt;
            ans[1] = mid;
            ans[2] = rightt;
           }
        }
        return ans;
        
    }
}