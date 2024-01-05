import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day13 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day13Input.txt").toPath());
        int largestX = 0;
        int largestY = 0;
        for (int i = 0; i < 950; i++) {
            String[] XandY;
            XandY = lines.get(i).split(",");
            if (Integer.parseInt(XandY[0]) > largestX) {
                largestX = Integer.parseInt(XandY[0]);
            }
            if (Integer.parseInt(XandY[1]) > largestY) {
                largestY = Integer.parseInt(XandY[1]);
            }
        }
        System.out.println("Largest X: " + largestX);
        System.out.println("Largest Y: " + largestY);
        String[][] grid = new String[largestY + 1][largestX + 1];
        for (int i = 0; i < largestY + 1; i++) {
            for (int j = 0; j < largestX + 1; j++) {
                grid[i][j] = ".";
            }
        }
        for (int i = 0; i < 950; i++) {
            String[] XandY;
            XandY = lines.get(i).split(",");
            int x = Integer.parseInt(XandY[0]);
            int y = Integer.parseInt(XandY[1]);
            grid[y][x] = "#";
        }
        //System.out.println(Arrays.deepToString(grid));
        int[] foldlines = new int[12];
        for (int i = 0; i < 12; i++) {
            String[] getNumber;
            getNumber = lines.get(i + 951).split("=");
            foldlines[i] = Integer.parseInt(getNumber[1]);
        }
        System.out.println(Arrays.toString(foldlines));



    }
}