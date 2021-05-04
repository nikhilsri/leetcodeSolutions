class Solution {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
             if(count>1){
                break;
            }
            
            if(nums[i]>nums[i+1] && count==0){
                count++;
                if(i==0){
                    nums[i]=nums[i+1]-1;
                }else{
                    if(i+2 != nums.length){
                        if(nums[i+2]>=nums[i]){
                            nums[i+1]=nums[i+2];
                        }else{
                            if(nums[i+1]>=nums[i-1]){
                                nums[i]=nums[i+1];
                            }
                        }
                    }else{
                        if(nums[i+1]<nums[i]){
                            nums[i+1]=nums[i];
                        }else{
                            nums[i]=nums[i-1];
                        }
                    }
                }
                
            }
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
