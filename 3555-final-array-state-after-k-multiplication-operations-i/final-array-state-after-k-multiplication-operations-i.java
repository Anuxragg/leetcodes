class Solution {
    class Pair{
        int value;
        int index;

        Pair(int value, int index){
            this.index = index;
            this.value = value;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if (a.value == b.value){
                return a.index - b.index;
            }
           return a.value - b.value;
        });
         for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        while(k-- > 0){
            Pair p = pq.poll();
            p.value*= multiplier;
            nums[p.index] = p.value;
            pq.offer(p);
        }
        return nums;
    }
}