class Solution {
    public int[] sortedSquares(int[] nums) {        
        int j=0;
        int[] result = new int[nums.length];
        if(nums.length==1){
            nums[0]=nums[0]*nums[0];
            return nums;
        }
        int backCounter = 0;
        int frontCounter = nums.length -1;;
        for(int i=nums.length - 1; i>=0; i--){
            int front = nums[frontCounter];
            int back = nums[backCounter];
            if(Math.abs(front)>Math.abs(back)){
                result[i] = front*front;
                frontCounter--;
            }else{
                result[i] = back*back;
                backCounter++;
            }   
        }
        return result;
            
    }
}
