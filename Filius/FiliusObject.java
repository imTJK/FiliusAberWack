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
        //empty Entity used for classifying
    }

    public void connectTo(FiliusObject o){
        if(!this.type.equals("computer")){
            this.connections.add(new Cable(this, o));
        }
    }
}
