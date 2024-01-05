import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day6 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day6Input.txt").toPath());
        String[] listOfStrings = lines.get(0).split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String ofString : listOfStrings) {
            numbers.add(Integer.parseInt(ofString));
        }
        int number;
        for (int i = 0; i < 80; i++) {
            int newSize = numbers.size();
            for (int j = 0; j < newSize; j++) {
                if (numbers.get(j) == 0) {
                    numbers.set(j, 6);
                    numbers.add(8);
                } else {
                    number = numbers.get(j);
                    int newNumber = number - 1;
                    numbers.set(j, newNumber);
                }
            }
        }
        System.out.println("Part 1: " + numbers.size());
        //second part
        List<Integer> newNumbers = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            newNumbers.add(Integer.parseInt(listOfString));
        }
        long count0 = 0L;
        long count1 = 0L;
        long count2 = 0L;
        long count3 = 0L;
        long count4 = 0L;
        long count5 = 0L;
        long count6 = 0L;
        long count7 = 0L;
        long count8 = 0L;
        for (Integer newNumber : newNumbers) {
            switch (newNumber) {
                case 0 -> count0 = count0 + 1L;
                case 1 -> count1 = count1 + 1L;
                case 2 -> count2 = count2 + 1L;
                case 3 -> count3 = count3 + 1L;
                case 4 -> count4 = count4 + 1L;
                case 5 -> count5 = count5 + 1L;
                case 6 -> count6 = count6 + 1L;
                case 7 -> count7 = count7 + 1L;
                case 8 -> count8 = count8 + 1L;
            }
        }
        for (int i = 0; i < 256; i++) {
            long holdNumber;
            holdNumber = count0;
            count0 = count1;
            count1 = count2;
            count2 = count3;
            count3 = count4;
            count4 = count5;
            count5 = count6;
            count6 = count7 + holdNumber;
            count7 = count8;
            count8 = holdNumber;
        }
        System.out.println("Part 2: " + (count0 + count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8));
    }
}