package geeks4Geeks.Array;

public class MaxiumNoAdjacentSum {

	private static int checkSum(int[] arr) {
		int incl = arr[0], excl = 0;
		for(int i = 1; i<arr.length;i++){
			int tmpincl = incl;
			incl = excl+arr[i];
			excl = Math.max(excl, tmpincl);
		}
		return Math.max(excl, incl);
	}
	
	public static void main(String[] args) {
		int[] arr = {10,1,-1,-1,10};
		System.out.println(checkSum(arr));
	}
}
