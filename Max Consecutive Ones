class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=1;
        int max=Integer.MIN_VALUE;
        boolean found = IntStream.of(nums).anyMatch(n -> n == 1);
        
        if(nums.length==0){
            return 0;
        }
        
        if(nums.length==1 || !found){
            if(nums[0]==0){
                    return 0;
            }
        }
            for(int i=0;i<nums.length;i++){
                if(i==nums.length-1){
                    break;
                }

                if(nums[i]==1 && nums[i+1]==1){
                    count++;
                }else{
                    max=Math.max(max,count);
                    count=1;
                }
            }
        
        //System.out.println(count+" "+max);
        return Math.max(max,count);
    }
}
