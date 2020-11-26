package Filius;

//kinda useless atm, but good for visibility
public class Cable{
    FiliusObject[] connectedTo = new FiliusObject[2];

    public Cable(FiliusObject o1, FiliusObject o2){
        this.connectedTo[0] = o1;
        this.connectedTo[1] = o2;
    }

    public FiliusObject[] getConnectedTo(){
        return connectedTo;
    }
}
