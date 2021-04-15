class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if((countDigit(nums[i]))%2==0){
                count++;
            }
        }
        return count;
    }
    
    public static int countDigit(int num){
        return (Integer.toString(num)).length();
    }
}
