package Filius;

public class Utilities {
    public static boolean check_array_for(Object ob, Object[] arr){
        for(Object o : arr){
            if(o == ob){
                return true;
            }
        }
        return false;
    }

    public static boolean intInRange(int val, int min, int max){
        return (val >= min) && (val <= max);
    }
}
