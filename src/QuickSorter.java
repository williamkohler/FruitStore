/**
 * Created by williamkohler on 6/20/16.
 */
public class QuickSorter {


    QuickSorter() {
    }


    public void QuickSorting(Item[] arr, int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1)
            QuickSorting(arr, left, index - 1);
        if (index < right)
            QuickSorting(arr, index, right);

    }


    public int partition(Item[] arr, int left, int right) {
        Item pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left].getPriority() < pivot.getPriority()) left++;
            while (arr[right].getPriority() > pivot.getPriority()) right--;

            if (left <= right) {
                Item temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
//            }
            }

        }

        return left;

    }
}
