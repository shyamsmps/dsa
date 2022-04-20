package algo.standard.algorithms;

/**
 * Given three pegs A, B, C (spare),  move all n disks from peg A to peg B
 * Rule 1. You may move only one disk at a time.
 * Rule 2. No disk may ever rest atop a smaller disk.
 *          For example, if disk 3 is on a peg, then all disks below disk 3 must have numbers greater than 3.
 * solving a problem for n disks requires 2^n - 1 moves.
 *          We've seen that it's true for n = 1 (2^1 - 1 = 1,  and we needed one move),
 *          n = 2 (2^2 - 1 = 3, and three moves),
 *          n = 3 (2^3 - 1 = 7,  and seven moves) ...
 */
public class TowersOfHanoi {

    public static int counter = 0;

    public static void main(String[] args) {
        solveHanoi(5, 0, 1);
        System.out.println(counter);
    }

    public static void solveHanoi(int disks, int fromPeg, int toPeg) {
        if (disks == 0) {
            return;
        }
        if (disks == 1) {
            moveDisk(fromPeg, toPeg);
            return;
        }
        if (disks == 2) {
            moveDisk(fromPeg, getSparePeg(fromPeg, toPeg));
            moveDisk(fromPeg, toPeg);
            moveDisk(getSparePeg(fromPeg, toPeg), toPeg);
            return;
        }
        solveHanoi(disks-1, fromPeg, getSparePeg(fromPeg, toPeg));
        moveDisk(fromPeg, toPeg);
        solveHanoi(disks-1, getSparePeg(fromPeg, toPeg), toPeg);
    }

    public static void moveDisk(int from, int to) {
        counter++;
    }

    public static int getSparePeg(int from, int to) {
        return 2;
    }
}
