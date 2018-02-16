/**
 * 
 * @author Amelia Marglon
 * CSC345 Project 2 HeapSort Class
 *
 */

public class Proj02_HeapSort {

	private static void sort (Proj02_DataPair[] vals, boolean debug) {
		int n = vals.length - 1; 
		buildMaxHeap(vals, n, debug);
		
		while (n > 0) {
			if (debug) {
				System.out.println("Swapping the max value that remains in the heap, into the next-highest position \nin the array:");
			}
			swap(vals, 0, n, debug);
			n = n - 1;
			if (debug) {
				System.out.printf("Bubbling down the value which was swapped into index [0]   (heapSize=%d)\n", n + 1);
			}
			bubbleDown(vals, 0, n, debug);
			
		}
		

	}	
	
	//buildMaxHeap takes two parameters:
	// - an array of DataPair objects
	// - a boolean value to turn on/off trace functionality
	//buildMaxHeap calls maxHeapify to transform an array into a tree
	//of values where the parent nodes are greater than the child nodes
	private static void buildMaxHeap(Proj02_DataPair[] vals, int n, boolean debug) {
		int heapSize = n;
		int lastParent = getParent(heapSize);
		while (lastParent > -1) {
			bubbleDown(vals, lastParent, heapSize, debug);
			lastParent = lastParent - 1;
			if (debug) {
				System.out.printf("building the max heap: bubbling down, starting at index %d\n", lastParent);
			}
	
		}
		if (debug) {
			System.out.println("--- Heap Sort: The heap is built.  Now extract max values...");
		}
	}

	//bubbleDown take four parameters:
	// - an array of DataPair objects
	// - an integer representing a node on a max heap
	// - an integer representing the location of the last leaf on the heap
	// - a boolean value to turn on/off trace functionality
	//bubbleDown moves a node to its proper place in a max heap if its out of order
	private static void bubbleDown(Proj02_DataPair[] vals, int firstNode, int lastLeaf, boolean debug) {
		
		int root = firstNode;
		//checks to see if root is a heap of just one value
		while (getLeftChild(root) < lastLeaf) {
			int bubbleIndex = getLeftChild(root);
			int tempIndex = root;
			//check to see if the root is smaller than the children
			if (vals[tempIndex].key < vals[bubbleIndex].key) {
				tempIndex = bubbleIndex;
			}
			if (bubbleIndex + 1 < lastLeaf && vals[tempIndex].key <= vals[bubbleIndex + 1].key) {
				//decide which child to swap the root with if necessary
					tempIndex = bubbleIndex + 1;
			}
			if (debug) {
				System.out.printf("  current index: %d (key=%d)\n", firstNode, vals[firstNode].key);
				if (getLeftChild(firstNode) < lastLeaf) {
					System.out.printf("    left    index: %d (key=%d)\n", getLeftChild(firstNode), vals[getLeftChild(firstNode)].key);
				}
				if (getRightChild(firstNode) < lastLeaf) {
					System.out.printf("    right   index: %d (key=%d)\n", getRightChild(firstNode), vals[getRightChild(firstNode)].key);
				}
			}
			if (tempIndex == root) {
				if (debug) {
					System.out.println("   (parent is in the correct position, terminating bubble-down)");
				}
				return;	
			} else {
				swap(vals, root, tempIndex, debug);
				root = tempIndex;
			}	
		}
	}

	//The floor function of node position / 2
	//Integers automatically round down
	private static int getParent(int node) {
		return node / 2;
	}
	
	//left child would be the current node * 2
	//it is possible for the node to be null
	private static int getLeftChild(int node) {
		return node  * 2;
	}
	
	//right child is current node * 2 + 1
	//it is possible for the node to be null
	private static int getRightChild(int node) {
		return (node * 2) + 1;
	}
	
	private static boolean notAParent(int heapSize, int node) {
		if (node > ((heapSize / 2) - 1) && node < (heapSize + 1)) {
			return true;
		} else {
			return false;
		}
	}
	
	//nice swap function borrowed from Russ's solutions
	private static void swap(Proj02_DataPair[] vals, int a, int b, boolean debug) {
		if (debug)
			System.out.printf("swap(%d,%d)\n", a,b);

		Proj02_DataPair tmp = vals[a];
		vals[a] = vals[b];
		vals[b] = tmp;
	}
	
	public static void sort(Proj02_DataPair[] vals){
		sort(vals, false);
	}
	public static void sort_trace(Proj02_DataPair[] vals) {
		sort(vals, true);
	}
}