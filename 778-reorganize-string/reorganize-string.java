class Solution {
    
    class Pair{
        int freq;
        char ch;

        Pair(char ch, int freq){
            this.freq =freq;
            this.ch = ch;
        }
    }
    public String reorganizeString(String s) {
        int [] freq = new int [26];
      for(char ch : s.toCharArray()){
        freq[ch - 'a']++;
      }
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        for(int i = 0; i<26; i++){
            if(freq[i]>0){
                pq.offer(new Pair((char) ('a'+i), freq[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        Pair prev = null;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            ans.append(curr.ch);
            curr.freq--;
            if(prev!=null && prev.freq>0){
                pq.offer(prev);
            }
            prev = curr;
        }
        if(ans.length() != s.length()){
            return "";
        }
        return ans.toString();
        

    }
}