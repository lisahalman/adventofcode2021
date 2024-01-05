import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Day4 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day4Input.txt").toPath());
        String[] numbersInStringArray = lines.get(0).split(",");
        int[] numbersCalled = new int[numbersInStringArray.length];
        for (int i = 0; i < numbersInStringArray.length; i++) {
            numbersCalled[i] = Integer.parseInt(numbersInStringArray[i]);
        }
        System.out.println(Arrays.toString(numbersCalled));

        List<String> linesForBingo = lines;
        linesForBingo.remove(0);
        linesForBingo.remove(0);


        List<int[][]> boards = new ArrayList<>();
        List<String> splitBoards = List.of(String.join("\n", linesForBingo).split("\n\n"));
        for (String board : splitBoards) {
            boards.add(makeBoard(board));
        }

        List<int[][]> wonBoards = new ArrayList<>();
        List<Integer> bingoDone = new ArrayList<>();
        for (int i = 0; i < numbersCalled.length; i++) {
            bingoDone.add(i);
            for (int[][] board : boards) {
                if (checkBoard(bingoDone, board) && !wonBoards.contains(board)) {
                    wonBoards.add(board);
                    if (wonBoards.size() == 1) {
                        String result1 = "" + sumUnmarked(bingoDone, board) * i;
                        System.out.println(result1);
                    }


                }
            }
        }
    }

    public static int[][] makeBoard(String linesForBingo) {
        int[][] board = new int[5][5];
        List<String> rowStringArray = new ArrayList<>(List.of(linesForBingo.split("\n")));
        for (int i = 0; i < 5; i++) {
            List<String> line = new ArrayList<>(List.of(rowStringArray.get(i).trim().split("\s+")));
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line.get(j));
            }
        }
        System.out.println(Arrays.deepToString(board));
        return board;
    }


    public static boolean checkBoard(List<Integer> hits, int[][] board) {
        for (int ver = 0; ver < 5; ver++) {
            int counter = 0;
            for (int hor = 0; hor < 5; hor++) {
                if (hits.contains(board[ver][hor])) {
                    counter++;
                    if (counter == 5) {
                        return true;
                    }
                }

            }
        }
        for (int hor = 0; hor < 5; hor++) {
            int counter = 0;
            for (int ver = 0; ver < 5; ver++) {
                if (hits.contains(board[ver][hor])) {
                    counter++;
                    if (counter == 5) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static int sumUnmarked(List<Integer> hits, int[][] input) {
        int count = 0;
        for (int[] sub : input) {
            for (int number : sub) {
                if (!hits.contains(number)) {
                    count += number;
                }
            }
        }
        return count;
    }

}
