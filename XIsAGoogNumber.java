class Solution {
    public int rotatedDigits(int N) {
      //  Set<Integer>
        int count=0;
        for(int i=1;i<=N;i++){
           if(helper(i)){
               count++;
           } 
        }
        return count;
    }
    
    public boolean helper(int N) {

     boolean validFound = false;
        while (N > 0) {
            int impo = N % 10;
            if (impo == 2 || impo == 5 || impo == 6 || impo == 9) 
                validFound = true;
            else if(impo == 3 || impo == 4 || impo == 7){
                validFound = false;
                break;
            }
            N = N / 10;
        }
        return validFound;
    }
}
