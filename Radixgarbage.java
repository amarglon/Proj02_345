+/**
+ * 
+ * @author Amelia Marglon
+ * CSC345 Project 2 RadixSort Class
+ *
+ */
+public class Proj02_RadixSort {
+
+	public static void sort(Proj02_DataPair[] vals){
+		sort(vals, false);
+	}
+	public static void sort_trace(Proj02_DataPair[] vals){
+		sort(vals, true);
+	}
+	
+	private static void sort (Proj02_DataPair[] vals, boolean debug) {
            for (int i = 1; i < 6; i++){
                if (debug){
                    //roll radix banner pos=i
                }
                Proj02_CountingSort.sort(vals, i, debug);   
        }
+		
+	}
+
+}
