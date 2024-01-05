import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day16 {

    public static void main(String[] args) throws IOException {
        //first part
        //List<String> lines = Files.readAllLines(new File("Day16Input.txt").toPath());
        List<String> lines = Files.readAllLines(new File("Day16Test.txt").toPath());
        String allBits = hexToBin(lines.get(0));
        System.out.println(allBits);
        List<String> version = new ArrayList<>();
        List<String> literals = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < allBits.length();) {
            String getVersion = allBits.substring(i, i+3);
            i = i+3;
            version.add(getVersion);
            String getTypeID = allBits.substring(i, i+3);
            i = i+3;
            if (getTypeID.equals("100")) {
                int counter = 0;
                while (allBits.charAt(i) == '1') {
                    literals.add(allBits.substring(i+1, i+5));
                    i = i+5;
                    counter++;
                }
                i = i+5;
                counter++;
                int leadingZeros = 4 - (((counter * 5) + 6) % 4);
                i = i + leadingZeros;
            } else {
//                if (allBits.charAt(i+1) == '0') {
//                    i = i+1;
//                    String numberOfSubPackets = allBits.substring(i, i+15);
//                    int number = Integer.parseInt(numberOfSubPackets, 2);
//
//                } else {
//
//                }
            }
        }
    }

    private static String hexToBin(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }
}