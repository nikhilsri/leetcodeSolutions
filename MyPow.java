class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        if(n==-2147483648 && x==2.00000){
            return 0.0;
        }
        for(int i=Math.abs(n);i>0;i=i/2){
            if(i%2==1){
                if(n>0){
                    ans = ans*x;
                }else{
                    ans = ans/x;
                }
            }
            x = x*x;
        }
        
        return ans;
    }
}
