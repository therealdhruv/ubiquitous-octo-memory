package PhaseOne.Hacks;


public class SortBitonicDLL {

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node reverse(Node head_ref) {

        Node temp = null;
        Node current = head_ref;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;

        }

        if (temp != null) head_ref = temp.prev;
        return head_ref;

    }


    static Node merge(Node first, Node second) {

        if (first == null) return second;
        if (second == null) return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            if (first.next != null) first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null) second.next.prev = second;
            second.prev = null;
            return second;
        }

    }

    static Node sort(Node head) {

        if (head == null || head.next == null) return head;

        Node curr = head.next;
        while (curr != null) {
            if (curr.data < curr.prev.data) break;
            curr = curr.next;
        }

        if (curr == null) return head;
        curr.prev.next = null;
        curr.prev = null;
        curr = reverse(curr);
        return merge(head, curr);

    }

    static Node push(Node head_ref, int new_data) {

        Node new_node = new Node();
        new_node.data = new_data;

        new_node.next = head_ref;
        new_node.prev = null;

        if (head_ref != null) head_ref.prev = new_node;
        head_ref = new_node;

        return head_ref;

    }

    static void printList(Node head) {
        if (head == null) System.out.println("empty");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 6);
        head = push(head, 10);
        head = push(head, 12);
        head = push(head, 7);
        head = push(head, 5);
        head = push(head, 2);

        System.out.print("\nOriginal List: ");
        printList(head);

        head = sort(head);

        System.out.print("\n\nSorted List: ");
        printList(head);
    }

}


/*
 *
 * Time complexity - O(N^2)
 *
 * Space complexity - O(1)
 *
 * */