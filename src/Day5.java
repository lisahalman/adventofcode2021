import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day5Input.txt").toPath());
        //List<List<Integer>> coordinates = getCoordinates(lines);
    }

//    public static List<List<Integer>> getCoordinates(List<String> lines) {
//        List<Integer> coordinatesOnLine = new ArrayList<>();
//        for (int i = 0; i < lines.size(); i++) {
//            coordinatesOnLine.add(List.of(lines.get(i).trim().split("\s+")));
//
//        }
//        return coordinates;
//    }
}