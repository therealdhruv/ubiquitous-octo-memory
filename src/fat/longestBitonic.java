import java.util.*;

class longestBitonic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int maxLength = calculate(arr, n);

        System.out.println(maxLength);

        sc.close();
    }

    private static int calculate(int[] arr, int n) {

        int i, j;

        int[] lis = new int[n];
        for (i = 0; i < n; i++)
            lis[i] = 1;

        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        int[] lds = new int[n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        for (i = n - 2; i >= 0; i--)
            for (j = n - 1; j > i; j--)
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;

        /* Return the maximum value of lis[i] + lds[i] - 1 */
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return max;
    }
}
