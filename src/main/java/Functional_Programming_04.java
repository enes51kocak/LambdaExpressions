import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Functional_Programming_04 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);

        //sumOfElements(l);
        //sumOfIntFromSevenToHundred1();
        //sumOfIntFromSevenToHundred2();
        //prodOfIntFromTwoToEleven();
        //findFactorial(-5);
        //findSumOfEvenIntBetween(10, 101);
        findSumOfDigitsOfIntBetween(17, 13);

    }

    // Create a method to find the sum of all elements in the list
    public static void sumOfElements(List<Integer> list) {
        int sum = list.stream().reduce(0, Math::addExact);
        System.out.println(sum);
    }

    // Create a method to find the sum of integers from 7 to 100
    public static void sumOfIntFromSevenToHundred1(){
        int sum = IntStream.range(7,101).reduce(0, Math::addExact);
        System.out.println(sum);
    }
    public static void sumOfIntFromSevenToHundred2(){
        int sum = IntStream.rangeClosed(7, 100).sum();
        System.out.println(sum);
    }

    // Create a method to find the product of integers from 2 to 11 (both inclusive)
    public static void prodOfIntFromTwoToEleven(){
        int prd = IntStream.rangeClosed(2,11).reduce(1, Math::multiplyExact);
        System.out.println(prd);
    }

    // Create a method to calculate the factorial of a given number
    public static void findFactorial(int num){
        if(num<0) {
            System.out.println("Do not use negative number");
        }
        else {
            int factorial = IntStream.rangeClosed(1, num).reduce(1, Math::multiplyExact);
            System.out.println(factorial);
        }
    }

    // Create a method to calculate the sum of even integers between given two integer
    public static void findSumOfEvenIntBetween(int start, int end){
        int sum = IntStream.rangeClosed(start, end).filter(Utils::isEven).sum();
        System.out.println(sum);
    }

    // Create a method to calculate the sum of digits of every integers between two integers
    public static void findSumOfDigitsOfIntBetween(int startInc, int endInc){
        if(startInc>endInc){
            int temp = startInc;
            startInc=endInc;
            endInc=temp;
        }
        int sum = IntStream.rangeClosed(startInc, endInc).map(Utils::sumOfDigits).sum();
        System.out.println(sum);
    }
}