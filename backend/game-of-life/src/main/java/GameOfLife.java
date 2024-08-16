import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        gameOfLife();
    }

    private static void gameOfLife() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the length ");
        int length = sc.nextInt();
        System.out.println("Give the width ");
        int width = sc.nextInt();
        int[][] randomState = previousState(length, width);
        System.out.println(("first generation"));
        printState(randomState);
        System.out.println("How many generation do you want?");
        int totalGenerations = sc.nextInt();
        int[][] nextState = nextState(randomState, length, width);
        System.out.println("next generation");
        printState(nextState);
        for (int i = 0; i < totalGenerations - 1; i++) {
            nextState = nextState(nextState, length, width);
            System.out.println("next generation");
            printState(nextState);
        }
    }

    private static int[][] nextState(int[][] previousState, int length, int width) {
        int[][] nextState = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int aliveNeighbors = countAliveNeighbors(previousState, i, j, length, width);
                if (previousState[i][j] == 1) {
                    // Any live cell with fewer than two live neighbors dies, as if by underpopulation
                    // Any live cell with two or three live neighbors lives on to the next generation
                    // Any live cell with more than three live neighbors dies, as if by overpopulation
                    nextState[i][j] = (aliveNeighbors < 2 || aliveNeighbors > 3) ? 0 : 1;
                } else {
                    // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
                    nextState[i][j] = (aliveNeighbors == 3) ? 1 : 0;
                }
            }
        }
        return nextState;
    }

    private static int countAliveNeighbors(int[][] previousState, int x, int y, int length, int width) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if (neighborX >= 0 && neighborX < length && neighborY >= 0 && neighborY < width
                        && !(i == 0 && j == 0)) {
                    count += previousState[neighborX][neighborY];
                }
            }
        }
        return count;
    }

    private static void printState(int[][] randomState) {
        for (int[] arrs : randomState) {
            System.out.print("|");
            for (int j : arrs) {
                if (j == 1) {
                    System.out.print("\uD83D\uDD7A");
                } else {
                    System.out.print("⚰\uFE0F");
                }
            }
            System.out.println("|");
        }
    }

    private static int[][] previousState(int length, int width) {
        int[][] randomState = new int[length][width];
        for (int i = 0; i < randomState.length; i++) {
            for (int j = 0; j < randomState[i].length; j++) {
                double number = Math.random();
                if (number >= 0.5) {
                    randomState[i][j] = 1;
                } else {
                    randomState[i][j] = 0;
                }
            }
        }
        return randomState;
    }
}
