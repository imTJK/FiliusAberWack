package Filius;

import java.util.Map;


public class NetworkSwitch extends FiliusObject{
    private int ports;
    
    private Map<IpAdress, MacAdress>[] SAT;

    public NetworkSwitch(int ports){
        super("network_switch");
        this.ports = ports;
    }


    public static boolean verifyNetwork(IpAdress ip1, IpAdress snm1, IpAdress ip2, IpAdress snm2){
        if(snm1.getAdress() == snm2.getAdress()) {
            //subnetmasks are the same
            int n1 = 256 - Integer.parseInt(snm1.getOct(3));
            
            int n_index = Integer.parseInt(ip1.getOct(3)) / n1;
            
            return (Integer.parseInt(ip2.getOct(3)) < n1 * n_index + 1 && Integer.parseInt(ip2.getOct(3)) > n1 * n_index);
        }
        else return false;
    }


    public int getPorts() {
        return ports;
    }
}
