// Define Node class
class Node {
    int key;
    Node next;

    // Create constructor
    public Node (int key) {
        this.key = key;
        this.next = null;
    }

    // Methods
    // Insert
    static Node listInsert(Node head, Node x) {
        x.next = head;
        return x;
    }

    // Search
    static Node listSearch(Node head, int key) {
        // Initiate the current node
        Node current = head;

        // Traverse through the list and return current if key matches
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }

        // Return null if no matches are found
        return null;
    }

    // Delete
    static Node listDelete(Node head, Node x) {
        // Check if the list is empty or if selected node is at the head
        if (head == null) {
            return x;
        }
        if (head == x) {
            return head.next;
        }

        Node current = head;
        Node prevNode = null;

        // Traverse through list and delete if found, else keep traversing
        while (current != null) {
            if (current == x) {
                prevNode.next = current.next;
                return head;
            }
            prevNode = current;
            current = current.next;
        }

        // Return the list
        return head;
    }

    // Make printing a method
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Assignment 2: Palindrome Check
    static Node left;
    static boolean palindromeCheck(Node head) {
        // Base Case
        if (head == null) {
            return true;
        }

        // Recursive call
        boolean result = palindromeCheck(head.next);

        // If there is no result, false
        if (!result) {
            return false;
        }

        // Compare the left and right values
        if (left.key != head.key) {
            return false;
        }

        // Move left pointer to next node
        left = left.next;
        return true;
    }
}

public class HW4 {
    // Assignment 3: Elevation Map
    public static int trappedWater (int height[]) {
        // Initialize variables
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        // Loop until we iterate through whole array
        while (leftPtr < rightPtr) {
            if (height[leftPtr] < height[rightPtr]) {
                // If current wall is larger than previous walls, update leftMax
                if (height[leftPtr] >= leftMax) {
                    leftMax = height[leftPtr];
                } else { // Else water can be trapped, calculated by difference of leftMax and current height
                    water += leftMax - height[leftPtr]; 
                }
                leftPtr++;
            } else {
                // Same logic for right side
                if (height[rightPtr] >= rightMax) {
                    rightMax = height[rightPtr];
                } else {
                    water += rightMax - height[rightPtr];
                }
                rightPtr--;
            }
        }

        // Return the accumulated water
        return water;
    }
    public static void main(String[] args) {
        // Do main method requirements
        System.out.println("Assignment 1: ");
        Node head = null;

        // Insertions
        head = Node.listInsert(head, new Node(1));
        head = Node.listInsert(head, new Node(2));
        head = Node.listInsert(head, new Node(3));

        System.out.print("Initial list: ");
        Node.printList(head);

        // Search, delete, and print
        Node find = Node.listSearch(head, 2);
        if (find != null) {
            System.out.println("Node found, key: " + find.key);
        } else {
            System.out.println("Not found");
        }

        head = Node.listDelete(head, find);
        System.out.print("New list: ");
        Node.printList(head);

        // Assignment 2
        System.out.println();
        System.out.println("Assignment 2: ");

        // Empty list for assignment 2, then insert to test
        head = null;

        head = Node.listInsert(head, new Node(1));
        head = Node.listInsert(head, new Node(2));
        head = Node.listInsert(head, new Node(3));
        head = Node.listInsert(head, new Node(2));
        head = Node.listInsert(head, new Node(1));
        System.out.print("Tested list: ");
        Node.printList(head);

        Node.left = head;
        boolean result = Node.palindromeCheck(head);
        System.out.println("Is palindrome? " + result); // Expect True

        // Empty list then insert
        head = null;

        head = Node.listInsert(head, new Node(10));
        head = Node.listInsert(head, new Node(20));
        head = Node.listInsert(head, new Node(20));
        head = Node.listInsert(head, new Node(10));
        System.out.print("Tested list: ");
        Node.printList(head);

        Node.left = head;
        result = Node.palindromeCheck(head);
        System.out.println("Is palindrome? " + result); // Expect True

        // Empty list then insert
        head = null;

        head = Node.listInsert(head, new Node(5));
        head = Node.listInsert(head, new Node(10));
        head = Node.listInsert(head, new Node(17));
        System.out.print("Tested list: ");
        Node.printList(head);

        Node.left = head;
        result = Node.palindromeCheck(head);
        System.out.println("Is palindrome? " + result); // Expect False

        // Assignment 3
        System.out.println();
        System.out.println("Assignment 3: ");

        int elevationMap[] = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};
        int waterResults = trappedWater(elevationMap);
        System.out.println("Trapped water: " + waterResults + " units");
    }
}
