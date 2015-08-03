package geeks4Geeks.Array;

public class LeadersInArray {

	private static void findFromRight(int[] arr) {
		int currentLead = arr[arr.length-1];
		System.out.println(currentLead);
		for(int i=arr.length-2;i>=0;i--){
			if(arr[i]>currentLead){
				currentLead = arr[i];
				System.out.println(currentLead);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,12,2,4,5,8};
		findFromRight(arr);
	}
}
