/**
 * 
 * @author Amelia Marglon
 * CSC345 Project 2 CountingSort Class
 *
 */
public class Proj02_CountingSort {
	//0 to 999999 inclusive
	//pos is the decimal position, we are sorting by the position given

	private static void sort (Proj02_DataPair[] vals, int pos, boolean debug) {
		Proj02_DataPair[] tempArray = new Proj02_DataPair[vals.length];
		if (debug) {
			System.out.printf("-- Beginning Counting Sort, with pos=%d --\n)", pos);
		    
		}
		int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for (Proj02_DataPair i : vals) {
			int key = getKey(i.key, pos);
			int index = 0;
			++counts[key];
			if (debug) {
				System.out.printf("   index=%d : Key=%d -> Bin=%\n", index, i.key, key);
			}
			index++;
		}
		if (debug) {
			System.out.println("Count totals:");
		}
		
		//display all of the bin totals if tracing is on
		for (int i = 0; i < counts.length; i++) {
			if (debug) {
				System.out.printf("  bin %d: count=%d\n", i, counts[i]);
			}
		}
		
		//iterate through counts and change the values to positions
		
		for (int i = 1; i < 10; i++) {
				counts[i] = counts[i] + counts[i - 1];
		}
		
		
	    for (int i = vals.length - 1; i > -1; --i) {
	    		//System.out.println(vals[i].key + " placed at pos " + (counts[getKey(vals[i].key, pos)] - 1) + " with "+ getKey(vals[i].key, pos));
	    		int iterator = (counts[getKey(vals[i].key, pos)] - 1);
	    		tempArray[iterator] = vals[i];
	            counts[getKey(vals[i].key, pos)] -= 1;
	    }
	 for (int i = 0; i < tempArray.length; i++) {
		 vals[i] = tempArray[i];
		 
	 }
	   // for (int i = 0; i < vals.length; i++) {
	   // 	System.out.println(tempArray[i].key);
	   //      vals[i] = tempArray[i];
	   // }
	}
	
	private static int getKey(int i, int pos) {
		int key = 0;
		int modulus = 0;
		int divisor = 0;
		int cap = 0;
		if (pos == 0) {
			modulus = 10;
			divisor = 1;
			
		} else if (pos == 1) {
			modulus = 10;
			divisor = 10;
		}else if (pos == 2) {
			modulus = 10;
			divisor = 100;

		} else if (pos == 3) {
			cap = 10000;
			modulus = 10;
			divisor = 1000;
		} else if (pos == 4) {
			modulus = 10;
			divisor = 10000;
		} else if (pos == 5) {
			modulus = 1000000;
			divisor = 1000;
				
		}
		if (i < cap) {
			key = (i / divisor);
		} else {
			key = (i/divisor);
			key = (key % modulus);
		}
		return key;
	}
	
	public static void sort(Proj02_DataPair[] vals, int pos)
	{
		sort(vals, pos, false);
	}
	
	public static void sort_trace(Proj02_DataPair[] vals, int pos)
	{
		sort(vals, pos, true);
	}

}
