class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);
        long prefix = 0;
        long ans = Long.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            prefix+= nums[i];
            int rem = (i+1)%k;
            if(map.containsKey(rem)){
                ans = Math.max(ans, prefix - map.get(rem));
            }
            map.put(rem, Math.min(map.getOrDefault(rem, Long.MAX_VALUE), prefix));
        }
        return ans;
    }
}