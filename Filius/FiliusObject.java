package Filius;

import java.util.ArrayList;

public class FiliusObject {
    private final String[] allowed_types = {"computer", "network_switch"};

    private ArrayList<Cable> connections = new ArrayList<>();
    private String type;

    public FiliusObject(String type){
        if(Utilities.check_array_for(type.toLowerCase(), allowed_types)){
            this.type = type.toLowerCase();
        }
    }

    public void connectTo(FiliusObject o){
        if(this.type.equals("computer")){
            if(this.connections.size() <= 1){
                this.connections.add(new Cable(this, o));
            }
            else{
                Debugger.log("This Computer already has an established Connection");
            }
        }
        else{this.connections.add(new Cable(this, o));}
    }

    public void disconnectFrom(FiliusObject o){
        Cable tempCable = new Cable(this, o);  
        if(this.connections.contains(tempCable)){
            this.connections.remove(tempCable);
        }
        else{Debugger.log("No established Connection found");}
    }
}
