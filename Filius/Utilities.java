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

    public static String arrayToString(Object[] oA){
        String _tempString = "";
        for(Object o : oA){
            _tempString += o.toString() + ", ";
        }
        return _tempString;
    }



    public static boolean intInRange(int val, int min, int max){
        return (val >= min) && (val <= max);
    }
}
