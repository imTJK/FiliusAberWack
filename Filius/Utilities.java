package Filius;

import java.util.Arrays;

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


    /*examples:
        ip1.getOct(3) = 84, snm.getOct(3) = 192 → networkInterval = 64, networkIndex = 2
        ip2.getOct(3) = 68
        68 < 64*2 == True, 68 > 64*1 == True
    */
    public static boolean verifyNetwork(IpAdress ip1, IpAdress ip2, IpAdress snm1, IpAdress snm2){
        if(Arrays.equals(snm1.getAdress(), snm2.getAdress())){
            //size of Intervals between Networks defined by the subnetmask
            int networkInterval = 256 - Integer.parseInt(snm1.getOct(3));
            //Index of what Interval ip1 is in
            int networkIndex = Integer.parseInt(ip1.getOct(3)) /networkInterval;

            int verifyOct = Integer.parseInt(ip2.getOct(3));
            Debugger.log(networkInterval * (networkIndex));
            Debugger.log(networkInterval * (networkIndex+1));
            return (verifyOct < networkInterval * (networkIndex+1) && verifyOct > networkInterval * networkIndex);
        }
        return false;
    }

    public static boolean intInRange(int val, int min, int max){
        return (val >= min) && (val <= max);
    }
}
