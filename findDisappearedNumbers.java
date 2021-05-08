class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean [] visited = new boolean [nums.length + 1];
        for(int num : nums){
            visited[num] = true;
        }
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == false){
                list.add(i);
            }
        }
        return list;
    }
}
