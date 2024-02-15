package PhaseOne;

import java.util.Arrays;

public class StockSpan {

    static int[] calculateSpan(int[] sharePrices) {

        int n = sharePrices.length;
        int[] span = new int[n];
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            span[i] = 1;
            int j = i - 1;
            while (j > 0 && sharePrices[i] >= sharePrices[j]) {
                span[i]++;
                j--;
            }
        }

        return span;

    }

    public static void main(String[] args) {
        int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(stockPrices);
        System.out.println("Share prices " + Arrays.toString(stockPrices));
        System.out.println("Share span " + Arrays.toString(span));
    }
}
