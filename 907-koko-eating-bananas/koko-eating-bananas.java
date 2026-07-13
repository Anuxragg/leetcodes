class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int num : piles){
             right = Math.max(right, num);
        }
        int ans = right;
        while(left<= right){
            int mid = left + (right - left)/2;
            long hour = 0;
            for(int pile : piles){
                hour+= (pile+mid-1)/mid;
            }
                if(hour<=h){
                     ans= mid;
                    right = mid - 1;

                }else{
                    left = mid + 1;
                }
            
        }
        return ans;
        

    }
} 