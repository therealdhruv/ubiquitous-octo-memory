package PhaseOne.Hacks;

public class TowerOfHanoi {

    public static void solveTowerOfHanoi(int n, char src, char dst, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + src + " to rod " + dst);
            return;
        }
        solveTowerOfHanoi(n - 1, src, auxRod, dst);
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dst);
        solveTowerOfHanoi(n-1, auxRod, dst, src);
    }

    public static void main(String[] args) {
        int n = 3;
        solveTowerOfHanoi(n, 'A', 'B', 'C');
    }
}
