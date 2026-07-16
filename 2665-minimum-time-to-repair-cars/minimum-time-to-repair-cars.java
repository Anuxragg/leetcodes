class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = 0;
        for(int rank : ranks){
            maxRank = Math.max(maxRank, rank);
        }
        long left = 1;
        long right = (long) maxRank * cars * cars;
        long ans= 0;
        while(left<=right){
            long mid = left + (right - left)/2;

            long repairedcar = 0;
            for(int rank : ranks){
                repairedcar+= (long)Math.sqrt((double)mid/rank);
            }
            if(repairedcar>=cars){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return ans;
    }
}