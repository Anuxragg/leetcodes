class Solution {

    class Pair{
        char ch;
        int value;
        Pair(char ch, int value){
            this.ch = ch;
            this.value = value;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.value - x.value);
        if(a>0){
            pq.offer(new Pair('a', a));
        }
        if(b>0){
            pq.offer(new Pair('b', b));
        }
        if(c>0){
            pq.offer(new Pair('c', c));
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.poll();
            if(ans.length()>=2 && ans.charAt(ans.length() - 1)==first.ch&& ans.charAt(ans.length()-2)==first.ch){
               if(pq.isEmpty()){
                break;
               }
               Pair second= pq.poll();
               ans.append(second.ch);
               second.value--;
               pq.offer(first);

               if(second.value>0){
                pq.offer(second);
               }
               }else{
                ans.append(first.ch);
                first.value--;
                  if(first.value>0){
                    pq.offer(first);
                }
            }


            
        }
        return ans.toString();
    }
}