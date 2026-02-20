public class quickSortPartitions {

    public static void lomutoPartition(int arr[]) {
        // Assign the pivot to the last element of the array
        int arrLength = arr.length;
        int pivot = arr[arrLength - 1];

        // Check each element of the array and compare it with the pivot
        // If it is smaller, increment index then swap the elements
        int i = -1;
        for (int j = 0; j < arrLength; j++) {
            if (arr[j] < pivot) { 
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot into the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[arrLength - 1];
        arr[arrLength - 1] = temp;
    }

    public static void hoarePartition(int arr[]) {
        // Assign the pivot to the first element of the array and initialize the indices
        int arrLength = arr.length;
        int pivot = arr[0];
        int i = -1, j = arrLength;

        // Check each element of the array and compare it with the pivot
        while (true) {
            do {
                i++; // Increment pointer until an element is greater than or equal to pivot
            } while (arr[i] < pivot);
            do {
                j--; // Decrement pointer until we find an element less than or equal to pivot
            } while (arr[j] > pivot);
            if (i >= j) { // If pointers cross or meet, then the partitioning is done
                break;
            }

            // Swap elements at i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
    }    
}
