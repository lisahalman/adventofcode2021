import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

public class Day9 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day9Input.txt").toPath());
        int[][] cave = new int[100][100];

        for (int i = 0; i < 100; i++) {
            int[] horizontal = new int[100];
            for (int j = 0; j < 100; j++) {
                horizontal[j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
            cave[i] = horizontal;
        }
        int lowPoints = 0;
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i > 0 && i < 99 && j > 0 && j < 99) {
                    if (cave[i-1][j] > cave[i][j] && cave[i+1][j] > cave[i][j] && cave[i][j-1] > cave[i][j] && cave[i][j+1] > cave[i][j]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 0 && j == 0) {
                    if (cave[0][1] > cave[0][0] && cave[1][0] > cave[0][0]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 0 && j == 99) {
                    if (cave[0][98] > cave[0][99] && cave[1][99] > cave[0][99]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 0) {
                    if (cave[0][j-1] > cave[0][j] && cave[0][j+1] > cave[0][j] && cave[1][j] > cave[0][j]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 99 && j == 0) {
                    if (cave[99][1] > cave[99][0] && cave[98][0] > cave[99][0]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 99 && j == 99) {
                    if (cave[99][98] > cave[99][99] && cave[98][99] > cave[99][99]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (i == 99) {
                    if (cave[99][j-1] > cave[99][j] && cave[99][j+1] > cave[99][j] && cave[98][j] > cave[99][j]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (j == 0) {
                    if (cave[i-1][j] > cave[i][j] && cave[i+1][j] > cave[i][j] && cave[i][j+1] > cave[i][j]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                } else if (j == 99) {
                    if (cave[i-1][j] > cave[i][j] && cave[i+1][j] > cave[i][j] && cave[i][j-1] > cave[i][j]) {
                        lowPoints += cave[i][j];
                        counter++;
                    }
                }
            }
        }
        System.out.println("Part 1: " + (lowPoints + counter));
        //second part
        


    }

    public static void getBasins(int[][] cave, int currentX, int currentY, Set<String> basin, Set<String> visited) {

    }
}