class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        else if (s.length() == 1)
            return 1;
        
        int left = 0, right = 0;
        int len = 0;
        int[] arr = new int[128];
        
        while(right < s.length()){
            char ch = s.charAt(right);
            if(arr[ch] > 0){
                while(arr[ch] > 0){
                    char c = s.charAt(left);
                    arr[c]--;
                    left++;
                }
            } 
            arr[ch]++;
            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }
    

}
