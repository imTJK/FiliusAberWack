package Filius;

import java.util.ArrayList;

public class FiliusErrors {
    private FiliusErrors(){
        //empty cause of IntelliCode bugging me
    }


    public static String MaxConnectError(FiliusObject o){
        ArrayList<FiliusObject> conns = new ArrayList<FiliusObject>();
        for(Cable c : o.getConnections()){
            for(FiliusObject oC : c.connectedTo){
                if(!Utilities.check_array_for(oC, conns.toArray()) && oC != o){
                    conns.add(oC);
                }
            }
        }
        return String.format("Object %1$s already at max connnections. %n Close connection to either %2$s", o.toString(), Utilities.arrayToString(conns.toArray()));
    }
}
