package Filius;

import java.util.Map;


public class NetworkSwitch extends FiliusObject{
    private int ports = 24;
    
    private Map<IpAdress, MacAdress>[] SAT;

    public NetworkSwitch(){
        super("network_switch");
    }


    public static boolean verifyNetwork(IpAdress ip1, IpAdress snm1, IpAdress ip2, IpAdress snm2){
        if(snm1.getAdress() == snm2.getAdress()) {
            //subnetmasks are the same
            int n1 = 256 - Integer.parseInt(snm1.getOct(3));
            int n_num1 = 256 / n1;
            int n_index = Integer.parseInt(ip1.getOct(3)) / n1;
            if(n_index == 0){
                return (!(Integer.parseInt(ip2.getOct(3)) < n_num1 * n_index || Integer.parseInt(ip2.getOct(3)) > n_num1 * n_index));
            }
            return (!(Integer.parseInt(ip2.getOct(3)) < n_num1 * n_index-1 || Integer.parseInt(ip2.getOct(3)) > n_num1 * n_index));
        }
        else return false;
    }
}
