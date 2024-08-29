import java.util.HashMap;

class Node {
    int data;
    int both; // This will hold the XOR of the next and previous node IDs

    public Node(int data) {
        this.data = data;
        this.both = 0;
    }
}

class XORLinkedList {
    private Node head;
    private Node tail;
    // HashMap to store Node objects by their IDs. This is necessary because Java doesn't
    // provide direct access to objects based on memory location.
    private HashMap<Integer, Node> nodes;

    public XORLinkedList() {
        this.head = this.tail = null;
        this.nodes = new HashMap<>();
    }

    private int _xor(int a, int b) {
        // Helper function to get the XOR of two IDs
        return a ^ b;
    }

    public void insertAtHead(int data) {
        // Inserts a new node with the provided data at the head of the list
        Node newNode = new Node(data);
        int newId = System.identityHashCode(newNode);
        System.out.println(newId);
        nodes.put(newId, newNode);

        if (head != null) {
            // Adjusting both values for the new node and existing head
            newNode.both = _xor(0, System.identityHashCode(head));
            head.both = _xor(newNode.both, System.identityHashCode(head));
        } else {
            // If the list is empty, the new node becomes the tail
            tail = newNode;
        }
        head = newNode;
    }

    public void insertAtTail(int data) {
        // Inserts a new node with the provided data at the tail of the list
        Node newNode = new Node(data);
        int newId = System.identityHashCode(newNode);
        nodes.put(newId, newNode);

        if (tail != null) {
            // Adjusting both values for the new node and existing tail
            newNode.both = _xor(System.identityHashCode(tail), 0);
            tail.both = _xor(newNode.both, System.identityHashCode(tail));
        } else {
            // If the list is empty, the new node becomes the head
            head = newNode;
        }
        tail = newNode;
    }

    public void deleteFromHead() {
        // Deletes the head node from the list
        if (head != null) {
            // If there's a next node after the head, update its both value
            int nextNodeId = _xor(0, head.both);
            Node nextNode = nodes.getOrDefault(nextNodeId, null);

            if (nextNode != null) {
                nextNode.both = _xor(System.identityHashCode(head), nextNode.both);
            } else {
                tail = null;
            }

            // Remove the current head from the nodes HashMap and update the head pointer
            nodes.remove(System.identityHashCode(head));
            head = nextNode;
        }
    }

    public void deleteFromTail() {
        // Deletes the tail node from the list
        if (tail != null) {
            // If there's a previous node before the tail, update its both value
            int prevNodeId = _xor(tail.both, 0);
            Node prevNode = nodes.getOrDefault(prevNodeId, null);

            if (prevNode != null) {
                prevNode.both = _xor(System.identityHashCode(tail), prevNode.both);
            } else {
                head = null;
            }

            // Remove the current tail from the nodes HashMap and update the tail pointer
            nodes.remove(System.identityHashCode(tail));
            tail = prevNode;
        }
    }

    public void printList() {
        // Prints the entire list from head to tail
        Node current = head;
        int prevId = 0;
        while (current != null) {
            System.out.print(current.data + " ");
            // Compute the ID of the next node
            int nextId = _xor(prevId, current.both);

            // Move the pointers
            prevId = System.identityHashCode(current);
            current = nodes.getOrDefault(nextId, null);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        XORLinkedList list = new XORLinkedList();
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.printList(); // Expected: 20 10 30 40
        list.deleteFromHead();
        list.printList(); // Expected: 10 30 40
        list.deleteFromTail();
        list.printList(); // Expected: 10 30
    }
}
