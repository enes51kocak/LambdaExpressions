import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Functional_Programming_06 {
    public static void main(String[] args) throws IOException {
        // How to read text from the file
//        Files.lines(Paths.get("src\\main\\java\\LambdaTextFile.txt")).forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        //How to convert all characters in the file to uppercase
//        Files.lines(Paths.get("src\\main\\java\\LambdaTextFile.txt")).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------");

        // How to check if a specific word exist in the text
//        boolean result = Files.lines(Paths.get("src\\main\\java\\LambdaTextFile.txt")).anyMatch(t->t.contains("Lambda"));
//        System.out.println(result);

        System.out.println("-----------------------------------------------------------------------");

        // Print the distinct words on the console in the file
        // flatMap(Arrays::stream) breaks the array and returns stream
//        Files.lines(Paths.get("src\\\\main\\\\java\\\\LambdaTextFile.txt")).map(t->t.split(" ")).flatMap(Arrays::stream).distinct().forEach(Utils::printWithSpaceInTheSameLine);

        // Get the words which ends with 'e' and print them on the console
//        Files.lines(Paths.get("src\\\\main\\\\java\\\\LambdaTextFile.txt")).map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.endsWith("e")).forEach(Utils::printWithSpaceInTheSameLine);

    }
}
