class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] stop = new int[1001];

        for(int[] trip : trips){
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            stop[from]+= passenger;
            stop[to]-= passenger;
        }
        int currpassenger = 0;
        for(int i = 0; i<=1000; i++){
            currpassenger+= stop[i];
            if(currpassenger>capacity){
                return false;
            }
        }
        return true;
    }
}