class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int val=target-nums[i];
            if (hs.containsKey(val)) {
                System.out.println("i "+i+" val "+hs.get(val));
                result[0]=hs.get(val);
                result[1]=i;
                break;
            }
            hs.put(nums[i],i);
            
        }
        return result;
        
    }
}
