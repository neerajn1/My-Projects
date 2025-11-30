import java.util.*;

public class toCharArray {
    public static void main(String[] args) {
        String course = "IS 247 Course";
        char[] courseArray = course.toCharArray(); //Array name itself is "courseArray"
        System.out.println(Arrays.toString(courseArray)); //Shows array spacing whereas just printing out plainly won't show this
    }
}
