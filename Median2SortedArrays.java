class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex=0;
        int len=nums1.length+nums2.length;
        int[] nums3=new int[len];
        
        Map<Integer,Boolean> mp = new HashMap<Integer,Boolean>();
        
        int i = nums1.length;
        int j = nums2.length;
        
        
        System.arraycopy(nums1, 0, nums3, 0, i);
        System.arraycopy(nums2, 0, nums3, i, j);
        
        Arrays.sort(nums3);
       
        
        int n = nums3.length;
       
        // If length of array is even
        if (n % 2 == 0)
        {
            int z = n / 2;
            int e = nums3[z];
            int q = nums3[z - 1];
 
            double ans = (double)((e + q) / 2.0);
            return ans;
        }
       
        // If length if array is odd
        else
        {
            int z = Math.round(n / 2);
            return (double)nums3[z];
        }
        
    }
}
