import Filius.IpAdress;
import Filius.NetworkSwitch;
import Filius.Computer;
import Filius.Debugger;
import Filius.FiliusObject;
import Filius.Utilities;

public class demo {

    public static void main(String[] args) {
        String ip1 = "192.168.178.250";
        String ip2 = "192.168.128.250";
        String snm = "255.255.255.192";
        
        Computer c1 = new Computer("hassans Pc", ip1, snm);
        Computer c2 = new Computer("adis Pc", ip2, snm);

        NetworkSwitch ns = new NetworkSwitch(10);
        
        


        c1.ping(c2.getIP().getAdressString());
        ns.SATAnzeigen();
    }
}