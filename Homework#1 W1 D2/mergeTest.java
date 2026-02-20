import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class mergeTest{
    @Test
    public void testTwoSortedArrays() {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {2, 4, 6, 8};
        int expected[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptyFirstArray() {
        int arr1[] = {};
        int arr2[] = {1, 2, 3};
        int expected[] = {1, 2, 3};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptySecondArray() {
        int arr1[] = {4, 5, 6};
        int arr2[] = {};
        int expected[] = {4, 5, 6};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDuplicates() {
        int arr1[] = {1, 2, 2};
        int arr2[] = {2, 3};
        int expected[] = {1, 2, 2, 2, 3};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNegatives() {
        int arr1[] = {-9, -2, -1};
        int arr2[] = {-8, -5, -3};
        int expected[] = {-9, -8, -5, -3, -2, -1};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNull() {
        int arr1[] = {};
        int arr2[] = {};
        int expected[] = {};
        int actual[] = merge.mergeSortedArrays(arr1, arr2);
        assertArrayEquals(expected, actual);
    }
}
