package Sunshine;

public class FindMax {
	
	private final int[] arr = { 6, 3, -4, 4, 2, -8, -6, 5, -2, 7 };
	
	        int maxIndex = arr.length - 1;

	
	FindMax() {
		
		int max = arr[0];
		
		int sum;
		
		int startIndex = 0;
		
		int endIndex = 0;
		
		for (int i = 0; i <= maxIndex; i++) {
			
			sum = 0;
			
			for (int j = i; j <= maxIndex; j++) {
				
				sum += arr[j];
				
				if (sum > max) {
					
					max = sum;
					
					startIndex = i;
					
					endIndex = j;
					
				}
			}
		}
		System.out.println("MaxArr = " + max);
		
		printArr(startIndex, endIndex);
		
	}

	
	private void printArr(int startIndex, int endIndex) {
		
		for (int i = startIndex; i <= endIndex; i++) {
			
			System.out.print(arr[i] + " ");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new FindMax();
		
	}
	
}
