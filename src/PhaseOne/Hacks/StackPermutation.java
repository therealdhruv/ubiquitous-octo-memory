package PhaseOne.Hacks;

import java.util.Stack;

public class StackPermutation {

    public static boolean isStackPermutation(int[] original, int[] target) {

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int a: original) {
            stack.push(a);
            while (!stack.isEmpty() && stack.peek() == target[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int[] target = {2, 1, 3};
        boolean result = isStackPermutation(original, target);

        System.out.println(result);

    }
}


/*
 *
 * Time complexity - O(N)
 *
 * Space Complexity - O(N)
 *
 * */
