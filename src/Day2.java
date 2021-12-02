import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day2Input.txt").toPath());
        int forward = 0;
        int depth = 0;
        for (String line : lines) {
            if (line.charAt(0) == 'f') {
                forward += Integer.parseInt(line.substring(line.length() - 1));
            } else if (line.charAt(0) == 'd') {
                depth += Integer.parseInt(line.substring(line.length() - 1));
            } else if (line.charAt(0) == 'u') {
                depth -= Integer.parseInt(line.substring(line.length() - 1));
            }
        }
        System.out.println(forward * depth);
        //second part
        int newForward = 0;
        int newDepth = 0;
        int aim = 0;
        for (String line : lines) {
            if (line.charAt(0) == 'f') {
                newForward += Integer.parseInt(line.substring(line.length() - 1));
                newDepth += (Integer.parseInt(line.substring(line.length() - 1)) * aim);
            } else if (line.charAt(0) == 'd') {
                aim += Integer.parseInt(line.substring(line.length() - 1));
            } else if (line.charAt(0) == 'u') {
                aim -= Integer.parseInt(line.substring(line.length() - 1));
            }
        }
        System.out.println(newDepth * newForward);
    }
}