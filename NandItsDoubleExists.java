import java.util.Hashtable;
class Solution {
    public boolean checkIfExist(int[] arr) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        if(arr.length==0 || arr==null){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                break;
            }
            ht.put(arr[i],i);
            if(arr[i+1]%2==0){
                if(ht.containsKey(arr[i+1]/2)){
                    return true;
                }
            }
            if(ht.containsKey(2*arr[i+1])){
                return true;
            }
        }
        return false;
    }
}
