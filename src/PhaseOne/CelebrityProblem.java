package PhaseOne;

import java.io.*;
import java.util.*;

public class CelebrityProblem {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] relationshipMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                relationshipMatrix[i][j] = sc.nextInt();
            }
        }

        int celebID = new Solution().findCeleb(relationshipMatrix, n);
        if (celebID != -1) System.out.println("Celebrity ID is: " + celebID);
        else System.out.println("No celebrity exist");

        sc.close();
    }
}

class Solution {
    int findCeleb(int[][] m, int n) {

        int candidate = 0;

        for (int i = 0; i < n; i++) {
            if (m[candidate][i] == 1) candidate = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && (m[candidate][i] == 1 || m[i][candidate] == 0)) return -1;
        }


        return candidate;

    }
}

/*
*
* Time complexity - O(N)
*
* Space complexity - O(N)
*
* */
