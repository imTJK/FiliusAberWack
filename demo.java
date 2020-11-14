import Filius.IpAdress;
import Filius.NetworkSwitch;
import Filius.Computer;


public class demo {

    public static void main(String[] args) {
        String ip1 = "192.168.178.230";
        String ip2 = "192.168.128.128";
        String snm = "255.255.255.192";
        
        Computer c1 = new Computer("hassans Pc", ip1, snm);
        Computer c2 = new Computer("adis Pc", ip2, snm);


        c1.connectTo(c2);
        c2.connectTo(c1);

        c1.disconnectFrom(c2);
        c2.disconnectFrom(c1);
    }
}