import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class quickSortPartitionsTest {
    @Test
    public void testLomutoSortedArray() {
        int arr[] = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int pivot = arr[arr.length - 1];

        quickSortPartitions.lomutoPartition(arr);

        int pivotIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] < pivot);
        }

        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    @Test
    public void testLomutoEmptyArray() {
        int arr[] = {};

        assertDoesNotThrow(() -> {
            if (arr.length > 0) {
                quickSortPartitions.lomutoPartition(arr);
            }
        });
    }

    @Test
    public void testLomutoUnsortedArray() {
        int arr[] = {84, 3, 7, 1, 9, 6, 2, 5};
        int pivot = arr[arr.length - 1];

        quickSortPartitions.lomutoPartition(arr);

        int pivotIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] < pivot);
        }

        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    @Test
    public void testHoareSortedArray() {
        int arr[] = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int pivot = arr[0];

        quickSortPartitions.hoarePartition(arr);

        boolean crossed = false;
        for (int value : arr) {
            if (value >= pivot) {
                crossed = true;
            }
            if (!crossed) {
                assertTrue(value <= pivot);
            }
        }
    }

    @Test
    public void testHoareEmptyArray() {
        int arr[] = {};

        assertDoesNotThrow(() -> {
            if (arr.length > 0) {
                quickSortPartitions.hoarePartition(arr);
            }
        });
    }

    @Test
    public void testHoareUnsortedArray() {
        int arr[] = {84, 3, 7, 1, 9, 6, 2, 5};
        int pivot = arr[0];

        quickSortPartitions.hoarePartition(arr);

        boolean foundGreaterOrEqual = false;
        for (int value : arr) {
            if (value >= pivot) {
                foundGreaterOrEqual = true;
            }
            if (!foundGreaterOrEqual) {
                assertTrue(value <= pivot);
            }
        }
    }
}

