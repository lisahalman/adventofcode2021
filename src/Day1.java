import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day1Input.txt").toPath());
        int count = 0;
        int start = Integer.parseInt(lines.get(0));
        for (String line : lines) {
            int number = Integer.parseInt(line);
            if (number > start) {
                count++;
            }
            start = number;
        }
        System.out.println(count);
        //second part
        int counter = 0;
        int sumOfThreeNumbers;
        List<Integer> sums = new ArrayList() ;
        for (int i = 0; i < (lines.size() - 2); i++) {
            int first = counter;
            int second = counter + 1;
            int third = counter + 2;
            sumOfThreeNumbers = Integer.parseInt(lines.get(first)) + Integer.parseInt(lines.get(second)) + Integer.parseInt(lines.get(third));
            sums.add(sumOfThreeNumbers);
            counter++;
        }
        int startingNumberSums = sums.get(0);
        int counterSums = 0;
        for (int sum : sums) {
            if (sum > startingNumberSums) {
                counterSums++;
            }
            startingNumberSums = sum;
        }
        System.out.println(counterSums);
    }
}
