package Filius;
import Filius.ip_adress;
import Filius.mac_adress;
import Filius.network_switch;


import java.util.Map;

public class computer {
    private String name;
    private network_switch n_switch;
    private ip_adress ip_adresse;
    //mac_Adress not actually part of PC, just for debugging/confirmation
    private mac_adress mac_adresse;

    public computer(Map <String, String> args){
        
    }

    public ip_adress getIp_adresse() {
        return this.ip_adresse;
    }


    public void set_mac_adresse(network_switch n_switch, mac_adress mac_adresse) {
        if (this.n_switch == null || n_switch != this.n_switch){
            System.err.println("Error: Incorrect Data for this Action");
        }
        else{this.mac_adresse = mac_adresse;}
    }
}
