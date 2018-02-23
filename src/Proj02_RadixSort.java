
 /*
 * @author Amelia Marglon
 * CSC345 Project 2 RadixSort Class
 *
 *RadixSort utilizes methods from the CountingSort class to sort values
 *from least significant figure to most significant figure.
 */
public class Proj02_RadixSort {

        public static void sort(Proj02_DataPair[] vals){
                sort(vals, false);
        }
        public static void sort_trace(Proj02_DataPair[] vals){
                sort(vals, true);
        }
	//iterate through the possible values, calling CountingSort
        private static void sort (Proj02_DataPair[] vals, boolean debug) {
                for (int i = 0; i < 6; i++){
                     if (debug){
                       System.out.printf("--- RADIX SORT: pos=%d ---\n", i);
                       Proj02_CountingSort.sort_trace(vals, i);
                       System.out.println();    //roll radix banner pos=i
                     }else{
                        Proj02_CountingSort.sort(vals, i);
                     }
                }

     }

}
