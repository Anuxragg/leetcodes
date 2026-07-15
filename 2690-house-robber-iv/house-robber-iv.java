class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        
        for(int num : nums){
            left = Math.min(left, num);
            right = Math.max(right, num);   

        }
        int ans = right;
        while(left<=right){
            int mid = left+ (right - left)/2;
           int count = 0;
            for(int i = 0; i<nums.length; i++){
                if(nums[i]<=mid){
                    
                    count++;
                    i++;
                }
                
            }
            if(count>=k){
                    ans = mid;
                    right = mid-1;
                }else{
                    left = mid +1;
                }
        }
        return ans;
        
    }
}