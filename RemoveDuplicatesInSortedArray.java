class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        int uniqueElement=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){           
            if(nums[i]!=uniqueElement){
                uniqueElement=nums[i];
                nums[count]=uniqueElement;
                count++;
            }          
        }
        return count;
        
    }
}
