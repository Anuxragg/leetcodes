class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int totalsum = 0;
        int maxlen = -1;
        for(int i = 0; i<nums.length; i++){
            totalsum+= nums[i];
        }
        int target = totalsum - x;
        int currsum = 0;
        for(int right = 0; right< nums.length; right++){
            
            currsum += nums[right];
           while(left<=right && currsum>target){
            currsum  -= nums[left];
            left++;
           }
           if(currsum == target){
             maxlen = Math.max(maxlen, right - left + 1);
           }
          

            }
             if (maxlen == -1) {
            return -1;
        
        
       
       
    }
     return nums.length - maxlen;
     }
}