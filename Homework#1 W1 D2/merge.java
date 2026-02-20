public class merge {
    public static int[] mergeSortedArrays(int arr1[], int arr2[]) {
        // Initialize result array
        int result[] = new int[arr1.length + arr2.length];

        // Create pointers
        int i = 0, j = 0, k = 0;

        // Merge arrays
        // Compare elements from both arrays and add the smaller one to the result array
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // If there are remaining elements in either array, add them to result
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    public static void main(String[] args) { 
        // Test to see if it works
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {2, 4, 6, 8};
        int mergedArray[] = mergeSortedArrays(arr1, arr2);

        for (int index : mergedArray) {
            System.out.print(index + " ");
        }
    }
}
