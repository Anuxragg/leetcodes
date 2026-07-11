class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() -1 ;
        int length = 0;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            char ch = s.charAt(left);
            while(left<=right && s.charAt(left)==ch){
                left++;
            }
            while(left<=right && s.charAt(right)==ch){
                right--;
            }
        }
        return right - left +1;
    }
}