import java.util.List;

public class Utils {
    public static void printWithSpaceInTheSameLine(Object o){
        System.out.print(o+" ");
    }
    public static boolean isEven(int num){
        return num%2==0;
    }
    public static boolean isOdd(int num){
        return num%2!=0;
    }
    public static int squareOf(int num){
        return num*num;
    }
    public static int cubeOf(int num){
        return num*num*num;
    }
    public static double getHalf(int num){
        return num/2.0;
    }
    public static char getLastCharacter(String s){
        return s.charAt(s.length()-1);
    }
    public static int sumOfDigits(int num){
        int sum = 0;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }


}
