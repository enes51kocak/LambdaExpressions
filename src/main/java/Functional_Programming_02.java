import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Functional_Programming_02 {
/*
* Method References: ClassName :: MethodName without parenthesis
*
*/

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(12);
        l.add(9);
        l.add(14);
        l.add(4);
        l.add(10);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);

        //printElements(l);
        //printEven(l);
        //printSquareOfOddElements(l);
        //printCubeOfDistinctOddElements(l);
        //printSumOfSquaresOfDistinct(l);
        //printProdOfCubeOfDistinctEven(l);
        //findMax(l);
        //findMin(l);
        //findEvenMinAfterSeven(l);
        //printHalfOfDistinctElementsGreaterThanFiveReversed(l);


    }

    // Create a method to print the list elements on the console in the same line with a space between two consecutive elements.
    // if java has any method we prefer to use it, if Java does not have it we create it inside Utils class and use it
    public static void printElements(List<Integer> list){
        list.stream().forEach(Utils::printWithSpaceInTheSameLine);
    }

    // Create a method to print the even list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printEven(List<Integer> list){
        list.stream().filter(Utils::isEven).forEach(Utils::printWithSpaceInTheSameLine);
    }

    // Create a method to print the square of odd list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printSquareOfOddElements(List<Integer> list){
        list.stream().filter(Utils::isOdd).map(Utils::squareOf).forEach(Utils::printWithSpaceInTheSameLine);
    }

    // Create a method to print the cube of distinct odd list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printCubeOfDistinctOddElements(List<Integer> list){
        list.stream().distinct().filter(Utils::isOdd).map(Utils::cubeOf).forEach(Utils::printWithSpaceInTheSameLine);
    }

    // Create a method to calculate the sum of squares of distinct even elements
    public static void printSumOfSquaresOfDistinct(List<Integer> list){
        int sum = list.stream().distinct().filter(Utils::isEven).map(Utils::squareOf).reduce(0, Math::addExact);
        System.out.println(sum);
    }

    // Create a method to calculate the product of cubes of distinct even elements
    public static void printProdOfCubeOfDistinctEven(List<Integer> list){
        int prd = list.stream().distinct().filter(Utils::isEven).map(Utils::cubeOf).reduce(1, Math::multiplyExact);
        System.out.println(prd);
    }

    // Create a method to find the maximum value from the list elements
    public static void findMax(List<Integer> list){
        int max = list.stream().distinct().reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(max);
    }

    // Create a method to find the minimum value from the list elements
    public static void findMin(List<Integer> list){
        int min = list.stream().distinct().reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(min);
    }

    // Create a method to find the minimum value which is greater than 7 and even , from the list
    public static void findEvenMinAfterSeven(List<Integer> list){
        int min = list.stream().
                  filter(Utils::isEven).
                  filter(t->t>7).
                  reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(min);
    }

    // Create a method to print the half of the elements which are distinct and greater than 5 in reverse order from the list
    public static void printHalfOfDistinctElementsGreaterThanFiveReversed(List<Integer> list){
        List<Double> result = list.stream().
                              distinct().
                              map(Utils::getHalf).
                              filter(t->t>5).
                              sorted(Comparator.reverseOrder()).
                              collect(Collectors.toList());
        System.out.println(result);
    }
}
