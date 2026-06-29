class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        int Limit= nums.length/3;
        for(int key : map.keySet()){
            if(map.get(key)>Limit){
                ans.add(key);
            }
        }
        return ans;
    }
}