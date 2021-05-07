class Solution {
    public int[] sortArrayByParity(int[] A) {
        int j=0;
		for(int i=0;i<A.length;i++) {
			if(!isOdd(A[i]) && isOdd(A[j])) {
				int temp=A[j];
				A[j]=A[i];
				A[i]=temp;
				j++;
			}
			if(!isOdd(A[i]) && !isOdd(A[j])) {
				j++;
			}
		}
        return A;
    }
    public static boolean isOdd(int val){
        if(val%2==0){
            return false;
        } else{
            return true;
        }
    }
}
