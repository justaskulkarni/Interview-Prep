package Languages;
import java.util.Arrays;
public class OneLiners {
    public static void main(String[] args){
    int[] arr = {7, 8, 12, 4, 2, 1, 8, 10};
    int sum = Arrays.stream(arr).sum();
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    boolean contains1 = Arrays.stream(arr).anyMatch(element -> element == 1);
    boolean contains2 = Arrays.stream(arr).anyMatch(element -> element == 5);
    System.out.println("Sum = " + sum + " Max = " + max + " Min = " + min + " contains 1 = " + contains1 + " contains 2 = " + contains2);
    }
}
