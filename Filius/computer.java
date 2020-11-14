package Filius;

public class Computer extends FiliusObject{
    private String name;
    private IpAdress IP;
    private IpAdress subnetmask;

    public Computer(String name, String ip, String subnetmask){
        super ("computer");
        this.IP = new IpAdress(ip);
        this.subnetmask = new IpAdress(subnetmask);
        this.name = name;
    }


    public boolean checkConnection(String ip){
        try {
            IpAdress adr = new IpAdress(ip);
            if(adr == this.getIP()){
                return true;
            }

            
            for(Cable c : this.getConnections()){
                FiliusObject o = c.getConnectedTo()[1];
                if(o.type == "network_switch"){
                    // ignore for now
                }
                else if(o.type == "computer") {
                    Computer tempC = (Computer) o;
                    return tempC.getIP() == adr;
                }
            }
        } catch (Exception e) {
            Debugger.log(e);
        }   
        return false; 
    }

    public IpAdress getIP() {
        return IP;
    }
}
