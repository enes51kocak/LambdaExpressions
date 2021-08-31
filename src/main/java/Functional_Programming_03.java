
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Functional_Programming_03 {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");

        //printAllUpperCase1(l);
        //printAllUpperCase2(l);
        //printAfterSortingWithLength(l);
        //printAfterSortingWithLastCharacter(l);
        //printAfterSortingWithLengthThenFirstCharacter(l);
        //removeElementsLongerThanFive(l);
        //removeElementsStartWithAOrEndsWithN(l);
        //printSquareOfLengths(l);
        //isLengthLongerThanTwelve(l);
        //checkInıtıals(l);
        //checkLastCharacter(l);
    }

    // Create a method to print all elements in uppercase
    public static void printAllUpperCase1(List<String> list){
        list.stream().map(String::toUpperCase).forEach(Utils::printWithSpaceInTheSameLine);
    }
    public static void printAllUpperCase2(List<String> list){
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }

    // Create a method to print the elements after ordering according to their lengths. (we cannot use sorted because it sorts in natural order instead we will use Comparator.comparing(String::length))
    public static void printAfterSortingWithLength(List<String> list){
        list.stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(System.out::println);
    }

    // Create a method to sort the distinct elements by using their last characters
    public static void printAfterSortingWithLastCharacter(List<String> list){
        list.stream().distinct().sorted(Comparator.comparing(Utils::getLastCharacter)).forEach(System.out::println);
    }

    // Create a method to sort the elements according to their lengths and then according to their first characters
    public static void printAfterSortingWithLengthThenFirstCharacter(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(0))).forEach(System.out::println);
    }

    // Create a method to remove the elements if the length of the element is greater than 5
    public static void removeElementsLongerThanFive(List<String> list){
        list.removeIf(t->t.length()>5);
        System.out.println(list);
    }

    // Create a method to remove the elements which starts with 'A' or 'a' or ends with 'N' or 'n'
    public static void removeElementsStartWithAOrEndsWithN(List<String> list){
        list.removeIf(t-> t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));
        System.out.println(list);
    }

    // Create a method which takes the square of the length of every element, prints them distinctly in reverse order
    public static void printSquareOfLengths(List<String> list){
        list.stream().map(String::length).distinct().map(Utils::squareOf).sorted(Comparator.reverseOrder()).forEach(Utils::printWithSpaceInTheSameLine);
    }

    // Create a method to check if the length of all elements are less than 12
    // allMatch() => Returns whether all elements of this stream match the provided predicate.
    public static void isLengthLongerThanTwelve(List<String> list){
        boolean result = list.stream().allMatch(t->t.length()<10);
        System.out.println(result);
    }

    // Create a method to check if the initial of any element is not 'X'
    // noneMatch() Returns whether no elements of this stream match the provided predicate.
    public static void checkInıtıals(List<String> list){
        boolean result = list.stream().noneMatch(t-> t.startsWith("X"));
        System.out.println(result);
    }

    // Create a method to check if at least one of the elements ending with "r"
    // anyMatch() Returns whether any elements of this stream match the provided predicate
    public static void checkLastCharacter(List<String> list){
        boolean result = list.stream().anyMatch(t-> t.endsWith("c"));
        System.out.println(result);
    }
}
