class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > 0; i--){
            max = Math.max(max, arr[i]);
            ans[i - 1] = max;
        }
        ans[arr.length - 1] = -1;
        return ans;
    }
}
