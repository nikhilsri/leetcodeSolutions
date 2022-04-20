class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l = 0, r = nums.length - 1;
        int index=0;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (nums[m] == target)
                return m;
 
            // If x greater, ignore left half
            if (nums[m] < target){
                l = m + 1;
                index=l;
            }
 
            // If x is smaller, ignore right half
            else{
                r = m - 1;
                if(r>=0){
                    if(nums[r]>target)
                    {
                        if(r>0){
                            if(nums[r-1]<target)
                                index=r;
                        }
                    }
                }
            }
            if(index<0)
                index=0;
        }
        return index;
        
    }
}
