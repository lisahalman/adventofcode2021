import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day1Input.txt").toPath());
    }
}
