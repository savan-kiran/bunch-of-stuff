import java.awt.DisplayMode;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;


public class QuickSort {

	  private ArrayList<String> stringArray;
	  private Locale locale;

	  public void sort(ArrayList<String> array, Locale locale) {
	    // Check for empty or null array
	    if (array ==null || array.size()==0){
	      return;
	    }
	    this.stringArray = array;
	    int length = array.size();
	    this.locale = locale;
	    quicksort(0, length - 1);
	  }

	  private void quicksort(int low, int high) {
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    String pivot = stringArray.get((low + (high-low)/2));
	    Collator collator = Collator.getInstance(locale);
	    collator.setDecomposition(Collator.FULL_DECOMPOSITION);
	    collator.setStrength(Collator.TERTIARY);

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (collator.compare(stringArray.get(i), pivot) < 0) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (collator.compare(stringArray.get(j), pivot) > 0) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  private void exchange(int i, int j) {
	    String temp = stringArray.get(i);
	    stringArray.set(i, stringArray.get(j));
	    stringArray.set(j, temp);
	  }
	  
	public static void display(ArrayList<String> array) {
		for(int i=0;i<array.size();i++) {
			System.out.print(array.get(i) + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Locale locale = new Locale("hi");
		ArrayList<String> array = new ArrayList<String>();
		array.add("कुमारी");
		array.add("मीना");
		array.add("प्रश्नों");
		array.add("सामान्य");
		array.add("ज्ञान");
		QuickSort quickSort = new QuickSort();
		display(array);		
		quickSort.sort(array, locale);
		display(array);
	}
}
