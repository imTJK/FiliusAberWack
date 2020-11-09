package Filius;

public class Computer extends FiliusObject{
    private String name;
    private IpAdress IP;
    private IpAdress subnetmask;

    public Computer(String ip, String subnetmask, String name){
        super ("computer");
        this.IP = new IpAdress(ip);
        this.subnetmask = new IpAdress(subnetmask);
        this.name = name;
    }
}
