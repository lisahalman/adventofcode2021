import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day11 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day11Input.txt").toPath());
        int[][] fishies = new int[10][10];
        for (int i = 0; i < 10; i++) {
            int[] horizontal = new int[10];
            for (int j = 0; j < 10; j++) {
                horizontal[j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
            fishies[i] = horizontal;
        }
        System.out.println(Arrays.deepToString(fishies));

        int counter = 0;

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (fishies[i][j] == 9) {
//                    fishies[i][j] = 0;
//                    counter++;
//                }
//                if (i > 0 && i < 9 && j > 0 && j < 9) {
//                    if (fishies[i-1][j] > fishies[i][j] && fishies[i+1][j] > fishies[i][j] && fishies[i][j-1] > fishies[i][j] && fishies[i][j+1] > fishies[i][j]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 0 && j == 0) {
//                    if (fishies[0][1] > fishies[0][0] && fishies[1][0] > fishies[0][0]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 0 && j == 9) {
//                    if (fishies[0][98] > fishies[0][99] && fishies[1][99] > fishies[0][99]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 0) {
//                    if (fishies[0][j-1] > fishies[0][j] && fishies[0][j+1] > fishies[0][j] && fishies[1][j] > fishies[0][j]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 9 && j == 0) {
//                    if (fishies[99][1] > fishies[99][0] && fishies[98][0] > fishies[99][0]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 9 && j == 9) {
//                    if (fishies[99][98] > fishies[99][99] && fishies[98][99] > fishies[99][99]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (i == 9) {
//                    if (fishies[99][j-1] > fishies[99][j] && fishies[99][j+1] > fishies[99][j] && fishies[98][j] > fishies[99][j]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (j == 0) {
//                    if (fishies[i-1][j] > fishies[i][j] && fishies[i+1][j] > fishies[i][j] && fishies[i][j+1] > fishies[i][j]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                } else if (j == 9) {
//                    if (fishies[i-1][j] > fishies[i][j] && fishies[i+1][j] > fishies[i][j] && fishies[i][j-1] > fishies[i][j]) {
//                        lowPoints += fishies[i][j];
//                        counter++;
//                    }
//                }
//            }
//        }


    }
}