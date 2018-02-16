/**
 * 
 * @author Amelia Marglon
 * CSC345 Project 2 RadixSort Class
 *
 */
public class Proj02_RadixSort {

	public static void sort(Proj02_DataPair[] vals){
		sort(vals, false);
	}
	public static void sort_trace(Proj02_DataPair[] vals){
		sort(vals, true);
	}
	
	private static void sort (Proj02_DataPair[] vals, boolean debug) {
		Proj02_CountingSort.sort(vals, 0);
		Proj02_CountingSort.sort(vals, 1);
		Proj02_CountingSort.sort(vals, 2);
		Proj02_CountingSort.sort(vals, 3);
		Proj02_CountingSort.sort(vals, 4);
		Proj02_CountingSort.sort(vals, 5);
	}

}
