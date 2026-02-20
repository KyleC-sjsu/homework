// Implement given WordFreq class
class WordFreq {
    String word;
    int frequency;

    // Add a constructor
    public WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    // To string method
    public String toString() {
        String output = "Word: " + word + "\n";
        output += "Frequency: " + frequency + "\n";
        return output;
    }
}

public class HW3 {
    // Create heapify for subtrees
    static void heapify(WordFreq arr[], int n, int root) {
        // Initialize key nodes
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // Check if left child is larger than root
        if (left < n && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        // Check if right child is larger than root
        if (right < n && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        // If the largest isn't the root, recursively heapify sub-trees
        if (largest != root) {
            WordFreq temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Build max heap from input array
    static void buildMaxHeap(WordFreq arr[]) {
        int n = arr.length;

        // Index of the last non-leaf node
        int startIndex = (n / 2) - 1;

        // Heapify from startIndex until the array is fully traversed
        for (int i = startIndex; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        // Create an array of WordFreq objects
        WordFreq wordFreqArr[] = {
            new WordFreq("happy", 400),
            new WordFreq("satisfied", 100),
            new WordFreq("neutral", 300),
            new WordFreq("would buy again", 200),
            new WordFreq("terrible", 160),
            new WordFreq("inconvenient", 900),
            new WordFreq("difficult to use", 100),
            new WordFreq("easy to use", 140),
            new WordFreq("would recommend to friends", 800),
            new WordFreq("visit the store", 700)
        };

        // Run the function, then print it out to show order
        buildMaxHeap(wordFreqArr);
        for (int i = 0; i < wordFreqArr.length; i++) {
            System.out.println(wordFreqArr[i].toString());
        }
    }
}
