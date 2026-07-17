class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int num : gifts){
        pq.offer(num);
       }
       while(k>0){
       int largest = pq.poll();
       largest = (int) Math.sqrt(largest);
       pq.offer(largest);
        k--;
       }
       long sum = 0;
       while(!pq.isEmpty()){
        sum+= pq.poll();
       }
       
       return sum;
    }
}