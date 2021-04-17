import java.util.*;
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] arr2=new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++){
            
            if(index==arr.length){
                break;
            }
            
            boolean foundZero=false;
            if(arr[i]==0){
                foundZero=true;
            }
            arr2[index]=arr[i];
            if(foundZero){
                
                index++;
                arr2[index]=0;
            }
            index++;
        }
        System.arrayCopy(arr2, 0, arr, 0, arr.length);
       // System.out.println(Arrays.toString(arr2));
        
        //arr=arr2;
        //System.out.println(Arrays.toString(arr));
    }
}
