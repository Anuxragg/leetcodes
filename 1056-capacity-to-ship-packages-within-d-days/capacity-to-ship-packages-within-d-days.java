class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        int ans = right;
        while(left<=right){
            int mid = left + (right - left)/2;

            int dayused = 1;
            int currWeight = 0;
            for(int weight : weights){
                if(currWeight + weight > mid){
                    dayused++;
                    currWeight = weight;
                }else{
                currWeight+= weight;
                }

            }
            
                if(dayused<=days){
                    ans = mid;
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            
        }
        return ans;
    }
}