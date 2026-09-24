class Solution {
    public int maxSubArray(int[] nums) {
     int sum = 0;
     int maxsum = nums[0];
     for(int num : nums){
        if(sum<0){
            sum = 0;
        }
            sum+= num;
            maxsum = Math.max(maxsum, sum);
        
     }
     return maxsum;
    }
}