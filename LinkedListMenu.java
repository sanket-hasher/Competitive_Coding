package CompetitiveCoding;

import java.util.Scanner;

public class LinkedListMenu {
    Node start = null;
    static Scanner sc = new Scanner(System.in); // Global Scanner

    public static void main(String[] args) {
        LinkedListMenu obj = new LinkedListMenu();
        int option;
        do {
            System.out.println("\n1. Create a list");
            System.out.println("2. Display a list");
            System.out.println("3. Count the number of nodes");
            System.out.println("4. Reverse the linked list");
            System.out.println("5. Number of occurrences of a given element");
            System.out.println("6. Middle element");
            System.out.println("7. Find kth element from List");
            System.out.println("8. Insert into nth position in List");
            System.out.println("9. Remove nth element from last");
            System.out.println("10. Rotate Clockwise by Kth node");
            System.out.println("12. Odd Even Linked List");
            System.out.println("13. Swap Nodes in Pairs");
            System.out.println("14. Palindrome Linked List");
            System.out.println("15. Remove duplicates from Sorted Linked List");
            System.out.println("16. Delete the middle element");
            System.out.println("11. EXIT");
            System.out.print("Enter Your Choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    obj.start = obj.create_ll(obj.start);
                    System.out.println("List created successfully.");
                    break;
                case 2:
                    System.out.print("Current List: ");
                    obj.display(obj.start);
                    break;
                case 3:
                    obj.no_of_node(obj.start);
                    break;
                case 4:
                    obj.start = obj.reverse_ll(obj.start);
                    System.out.println("The linked list has been reversed.");
                    break;
                case 5:
                    obj.no_of_occurance(obj.start);
                    break;
                case 6:
                    obj.middle_element(obj.start);
                    break;
                case 7:
                    obj.find_kth_element(obj.start);
                    break;
                case 8:
                    obj.start = obj.insert_into_nth_position(obj.start);
                    System.out.println("Node inserted successfully (if position was valid).");
                    break;
                case 9:
                    obj.start = obj.remove_nth_element_from_end(obj.start);
                    System.out.println("Node removed from end (if position was valid).");
                    break;
                case 10:
                    System.out.print("Enter K (rotate by): ");
                    int k = sc.nextInt();
                    obj.start = obj.rotate_list_clockwise_by_kth_node(obj.start, k);
                    System.out.println("List rotated clockwise by " + k + " positions.");
                    break;
                case 12:
                    obj.start = obj.oddEvenList(obj.start);
                    System.out.println("Converted to Odd-Even List.");
                    break;
                case 13:
                    obj.start = obj.swapPairs(obj.start);
                    System.out.println("Nodes swapped in pairs.");
                    break;
                 case 14:
                    obj.palindromeLinkedList(obj.start);
                    break;
                case 15:
                    obj.start = obj.removeDuplicatesSorted(obj.start);
                    System.out.println("Removed duplicates from sorted linked list.");
                    break;
                case 16:
                    obj.start = obj.deleteMiddleElement(obj.start);
                    System.out.println("Middle element deleted (if list not empty).");
                    break;
                case 11:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 11);
        sc.close();
    }

    public Node create_ll(Node start) {
        System.out.println("Enter -1 to Exit.");
        System.out.print("Enter the value: ");
        int num = sc.nextInt();
        Node tail = null;
        while (num != -1) {
            Node newNode = new Node(num);
            if (start == null) {
                start = newNode;
                tail = start;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            System.out.print("Enter the data: ");
            num = sc.nextInt();
        }
        return start;
    }

    public void display(Node start) {
        if (start == null) {
            System.out.println("Linked List is Empty");
        } else {
            Node ptr = start;
            while (ptr != null) {
                System.out.print(ptr.data + "\t");
                ptr = ptr.next;
            }
            System.out.println();
        }
    }

    public void no_of_node(Node start) {
        int count = 0;
        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        System.out.println("The number of nodes in the Linked List: " + count);
    }

    public Node reverse_ll(Node start) {
        Node prev = null, current = start, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void no_of_occurance(Node start) {
        System.out.print("Enter the value: ");
        int num = sc.nextInt();
        int count = 0;
        Node ptr = start;
        while (ptr != null) {
            if (ptr.data == num) {
                count++;
            }
            ptr = ptr.next;
        }
        System.out.println("Number of occurrences of " + num + ": " + count);
    }

    public void middle_element(Node start) {
        int length = 0;
        Node ptr = start;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        if (length == 0) {
            System.out.println("List is empty.");
            return;
        }
        Node mid = start;
        for (int i = 0; i < length / 2; i++) {
            mid = mid.next;
        }
        System.out.println("Middle element is: " + mid.data);
    }

    public void find_kth_element(Node start) {
        System.out.print("Enter the position value: ");
        int position = sc.nextInt();
        int count = 1;
        Node ptr = start;
        while (ptr != null) {
            if (count == position) {
                System.out.println("The value at position " + position + " is: " + ptr.data);
                return;
            }
            ptr = ptr.next;
            count++;
        }
        System.out.println("Position out of bounds.");
    }

    public Node insert_into_nth_position(Node start) {
        System.out.print("Enter the position value: ");
        int pos = sc.nextInt();
        System.out.print("Enter value of new node: ");
        int val = sc.nextInt();
        Node newNode = new Node(val);
        if (pos == 1) {
            newNode.next = start;
            start = newNode;
            return start;
        }
        Node ptr = start, prev = null;
        int count = 1;
        while (ptr != null && count < pos) {
            prev = ptr;
            ptr = ptr.next;
            count++;
        }
        if (prev == null) {
            System.out.println("Position out of bounds (no node inserted).");
            return start;
        }
        prev.next = newNode;
        newNode.next = ptr;
        return start;
    }

    public Node remove_nth_element_from_end(Node start) {
        System.out.print("Enter the n value: ");
        int n = sc.nextInt();
        int length = 0;
        Node ptr = start;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        int n_node = length - n + 1;
        if (n_node <= 0) {
            System.out.println("Invalid n (nothing removed).");
            return start;
        }
        if (n_node == 1) {
            start = start.next;
            return start;
        }
        ptr = start;
        Node prevptr = null;
        int count = 1;
        while (ptr != null && count < n_node) {
            prevptr = ptr;
            ptr = ptr.next;
            count++;
        }
        if (ptr != null && prevptr != null) {
            prevptr.next = ptr.next;
        }
        return start;
    }

    public Node rotate_list_clockwise_by_kth_node(Node start, int k) {
        if (start == null || k <= 0) {
            System.out.println("No rotation performed (empty list or non-positive k).");
            return start;
        }
        Node ptr = start;
        int length = 1;
        while (ptr.next != null) {
            ptr = ptr.next;
            length++;
        }
        if (k % length == 0) {
            System.out.println("Rotation by " + k + " has no effect (full round).");
            return start;
        }
        k = k % length;
        ptr.next = start;
        ptr = start;
        for (int i = 1; i < length - k; i++) {
            ptr = ptr.next;
        }
        start = ptr.next;
        ptr.next = null;
        return start;
    }

    public Node oddEvenList(Node head) {
        if (head == null) return null;
        Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = prev.next.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummy.next;
    }

    public void palindromeLinkedList(Node start) {
        if (start == null || start.next == null) {
            System.out.println("List is palindrome.");
            return;
        }
        // Find middle using slow and fast pointers
        Node slow = start, fast = start;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        Node secondHalf = reverse_ll(slow);
        Node firstHalf = start;

        boolean isPalindrome = true;
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        // Restore the second half to original
        reverse_ll(secondHalf);

        if (isPalindrome) System.out.println("The list is a palindrome.");
        else System.out.println("The list is NOT a palindrome.");
    }

    public Node removeDuplicatesSorted(Node start) {
        if (start == null) {
            System.out.println("List is empty; nothing to remove.");
            return start;
        }
        Node current = start;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return start;
    }

    public Node deleteMiddleElement(Node start) {
        if (start == null) {
            System.out.println("List is empty, no middle element to delete.");
            return start;
        }
        if (start.next == null) {
            // Single node list, delete head
            start = null;
            return start;
        }
        Node slow = start, fast = start, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // slow is middle node, remove it
        prev.next = slow.next;
        return start;
    }
}
