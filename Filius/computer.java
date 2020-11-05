package Filius;
import java.util.ArrayList;
import java.util.Map;

public class computer {
    private String name;
    private ip_adress IP;
    private ip_adress subnetmask;


    private network_switch n_switch = null;

    public computer(String IP, String subnetmask, String name){
        this.IP = new ip_adress(IP);
        this.subnetmask = new ip_adress(subnetmask);
        this.name = name;
    }
}
