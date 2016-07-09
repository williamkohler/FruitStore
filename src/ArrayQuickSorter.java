import java.util.ArrayList;

/**
 * Created by williamkohler on 6/20/16.
 */
public class ArrayQuickSorter {


    ArrayQuickSorter() {
    }


    public void QuickSorting(ArrayList<Item> arr, int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1)
            QuickSorting(arr, left, index - 1);
        if (index < right)
            QuickSorting(arr, index, right);

    }


    public int partition(ArrayList<Item> arr, int left, int right) {




        Item pivot = arr.get((left + right) / 2);
        while (left <= right) {


            while (arr.get(left).getPriority() < pivot.getPriority()) left++;
            while (arr.get(right).getPriority() > pivot.getPriority()) right--;


            if (left <= right) {
                Item temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);

                left++;
                right--;
            }
        }
        return left;
    }


}