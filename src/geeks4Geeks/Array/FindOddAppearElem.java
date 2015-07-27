package geeks4Geeks.Array;

public class FindOddAppearElem {
	public static int findElemwithOddCount(int[] num) {
			int res = num[0];
			for(int i=1;i<num.length;i++){
				res^=num[i];
			}
			return res;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,2,3,4,5,5,6,1};
		System.out.println(findElemwithOddCount(num));
	}
}
