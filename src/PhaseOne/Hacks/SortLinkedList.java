package PhaseOne.Hacks;
import java.util.*;

public class SortLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();

        l.add(6);
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(2);
        l.add(1);
        l.add(-40);
        l.add(40);

        System.out.println("Linked list is: " + l);

        Collections.sort(l);

        System.out.println("The sorted linked list is: " + l);
    }
}
