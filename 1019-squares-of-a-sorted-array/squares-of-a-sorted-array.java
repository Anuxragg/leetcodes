class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int [n];
        int left = 0;
        int right = n-1;
        int index = n-1;

        while(left<=right){
            int leftsq = nums[left] * nums[left];
            int rightsq = nums[right] * nums[right];
            if(leftsq>rightsq){
                ans[index] = leftsq;
                left++;
            }else{
                ans[index] = rightsq;
                right--;
            }
            index--;
        }
        return ans;
    }
}