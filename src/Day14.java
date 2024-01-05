import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day14 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day14Input.txt").toPath());
        StringBuilder polymerTemplate = new StringBuilder(lines.get(0));
        List<String> listOfRules = new ArrayList<>(lines);
        listOfRules.remove(0);
        listOfRules.remove(0);
        Map<String, String> rules = new HashMap<>();
        for (String rule : listOfRules) {
            String[] keyValuePair;
            keyValuePair = rule.split(" -> ");
            rules.put(keyValuePair[0], keyValuePair[1]);
        }
        for (int j = 0; j < 10; j++) {
            String polymerTemplateString = polymerTemplate.toString();
            for (int i = 0; i < polymerTemplateString.length() - 1; i++) {
                String lettersToCheck = polymerTemplateString.substring(i, i + 2);
                String letterToInsert = rules.get(lettersToCheck);
                polymerTemplate.insert((i + i + 1), letterToInsert);
            }
        }
        String polymer = polymerTemplate.toString();
        int countB = 0;
        int countC = 0;
        int countF = 0;
        int countH = 0;
        int countK = 0;
        int countN = 0;
        int countO = 0;
        int countP = 0;
        int countS = 0;
        int countV = 0;
        for (int i = 0; i < polymer.length(); i++) {
            switch (polymer.charAt(i)) {
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'F' -> countF++;
                case 'H' -> countH++;
                case 'K' -> countK++;
                case 'N' -> countN++;
                case 'O' -> countO++;
                case 'P' -> countP++;
                case 'S' -> countS++;
                case 'V' -> countV++;
            }
        }
        System.out.println("B: " + countB);
        System.out.println("C: " + countC);
        System.out.println("F: " + countF);
        System.out.println("H: " + countH);
        System.out.println("K: " + countK);
        System.out.println("N: " + countN);
        System.out.println("O: " + countO);
        System.out.println("P: " + countP);
        System.out.println("S: " + countS);
        System.out.println("V: " + countV);
        System.out.println(countB + countC + countF + countH + countK + countN + countO + countP + countS + countV);
        //second part


    }
}