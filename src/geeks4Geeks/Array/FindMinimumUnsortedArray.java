package geeks4Geeks.Array;

public class FindMinimumUnsortedArray {

	private void getUnsorted(int[] arr) {
		int front = -1;
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				return;
			if (arr[i] > arr[i + 1]) {
				front = i;
				break;
			}
		}
		int rear = arr.length;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < arr[i - 1]) {
				rear = i;
				break;
			}
		}

		int segMax = Integer.MIN_VALUE;
		int segMin = Integer.MAX_VALUE;
		for (int i = front; i <= rear; i++) {
			segMax = Math.max(segMax, arr[i]);
			segMin = Math.min(segMin, arr[i]);
		}

		
		// find front segment has elem less than min
		for(int i=0;i<front;i++)
			if(arr[i]>segMin){
				front = i;
				break;
			}
		// find rear segment has elem larger than max
		for(int i=rear;i<arr.length;i++)
			if(arr[i]<segMax){
				rear = i;
				break;
			}
		
	}
}
