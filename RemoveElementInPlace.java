class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }
        }
        if(count==nums.length){
            return 0;
        }
        
        int low=0,high=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(low>=high){
                break;
            }
            if(nums[low]==val && nums[high]!=val){
                int tmp=nums[high];
                nums[high]=nums[low];
                nums[low]=tmp;
                low++;
                high--;
            }
            
            else if(nums[low]==val){
               if(nums[high]==val){
                    high--;
               }else{
                int tmp=nums[high];
                nums[high]=nums[low];
                nums[low]=tmp;
                low++;
                high--;
               }                
            }
            else if(nums[low]!=val){
                low++;
            }
            else{
                low++;
                high--;
            }
        }
        
        return nums.length-count;
    }
}
