import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Functional_Programming_05 {
    public static void main(String[] args) {
        Course courseTurkishDay = new Course("Summer", "Turkish Day", 97, 128);
        Course courseTurkishNight = new Course("Winter", "Turkish Night", 98, 154);
        Course courseEnglishDay = new Course("Spring", "English Day", 95, 132);
        Course courseEnglishNight = new Course("Winter", "English Night", 93, 144);

        List<Course> courses = new ArrayList<>();
        courses.add(courseTurkishDay);
        courses.add(courseTurkishNight);
        courses.add(courseEnglishDay);
        courses.add(courseEnglishNight);

        //System.out.println(isAllAvgScoreGreaterThan(courses, 95));
        //System.out.println(isAnyCourseNameContains(courses, "Turkish"));
        //printTheCourseWithHighesAvg(courses);
        //System.out.println(sortAndSkipTwo(courses));
        //sortAndGetTheThird(courses);



    }
    // Create a method to check if all average scores are greater than 91
    public static boolean isAllAvgScoreGreaterThan(List<Course> list,int score){
        return list.stream().allMatch(t-> t.getAverageScore()>score);
    }

    // Create a method to check if at least one of the course names contains "Turkish" word
    public static boolean isAnyCourseNameContains(List<Course> list,String name){
        return list.stream().anyMatch(t->t.getCourseName().contains(name));
    }

    // Create a method to print the course which has the highest average score
    public static void printTheCourseWithHighesAvg(List<Course> list){
        Course result = list.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst().get();
        System.out.println(result);
    }

    // Sort the elements according to the average score in ascending order and skip first 2 elements
    public static List<Course> sortAndSkipTwo(List<Course> list){
       return list.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).collect(Collectors.toList());
    }

    // Sort the elements according to the average score in ascending order and print the 3rd course
    public static void sortAndGetTheThird(List<Course> list){
        List<Course> result = list.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).limit(1).collect(Collectors.toList());
        System.out.println(result);
    }

}
