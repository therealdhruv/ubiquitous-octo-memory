package PhaseOne;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new SolutionMaxSlide().maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


class SolutionMaxSlide {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }
}


/*
 * N: Number of elements and K: Window size
 *
 * There are 4 main approaches -
 *
 * (i) Naive Approach (Time Complexity: O(N * k) and Space Complexity: O(N - k + 1))
 *
 * (ii) Self Balancing Tree (Time Complexity: O(N * log(k)) and Space Complexity: O(k))
 *
 * (iii) Max-Heap (Time Complexity: O(N * log(k)) and Space Complexity: O(k))
 *
 * (iv) Deque (Time Complexity: O(N) and Space Complexity: O(k))  [Best]
 *
 * */
