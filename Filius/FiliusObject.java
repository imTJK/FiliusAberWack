package Filius;

import java.util.ArrayList;
import java.util.List;

public class FiliusObject {
    private final String[] allowed_types = {"computer", "network_switch"};
    private ArrayList<Cable> connections = new ArrayList<>();
    
    private boolean removal = false;
    private boolean hasIP;

    public String type;



    public FiliusObject(String type){
        if(Utilities.check_array_for(type.toLowerCase(), allowed_types)){
            this.type = type.toLowerCase();
            switch(this.type){
                case "computer":
                    this.hasIP = true;
                    break;
                default:
                    this.hasIP = false;
                }
        }
    }

    private boolean atMaxConnections(){
        //Define max. Amount of Connections of each FiliusObject in here
        switch(this.type){
            case "computer":
                return !this.connections.isEmpty();
            case "network_switch":
                NetworkSwitch _tempSwitch = (NetworkSwitch) this;
                return this.connections.size() == _tempSwitch.getPorts();
            default:
                return true;
        }
    }

    public void connectTo(FiliusObject o){
        if(!this.atMaxConnections()){
            if (!o.atMaxConnections()){
                this.connections.add(new Cable(this, o));
                o.connections.add(new Cable(o, this));
                if(o.type.equals("network_switch")){
                    NetworkSwitch _tempSwitch = (NetworkSwitch) o;
                    _tempSwitch.getConnected();
                }
                Debugger.log(String.format("Successfully connected %1$s with %2$s", this, o));
            }
            else{Debugger.log(FiliusErrors.MaxConnectError(o));}
        }
        else{
            Debugger.log(FiliusErrors.MaxConnectError(this));
        }
    }


    public void disconnectFrom(FiliusObject o){
        int _count = 0;
        if(o == this){
            Debugger.log(String.format("Object %1$s unable to disconnect from self", o));
            return;
        }

        for(Cable c : this.connections){
            for(FiliusObject oC : c.connectedTo){
                if(oC == o){
                    this.connections.remove(this.connections.get(_count));
                    Debugger.log(String.format("Object %1$s disconnected from Object %2$s", o, this));

                    //cheap workaround, fix later on, only works with 2-way connections
                    if(!this.removal){
                        oC.removal = true;
                        oC.disconnectFrom(this);
                    }
                    return;
                }
            }
            _count++;
        }
        Debugger.log(String.format("No established Connection between %1$s and %2$s found", this, o));
    }


    public FiliusObject getSelf(){
        return this;
    }

    public List<Cable> getConnections() {
        return connections;
    }

    public boolean getHasIP(){
        return hasIP;
    }
}
