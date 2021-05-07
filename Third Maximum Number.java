class Solution {
    public int thirdMax(int[] nums) {
       
         PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i:nums){
            if(!minHeap.contains(i))       
                  minHeap.add(i);         
            if(minHeap.size()>3){          
                minHeap.remove();         
            }
        }        
        if(minHeap.size()==3)     
              return minHeap.remove();
          Arrays.sort(nums);       
          return nums[nums.length-1];  
    }
}
