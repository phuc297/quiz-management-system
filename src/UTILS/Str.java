package UTILS;

public class Str {

    public static String getFirstWord(String s) {
        String arr[] = s.split(" ", 2);
        return arr[0];
    }

    public static String getTheRest(String s) {
        String arr[] = s.split(" ", 2);
        if (arr.length > 1) {
            return arr[1];
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(getTheRest("Nguyễn Văn b"));
    }
}
