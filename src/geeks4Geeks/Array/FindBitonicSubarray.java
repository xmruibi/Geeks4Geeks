package geeks4Geeks.Array;

public class FindBitonicSubarray {

	private static int findBitonic(int[] arr) {
		int[] inc = new int[arr.length];
		int[] dec = new int[arr.length];
		for(int i = 0;i<arr.length;i++)
			if(i!=0&&arr[i]>arr[i-1])
				inc[i]=inc[i-1]+1;
			else
				inc[i] = 1;
		
		for(int i = arr.length-1;i>=0;i--)
			if(i!=arr.length-1&&arr[i]>arr[i+1])
				dec[i]=dec[i+1]+1;
			else
				dec[i] = 1;
		int max = 0;
		for(int i=0;i<arr.length;i++)
			max = Math.max(max, inc[i]+dec[i]-1);
		return max;		
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 4, 78, 90, 45, 23};
		System.out.println(findBitonic(arr));
	}
}
