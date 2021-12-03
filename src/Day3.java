import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day3 {

    public static StringBuilder gamma = new StringBuilder();
    public static StringBuilder epsilon = new StringBuilder();
    public static StringBuilder previous = new StringBuilder();
    public static StringBuilder previousReverse = new StringBuilder();
    public static String CO2short;

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day3Input.txt").toPath());
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < 12; i++) {
            for (String line : lines) {
                if (line.charAt(i) == '0') {
                    countZero++;
                } else if (line.charAt(i) == '1') {
                    countOne++;
                }
            }
            if (countZero > countOne) {
                gamma.append('0');
            } else if (countOne > countZero) {
                gamma.append('1');
            }
            countZero = 1;
            countOne = 0;
        }
        System.out.println("Gamma binairy: " + gamma);
        int gam = Integer.parseInt(Day3.gamma.toString(), 2);
        System.out.println("Gamma: " + gam);
        for (int i = 0; i < 12; i++) {
            if (Day3.gamma.charAt(i) == '0') {
                epsilon.append('1');
            } else if (Day3.gamma.charAt(i) == '1') {
                epsilon.append('0');
            }
        }
        System.out.println("Epsilon binairy: " + epsilon);
        int eps = Integer.parseInt(epsilon.toString(), 2);
        System.out.println("Epsilon: " + eps);
        System.out.println("Gamma * Epsilon: " + gam * eps);
        System.out.println("----------");
        //second part
        for (int i = 0; i < 12; i++) {
            countZerosAndOnes(lines, i, previous);
        }
        System.out.println("Oxygen binairy: " + previous);
        int oxygen = Integer.parseInt(previous.toString(), 2);
        System.out.println("Oxygen: " + oxygen);
        previousReverse.setLength(0);
        for (int i = 0; i < 12; i++) {
            countZerosAndOnes(lines, i, previousReverse);
        }
        String CO2Complete = "";
        for (String line : lines) {
            if (line.contains(CO2short)) {
                CO2Complete = line;
                break;
            }
        }
        System.out.println("CO2 binairy: " + CO2Complete);
        int co2 = Integer.parseInt(CO2Complete, 2);
        System.out.println("CO2: " + co2);
        System.out.println("Oxygen * CO2: " + oxygen * co2);
    }

    public static void countZerosAndOnes(List<String> lines, int position, StringBuilder prevNumber) {
        int countZeroOxy = 0;
        int countOneOxy = 0;
            for (String line : lines) {
                if (line.startsWith(prevNumber.toString())) {
                    if (line.charAt(position) == '0') {
                        countZeroOxy++;
                    } else if (line.charAt(position) == '1') {
                        countOneOxy++;
                    }
                }
            }
            if (countZeroOxy > countOneOxy) {
                previous.append('0');
                previousReverse.append('1');
            } else if (countOneOxy > countZeroOxy) {
                previous.append('1');
                previousReverse.append('0');
            } else {
                previous.append('1');
                previousReverse.append('0');
            }
            if (countZeroOxy == 1 & countOneOxy == 1) {
                CO2short = previousReverse.toString();
            }
    }
}