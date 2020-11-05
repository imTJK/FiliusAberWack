package Filius;

import java.util.Map;


public class network_switch {
    private int ports = 24;
    
    private Map<ip_adress, mac_adress>[] SAT;

    public static boolean verify_network(ip_adress ip1, ip_adress snm1, ip_adress ip2, ip_adress snm2){
        if(snm1.get_adress() == snm2.get_adress()){
            //subnetmasks are the same
            int n1 = 256 - (int) snm1.getOct(3);
            int n_num1 = 256 / n1;
            int n_index = (int) ip1.getOct(3) / n1;
            if(n_index == 0){
                if(!((int) ip2.getOct(3) < n_num1 * n_index || (int) ip2.getOct(3) > n_num1 * n_index)){
                    return true;
                }
                else return false;
            }
            if(!((int) ip2.getOct(3) < n_num1 * n_index-1 || (int) ip2.getOct(3) > n_num1 * n_index)){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
