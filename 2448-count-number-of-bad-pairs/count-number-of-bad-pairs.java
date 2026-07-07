class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long goodpairs = 0;
        int n = nums.length;
        for(int i= 0 ; i<nums.length; i++){
            int key = nums[i] - i;
            if(map.containsKey(key)){
                goodpairs += map.get(key);
            }
            map.put(key, map.getOrDefault(key,0)+1);

        }
        long totalpair = (long) n * (n-1)/2;
        return totalpair - goodpairs;
    }
}