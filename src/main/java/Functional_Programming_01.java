import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Functional_Programming_01 {
    /*
    * Lambda is Functional Programming
    * Functional Programming was added to Java with Java 8, before that we were using just Structured Programming
    * Structured Programming focus on "how to do", Functional Programming focus on "what to do"
    * Functional Programming is used with collections and arrays
    */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(12);
        l.add(9);
        l.add(131);
        l.add(14);
        l.add(8);
        l.add(10);
        l.add(4);
        l.add(12);
        l.add(15);

        //printList2(l);
        //printEvenList(l);
        //printSquareOfOddElements(l);
        //printCubeOfDistinctOddElements(l);
        //printSumOfSquaresOfDistinct(l);
        //printProdOfCubeOfDistinctEven(l);
        //findMax1(l);
        //findMax2(l);
        //findMin1(l);
        //findMin2(l);
        //findEvenMinAfterSeven1(l);
        //findEvenMinAfterSeven2(l);
        //findEvenMinAfterSeven3(l);
        //findEvenMinAfterSeven4(l);
        //printHalfOfDistinctElementsGreaterThanFiveReversed(l);

    }
    // Create a method to print the list elements on the console in the same line with a space between rwo consecutive element
    public static void  printList2(List<Integer> list){
        list.stream().forEach(t -> System.out.print(t + " "));
    }

    // Create a method to print the even list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printEvenList(List<Integer> list){
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }

    // Create a method to print the square of odd list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printSquareOfOddElements(List<Integer> list){
        list.stream().filter(t->t%2!=0).map(t->(t*t)).forEach(t-> System.out.print(t+" ")); //map() is used to update the elements
    }

    // Create a method to print the cube of distinct odd list elements on the console in the same line with a space between rwo consecutive elements.
    public static void printCubeOfDistinctOddElements(List<Integer> list){
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" ")); // distinct() method removes repeated elements
    }

    // Create a method to calculate the sum of squares of distinct even elements
    public static void printSumOfSquaresOfDistinct(List<Integer> list){
        int sum = list.stream().distinct().filter(t-> t%2==0).map(t-> t*t).reduce(0, (t,u) -> t+u);
        System.out.println(sum);
    }

    // Create a method to calculate the product of cubes of distinct even elements
    public static void printProdOfCubeOfDistinctEven(List<Integer> list){
        int prd = list.stream().distinct().filter(t-> t%2==0).map(t->t*t*t).reduce(1, (t,u) -> t*u);
        System.out.println(prd);
    }

    // Create a method to find the maximum value from the list elements
    public static void findMax1(List<Integer> list){
        int max = list.stream().reduce(Integer.MIN_VALUE, (t,u) -> t>u ? t : u);
        System.out.println(max);
    }

    public static void findMax2(List<Integer> list){
        int max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u) -> u);
        System.out.println(max);
    }

    // Create a method to find the minimum value from the list elements
    public static void findMin1(List<Integer> list){
        int min = list.stream().reduce(Integer.MAX_VALUE, (t,u) -> t<u ? t : u);
        System.out.println(min);
    }

    /* -- sorted() => Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.*/
    public static void findMin2(List<Integer> list){
       int min = list.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u) -> u);
        System.out.println(min);
    }

    // Create a method to find the minimum value which is greater than 7 and even , from the list
    public static void findEvenMinAfterSeven1(List<Integer> list){
        int min = list.stream().distinct().filter(t-> t>7 && t%2==0).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u) -> u);
        System.out.println(min);
    }

    public static void findEvenMinAfterSeven2(List<Integer> list){
        int min = list.stream().distinct().filter(t-> t>7 && t%2==0).reduce(Integer.MAX_VALUE, (t,u) -> t<u ? t : u);
        System.out.println(min);
    }

    public static void findEvenMinAfterSeven3(List<Integer> list){
        int min = list.stream().distinct().filter(t-> t%2==0 && t>7).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t,u) -> u);
        System.out.println(min);
    }

    public static void findEvenMinAfterSeven4(List<Integer> list){
        int min = list.stream().distinct().filter(t-> t>7 && t%2==0).sorted().findFirst().get(); // findFirst() return Optional<Integer> that's why we use get() with it to have Integer return type
        System.out.println(min);
    }

    // Create a method to print the half of the elements which are distinct and greater than 5 in reverse order from the list
    public static void printHalfOfDistinctElementsGreaterThanFiveReversed(List<Integer> list){
        List<Double> result= list.stream().distinct().map(t->t/2.0).filter(t->t>5).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(result);
    }
}
