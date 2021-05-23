class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max_right=arr[n-1];
        ArrayList<Integer>list=new ArrayList<>();
        list.add(max_right);
        for(int i=n-2;i>=0;i--){
            if(max_right<=arr[i]){
                max_right=arr[i];
                list.add(max_right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
