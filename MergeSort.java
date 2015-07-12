/**
*
* Class "MergeSort" implements merge sort.
*
* @version 1.0
*
* @author  Manas Mandhani
*/

public class MergeSort {
	
	public void mergeSort(int[] array) {
		int n = array.length;
		int counter = 0;
		if (n < 2)
			return;
		int middle = n / 2;
		int[] left_array = new int[middle];
		int[] right_array = new int[n - middle];
		for (int i = 0; i < middle; i++) {
			left_array[i] = array[i];
		}
		for (int i = middle; i < n; i++) {
			right_array[counter] = array[i];
			counter++;
		}
		mergeSort(left_array);
		mergeSort(right_array);
		Merge(left_array, right_array, array);
	}

	public void Merge(int[] left_array, int[] right_array, int[] array) {
		int left, right, count;
			for (left = 0, right = 0, count = 0; left < left_array.length && right < right_array.length; count++) {
				if (left_array[left] < right_array[right]) {
					array[count] = left_array[left];
					left++;
				} else {
					array[count] = right_array[right];
					right++;
				}
			}

			for (; left < left_array.length; left++, count++) {
				array[count] = left_array[left];
			}

			for (; right < right_array.length; right++, count++) {
				array[count] = right_array[right];
		}
	}
	
	
	public static void main(String[] args){
		MergeSort sort = new MergeSort();
		int[] array = new int[args.length];
		for (int i = 0; i < args.length; i++){
				array[i] = Integer.parseInt(args[i]);
		}
		sort.mergeSort(array);
		
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
