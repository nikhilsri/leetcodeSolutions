package parcticeDSA;

import java.util.Arrays;

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0,0,1,1,1,1,0};
		int j=arr.length-1;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]==1 && arr[j]==0) {
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				j--;
			}
			if(arr[i]==1 && arr[j]==1) {
				j--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
