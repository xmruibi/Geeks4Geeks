package geeks4Geeks.Array;

public class FindMissingNumber {

	// You are given a list of n-1 integers and these integers are in the range
	// of 1 to n. There are no duplicates in list. One of the integers is
	// missing in the list. Write an efficient code to find the missing integer.
	private static int findMissing(int[] arr, int n) {
		int res=0;
		for(int i=1;i<=n;i++)
			res^=i;
		for(int i=0;i<arr.length;i++)
			res^=arr[i];
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,7,6,8,3,10,11};
		System.out.println(findMissing(arr, 11));
	}
}
