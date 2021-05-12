class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans=new int[digits.length+1];
        
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] == 9){
            digits[i] = 0;
            }else{
            digits[i]++;
            return digits;
            }
        }
        ans[0]=1;
        return ans;
    }
}
