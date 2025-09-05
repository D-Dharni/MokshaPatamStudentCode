import java.util.Collections;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        if (checkIsWinnable(ladders, snakes) == false) {
            return -1;
        }

        // make a new array list of ladder values that go up more than siz

        // make a array of snake starting points to avoid them

        // use each ladder and increment by sufficient amount

        return 0;
    }

    public static boolean checkIsWinnable(int[][] ladders, int [][] snakes) {
        int num = checkSixSnakes(snakes);
        if (num == -1) {
            return true;
        }
        else {
            int start = num;
            int end = num + 5;

            for (int[] ladder: ladders) {
                int ladderStart = ladder[0];
                int ladderEnd = ladder[1];

                if (ladderStart < start && ladderEnd > end) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int checkSixSnakes(int [][] snakes) {
        if (snakes.length < 6) {
            return -1;
        }
        int[] snakeStartingPoints = new int[snakes.length];
        for (int i = 0; i < snakes.length; i++) {
            snakeStartingPoints[i] = snakes[i][0];
        }
        bubbleSort(snakeStartingPoints);

        int consecutive = 1;

        for (int i = 1; i < snakeStartingPoints.length; i++) {
            if (snakeStartingPoints[i] == snakeStartingPoints[i - 1] + 1) {
                consecutive++;
                if (consecutive == 6) {
                    return snakeStartingPoints[i] - 5;
                }
            }
            else {
                consecutive = 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean swapped;

        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
