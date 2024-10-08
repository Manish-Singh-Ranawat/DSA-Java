public class LinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Adds a new node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Adds a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Adds a node at a specific index in the list
    public void addAtIndex(int data, int index) {
        int size = size();
        if (index < 0 || index > size) {
            System.out.println("Index Out of Bound");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        int i = 0;
        Node temp = head;
        while (i != (index - 1)) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Adds a node before the first occurrence of a given element
    public void addBeforeElement(int data, int element) {
        int index = search(element);
        if (index != -1) {
            addAtIndex(data, index);
        } else {
            System.out.println("Element not found");
        }
    }

    // Removes the first element in the list
    public void removeFirst() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        head = head.next;
    }

    // Removes the last element in the list
    public void removeLast() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Removes a node at a specific index
    public void removeAtIndex(int index) {
        int size = size();
        if (index < 0 || index >= size) {
            System.out.println("Index Out of Bound");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node temp = head;
        int i = 0;
        while (i != (index - 1)) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    // Removes the first occurrence of a node with a specific data value
    public void removeElement(int element) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head.data == element) {
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == element) {
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Element not found");
    }

    // Searches for the first occurrence of data and returns its index
    public int search(int data) {
        if (head == null) {
            return -1;
        }
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    // Method to return the size of the linked list
    public int size() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    // Prints the elements of the linked list
    public void print() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Adding elements at the beginning
        System.out.println("Adding elements at the beginning:");
        ll.addFirst(3); // List: 3
        ll.addFirst(2); // List: 2 -> 3
        ll.addFirst(1); // List: 1 -> 2 -> 3
        ll.print(); // Output: 1 2 3

        // Adding elements at the end
        System.out.println("Adding elements at the end:");
        ll.addLast(4); // List: 1 -> 2 -> 3 -> 4
        ll.addLast(5); // List: 1 -> 2 -> 3 -> 4 -> 5
        ll.print(); // Output: 1 2 3 4 5

        // Adding element at index
        System.out.println("Adding element at index 2:");
        ll.addAtIndex(10, 2); // List: 1 -> 2 -> 10 -> 3 -> 4 -> 5
        ll.print(); // Output: 1 2 10 3 4 5

        // Adding element before a specific element
        System.out.println("Adding element 15 before element 3:");
        ll.addBeforeElement(15, 3); // List: 1 -> 2 -> 10 -> 15 -> 3 -> 4 -> 5
        ll.print(); // Output: 1 2 10 15 3 4 5

        // Searching for an element
        System.out.println("Searching for element 10:");
        int index = ll.search(10); // Finds element 10
        if (index != -1) {
            System.out.println("Element 10 found at index: " + index);
        } else {
            System.out.println("Element 10 not found.");
        }

        // Removing the first element
        System.out.println("Removing the first element:");
        ll.removeFirst(); // List: 2 -> 10 -> 15 -> 3 -> 4 -> 5
        ll.print(); // Output: 2 10 15 3 4 5

        // Removing the last element
        System.out.println("Removing the last element:");
        ll.removeLast(); // List: 2 -> 10 -> 15 -> 3 -> 4
        ll.print(); // Output: 2 10 15 3 4

        // Removing element at index
        System.out.println("Removing element at index 1:");
        ll.removeAtIndex(1); // List: 2 -> 15 -> 3 -> 4
        ll.print(); // Output: 2 15 3 4

        // Removing a specific element
        System.out.println("Removing element 15:");
        ll.removeElement(15); // List: 2 -> 3 -> 4
        ll.print(); // Output: 2 3 4

        // Display size of the linked list
        System.out.println("Size of linked list: " + ll.size()); // Output: 3
    }
}
