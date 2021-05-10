// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        
        //Taking input using class Scanner
        Scanner in = new Scanner(System.in);
        
        //Taking count of testcases
        int t = in.nextInt();
        while (t-- > 0) {
            
            //takling count of elements
            int n = in.nextInt();
            
            //Creating an array of size n
            long arr[] = new long[n];

            //inserting elements to the array
            for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

            //calling minCost method of class solve
            System.out.println(new Solution().minCost(arr, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        long ans=0L;
        PriorityQueue<Long> minHeap=new PriorityQueue<Long>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
        }
        int sizee=minHeap.size();
        for(int i=0;i<sizee-1;i++){
           // System.out.println(minHeap.toString()+" "+ans);
            long temp=minHeap.remove();
            
            temp+=minHeap.remove();
            //ans+=temp;
            minHeap.add(temp);
            ans+=temp;
            //temp=0L;
          //  System.out.println(minHeap.toString()+" "+ans);
        }
       // System.out.println(minHeap.toString()+" "+ans);
        return ans;
    }
}
