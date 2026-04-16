public class Main {

    // Node definition
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    // Insert at end
    static Node insert(Node head, char data) {
        Node newNode = new Node(data);

        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

    // Find middle using slow-fast pointer
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Check palindrome
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node middle = findMiddle(head);

        // Step 2: Reverse second half
        Node secondHalf = reverse(middle);

        // Step 3: Compare first and second half
        Node firstHalf = head;
        Node tempSecond = secondHalf;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Print list (debug helper)
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        String input = "racecar"; // try "hello" or "madam"

        Node head = null;

        // Convert string to linked list
        for (char c : input.toCharArray()) {
            head = insert(head, c);
        }

        System.out.println("Linked List:");
        print(head);

        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome? " + result);
    }
}