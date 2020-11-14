package Filius;

public class Debugger {
    private static boolean isActive = true;

    private Debugger(){
        //empty as to deter misuse
    }

    public static void enable(){
        isActive = true;
    }

    public static void disable(){
        isActive = false;
    }

    public static boolean isEnabled(){
        return isActive;
    }


    public static void log(Object o){
        if(Debugger.isEnabled()) {
            System.out.println(o.toString());
        }           
    }
}
