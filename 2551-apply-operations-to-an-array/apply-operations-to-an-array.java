class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1] = 0;
            }
        }
        int write = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[write] = nums[i];
                write++;
            }
        }

        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }

        return nums;
    }
}