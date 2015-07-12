
import java.io.IOException;

/**
*
* Class "RandomizedQuickSORT" implements randomized quick sort.
*
* @version 1.0
*
* @author  Manas Mandhani
*/

public class RandomizedQuickSORT {
	int p;
	
	RandomizedQuickSORT(){
		this.p = 0;
	}
	
	/**
	* Partition the list.
	*/
	public int partition(float[] array, int current, int m) {
		
		int pivot = m;
		int counter = current;
		for (int i = current; i < m; i++) {
			if (array[current] > array[pivot]) {
				current++;
			} else if (array[current] <= array[pivot]) {
				float temp = array[counter];
				array[counter] = array[current];
				array[current] = temp;
				current++;
				counter++;
			}
			if (current == pivot) {
				float temp = array[counter];
				array[counter] = array[current];
				array[current] = temp;
				pivot = counter;
			}
		}
		return pivot;
	}
	/**
	* Partition the list based on randomized pivot
	*/
	public int randomPartition(float[] array, int current, int m) {
		int random =   (int) (current + (Math.random() * ((m - current) + 1)));
		int store = (int) array[m];
		array[m] = array[random];
		array[random] = store;
		return partition(array, current, m);
	}

	/**
	* Sort the list by recursively partioning
	*/
	public float[] Qsort(float[] array, int current, int m) {
		if (current < m) {
			p = this.partition(array, current, m);
			this.Qsort(array, current, p - 1);
			this.Qsort(array, p + 1, m);
		}
		return array;
	}
	
	
	public static void main(String[] args) throws Exception {
		int n = args.length;
		float[] array = new float[n];
		RandomizedQuickSORT choice = new RandomizedQuickSORT();
		int m = n - 1;
		int current = 0;
		for ( int i = 0; i < n; i++){
			array[i] = Float.parseFloat(args[i]);
		}
		System.out.println("Random List: " + "\n");
		for ( int i = 0; i < array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println("\n");
		System.out.println("Sorted List: " + "\n");
		choice.Qsort(array, current, m);
		for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
		}
		
	}
}
