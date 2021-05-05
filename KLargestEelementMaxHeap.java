// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int size=-1;
    static int[] arr2=new int[10002];
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        size=-1;
        arr2=new int[1000002];
        ArrayList<Integer> list=new ArrayList<Integer>();
       // list.add(1);
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        
        for (int i = 0; i < k; i++){
            list.add(deleteRoot(arr2, arr2.length));
            //n--;
        }
        
        return list;
    }
    public static void insert(int element) 
    { 
        arr2[++size] = element; 
        if(size>0)
            heapify(size);
    } 
    public static void heapify(int i)
    {   
        int n=size+1 ;

        // Find parent
        int parent = (i - 1) / 2;
    
        if (parent >= 0) {
    
            if (arr2[i] > arr2[parent]) {
                int temp=arr2[parent];
                arr2[parent]=arr2[i];
                arr2[i]=temp;
                
                heapify(parent);
            }
        }
    }
    
    public static void newHeapify(int arr[], int n, int i){
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            newHeapify(arr, n, largest);
        }
    }
    
    static int deleteRoot(int arr[], int n)
    {
        // Get the last element
        int lastElement = arr[n - 1];

        // Replace root with first element
        int ans=arr[0];
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        newHeapify(arr, n, 0);
        return ans;
    }
}
