public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long lsum=0L,sum=0L;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        for(int i=0;i<n;i++){
            sum=sum-arr[i];
            if(lsum==sum)
                return i+1;
            lsum=lsum+arr[i];
        }
        return -1;
    }
