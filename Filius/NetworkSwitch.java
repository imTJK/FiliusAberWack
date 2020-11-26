package Filius;

import java.lang.invoke.TypeDescriptor.OfMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import java.util.AbstractMap.SimpleEntry;


public class NetworkSwitch extends FiliusObject{
    private int ports;
    private Map<MacAdress, Entry<IpAdress, Integer>> SAT = new HashMap<>();


    private int nextPort = 1;

    public NetworkSwitch(int ports){
        super("network_switch");
        this.ports = ports;
    }

    public void getConnected(){
        for (Cable c : this.getConnections()){
            for (FiliusObject o : c.getConnectedTo()){
                if (o.type.equals("computer")){
                    Computer _tempPC = (Computer) o;
                    if(!SAT.containsKey(_tempPC.getMacAdress())){
                        SAT.put(_tempPC.getMacAdress(), new SimpleEntry<>(_tempPC.getIP(), this.nextPort));
                        this.nextPort++;
                        }
                    }
                }
            }
        }


    public FiliusObject sendSignal(MacAdress m, FiliusObject origin){
    
        if (this.SAT.containsKey(m) && m.getBelongingTo() != origin){
            return m.getBelongingTo();
        }
    
        for(Cable c: this.getConnections()){
            for(FiliusObject o : c.getConnectedTo()){
                if(o.type.equals("computer")){
                    Computer _tempPC = (Computer) o;
                    if(_tempPC.getMacAdress().macAdressToString().equals(m.macAdressToString())){
                        this.SAT.put(m, new SimpleEntry<>(_tempPC.getIP(), this.nextPort));
                        this.nextPort++;
                        return o;
                    }
                    else if(o.type.equals("network_switch") && o != this.getSelf()){
                        NetworkSwitch _tempSwitch = (NetworkSwitch) o;
                        return _tempSwitch.sendSignal(m, this.getSelf());
                    }
                }
            }
        }
        return null;
        }
    
    public void SATAnzeigen(){
        for(Map.Entry<MacAdress, Entry<IpAdress, Integer>> entry : SAT.entrySet()){
            Debugger.log(String.format("Port: %1$s - Mac-Adress: %2$s, Ip-Adress: %3$s", entry.getValue().getValue(), entry.getKey().macAdressToString(), entry.getValue().getKey().getAdressString()));
        }
    }

    public int getPorts() {
        return ports;
    }


    public IpAdress getIP(IpAdress targetIp){
        for(Map.Entry<MacAdress, Entry<IpAdress, Integer>> entry : SAT.entrySet()){
            String ipString = entry.getValue().getKey().getAdressString();
            if(ipString.equals(targetIp.getAdressString())){
                return entry.getValue().getKey();
            }
        }
        return null;
    }
}
