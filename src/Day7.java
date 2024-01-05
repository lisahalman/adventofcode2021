import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Day7 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day7Input.txt").toPath());
        String[] listOfStrings = lines.get(0).split(",");
        int[] numbers = new int[listOfStrings.length];
        for (int i = 0; i < listOfStrings.length; i++) {
            numbers[i] = Integer.parseInt(listOfStrings[i]);
        }
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        long fuel1 = 10000000000000L;
        int count1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int difference = numbers[j] - numbers[i];
                difference = Math.abs(difference);
                count1 += difference;
            }
            if (count1 < fuel1) {
                fuel1 = count1;
            }
            count1 = 0;
        }
        System.out.println("Part 1: " + fuel1);
        //second part
        BigInteger fuel2 = new BigInteger("1000000000000000");
        BigInteger count2 = new BigInteger("0");
        int max = numbers[numbers.length - 1];
        for (int i = 0; i < max - 1; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int difference = i - numbers[j];
                difference = Math.abs(difference);
                if (difference >= 2) {
                    count2 = count2.add(BigInteger.valueOf((long) difference * ((long) difference + 1) / (long) 2));
                } else {
                    count2 = count2.add(BigInteger.valueOf(difference));
                }
            }
            if (count2.compareTo(fuel2) < 0) {
                fuel2 = count2;
            }
            count2 = BigInteger.valueOf(0);
        }
        System.out.println("Part 2: " + fuel2);
    }
}