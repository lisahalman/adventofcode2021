import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day10 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("Day10Input.txt").toPath());
        List<String> greatLines = new ArrayList<>(lines);
        StringBuilder firstCorruptedFromEachLine = new StringBuilder("");
        for (String line : lines) {
            Deque<Character> deque = new LinkedList<>();
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    deque.push(')');
                } else if (ch == '[') {
                    deque.push(']');
                } else if (ch == '{') {
                    deque.push('}');
                } else if (ch == '<') {
                    deque.push('>');
                } else if (ch == ')') {
                    if (deque.pop() != ')') {
                        firstCorruptedFromEachLine.append(')');
                        greatLines.remove(line);
                        break;
                    }
                } else if (ch == ']') {
                    if (deque.pop() != ']') {
                        firstCorruptedFromEachLine.append(']');
                        greatLines.remove(line);
                        break;
                    }
                } else if (ch == '}') {
                    if (deque.pop() != '}') {
                        firstCorruptedFromEachLine.append('}');
                        greatLines.remove(line);
                        break;
                    }
                } else if (ch == '>') {
                    if (deque.pop() != '>') {
                        firstCorruptedFromEachLine.append('>');
                        greatLines.remove(line);
                        break;
                    }
                }
            }
        }
        System.out.println(firstCorruptedFromEachLine);
        int count = 0;
        for (char ch : firstCorruptedFromEachLine.toString().toCharArray()) {
            if (ch == ')') {
                count += 3;
            } else if (ch == ']') {
                count += 57;
            } else if (ch == '}') {
                count += 1197;
            } else if (ch == '>') {
                count += 25137;
            }
        }
        System.out.println("First Part: " + count);
        //second part
        List<StringBuilder> completionFromLines = new ArrayList<>();
        for (int i = 0; i < greatLines.size(); i++) {
            Deque<Character> deque = new LinkedList<>();
            for (char ch : greatLines.get(i).toCharArray()) {
                if (ch == '(') {
                    deque.push(')');
                } else if (ch == '[') {
                    deque.push(']');
                } else if (ch == '{') {
                    deque.push('}');
                } else if (ch == '<') {
                    deque.push('>');
                } else if (ch == ')') {
                    if (deque.pop() != ')') {
                        //completionFromLines.set(i, ")");
                        break;
                    }
                } else if (ch == ']') {
                    if (deque.pop() != ']') {
                        firstCorruptedFromEachLine.append(']');
                        break;
                    }
                } else if (ch == '}') {
                    if (deque.pop() != '}') {
                        firstCorruptedFromEachLine.append('}');
                        break;
                    }
                } else if (ch == '>') {
                    if (deque.pop() != '>') {
                        firstCorruptedFromEachLine.append('>');
                        break;
                    }
                }
            }
        }
    }
}