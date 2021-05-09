class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];
        int best = -1;
        // Traverse from left side
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                left[i]=0;
            }
            else{
                if(i==0){
                    left[i] = Integer.MAX_VALUE;
                }
                else{
                    left[i]= left[i-1]==Integer.MAX_VALUE?Integer.MAX_VALUE: left[i-1]+1;
                }
            }
        }
        
        // Traverse from right side
        for(int i=seats.length-1;i>=0;i--){
            if(seats[i]==1){
                right[i]=0;
            }
            else{
                if(i==seats.length-1){
                    right[i] = Integer.MAX_VALUE;
                }
                else{
                 right[i]= right[i+1]==Integer.MAX_VALUE?Integer.MAX_VALUE: right[i+1]+1;
                }
            }
        }
        
        for(int i=0;i<seats.length;i++){
            best = Math.max(best, Math.min(left[i],right[i]));
        }
        
        return best;
    }
}
