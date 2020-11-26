package Filius;

import java.util.Random;


public class Computer extends FiliusObject{
    private String name;
    private IpAdress IP;
    private IpAdress subnetmask;
    private boolean receiver;
    private MacAdress mac_adress;
    
    private Frame receivedData;
    private int pingCount;
    private long startTimer;
    private long endTimer;
    private static Random rd = new Random();

    protected static final String PC = "computer";


    public Computer(String name, String ip, String subnetmask){
        super (PC);
        this.IP = new IpAdress(ip, this);
        this.subnetmask = new IpAdress(subnetmask, this);
        this.mac_adress = new MacAdress(this.getSelf(), this.IP);
        this.name = name;
    }

    public void receiveData(Frame f){
        if(f != null){
            this.receivedData = f;    
        } 
    }

    public boolean checkConnection(String ip){
        try {
            IpAdress adr = new IpAdress(ip, super.getSelf());
            if(adr.getAdressString().equals(this.IP.getAdressString())){
                return true;
            }

            for(Cable c : this.getConnections()){
                FiliusObject o = c.getConnectedTo()[1];
                if(o.type.equals("network_switch")){
                    NetworkSwitch _tempSwitch = (NetworkSwitch) o;
                    return _tempSwitch.sendSignal(adr.getMacAdress(), this.getSelf()) != null;
                }
                else if(o.type.equals(PC)){
                    Computer tempC = (Computer) o;
                    return tempC.getIP().getAdressString().equals(adr.getAdressString());
                }
            }
        } 
        catch (Exception e) { //catch-all-Block
            Debugger.log(e);
        }   
        return false; 
    }


    private FiliusObject getConnectedIP(IpAdress ip){
        for(Cable c : this.getConnections()){
            for(FiliusObject o : c.getConnectedTo()){
                if(o.type.equals(PC) && o.getSelf() != this.getSelf()){
                    Computer _tempPC = (Computer) o;
                    if (_tempPC.getIP().getAdressString().equals(ip.getAdressString())){
                        return o;
                    }
                }
                if(o.type.equals("network_switch")){
                    NetworkSwitch _tempSwitch = (NetworkSwitch) o;
                    ip = _tempSwitch.getIP(ip);
                    if(ip.getMacAdress() == null && !ip.getBelongingTo().type.equals("network_switch")){
                        Computer _tempPC = (Computer) ip.getBelongingTo();
                        ip.setMacAdress(_tempPC.getMacAdress());
                    }
                    return _tempSwitch.sendSignal(ip.getMacAdress(), this.getSelf());
                }
            }
        }
        return null;
    }

    public void ping(String addr){
        try{
            endTimer = System.currentTimeMillis();
            
            byte[] data = new byte[46];
            rd.nextBytes(data);
            Frame pingFrame;


            if(this.receiver && this.receivedData == null){
                this.receiver = false;
                return;
            }
            else if(this.receiver){
                pingFrame = this.receivedData;
            }

            long timer =  this.endTimer - this.startTimer;
            this.startTimer = System.currentTimeMillis();
            IpAdress _tempIp = new IpAdress(addr, this);

            if(this.pingCount != 0){
                Debugger.log(String.format("%1$s pinged %2$s --- Time elapsed: %3$s ms", this.IP.getAdressString(), addr, timer));
            }

            if(this.checkConnection(addr) && this.pingCount != 5){
                FiliusObject targetObj = getConnectedIP(_tempIp);
                if(targetObj != null){
                    switch(targetObj.type){
                        case PC:
                            Computer targetPC = (Computer) targetObj;
                            pingFrame = new Frame(targetPC.getMacAdress(), this.mac_adress, data);
                            targetPC.setReceiver(true);
                            targetPC.receiveData(pingFrame);
                            this.pingCount++;

                            Thread.sleep(250);
                            targetPC.ping(this.IP.getAdressString());
                            break;
                        default:
                            Debugger.log(String.format("Couldnt reach Object %1$s", targetObj));
                            break;
                    }
                }
                else{
                    this.pingCount = 0;
                }
            }
            this.receiver = false;
        }
        catch(Exception e){
            Debugger.log(e);
        }
    }

    public MacAdress getMacAdress() {
        return mac_adress;
    }

    public void setReceiver(boolean receiver) {
        this.receiver = receiver;
    }

    public IpAdress getIP() {
        return IP;
    }
}