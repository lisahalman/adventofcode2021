import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day15 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day15Input.txt").toPath());
        int maxHorizontal = lines.get(0).length();
        int maxVertical = lines.size();
        System.out.println(maxHorizontal);
        System.out.println(maxVertical);
        int[][] cave = new int[maxVertical][maxHorizontal];
        for (int i = 0; i < maxVertical; i++) {
            int[] horizontal = new int[maxHorizontal];
            for (int j = 0; j < maxHorizontal; j++) {
                horizontal[j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
            cave[i] = horizontal;
        }
        System.out.println(Arrays.deepToString(cave));


    }

//    public static Map<String, Integer> getDistances() {
//        Set<String> visited = new HashSet<>();
//        Set<String> toVisit = new HashSet<>();
//        Map<String, Integer> distances = new HashMap<>();
//        distances.put("0,0", 0);
//        String currentNode = "0,0";
//        while (true) {
//            int currentDistance = distances.get(currentNode);
//            for (String neighbour : getAllNeighbours(currentNode)) {
//                Integer knownDistance = distances.get(neighbour);
//                int distanceViaCurrentNode = currentDistance + getGridValueOfNode(neighbour);
//                if (knownDistance == null || distanceViaCurrentNode < knownDistance) {
//                    distances.put(neighbour, distanceViaCurrentNode);
//                }
//            }
//            visited.add(currentNode);
//            toVisit.add(getAllNeighbours(currentNode));
//            // TODO: use Set operation to remove all entries from toVisit that are in visited
//            // TODO: find node in toVisit of which distances.get(node) is the smallest
//            if (toVisit.size() == 0) {
//                // Done! :)
//                return distances;
//            }
//            currentNode = ...;
//        }
//    }

    public static String[] getAllNeighbours(String currentNode) {
        String[] neighbours = new String[4];
        String[] currentNodeAsCoordinates = currentNode.split(",");
        int i = Integer.parseInt(currentNodeAsCoordinates[0]);
        int j = Integer.parseInt(currentNodeAsCoordinates[1]);
        if (i > 0 && i < 99 && j > 0 && j < 99) {
            int above = j - 1;
            int below = j + 1;
            int left = i - 1;
            int right = i + 1;
            neighbours[0] = "" + above + "," + i + "";
            neighbours[1] = "" + above + "," + i + "";
            neighbours[2] = "" + above + "," + i + "";
            neighbours[3] = "" + above + "," + i + "";

            //addifexists

        } else if (i == 0 && j == 0) {

        } else if (i == 0 && j == 99) {

        } else if (i == 0) {

        } else if (i == 99 && j == 0) {

        } else if (i == 99 && j == 99) {

        } else if (i == 99) {

        } else if (j == 0) {

        } else if (j == 99) {

        }
        return neighbours;
    }
}