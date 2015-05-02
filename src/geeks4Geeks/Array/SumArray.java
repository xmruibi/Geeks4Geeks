package geeks4Geeks.Array;

public class SumArray {
	public static int sum(int[] num, int idx) {
		if(idx==num.length)
			return 0;
		return num[idx]+sum(num, idx+1);
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,5,6,2,4,5,7,3,4,5,7};
		System.out.println(sum(num, 0));
	}
}
