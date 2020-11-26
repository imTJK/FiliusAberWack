package Filius;

public class IpAdress {
    private String[] ip = new String[4];
    private char network_class;
    private FiliusObject belongingTo;
    private MacAdress macAdress;

    

    public IpAdress(String adress, FiliusObject o){
        this.belongingTo = o;
        
        String[] split_adr = adress.split("\\.");
        if(split_adr.length == 4){
           for(int i = 0; i < 4; i++){
               if(i == 0){
                   this.network_class = getNetworkClass(split_adr[i]);
               }
               this.ip[i] = split_adr[i]; 
           }
        }
        if(o.type.equals("computer")){
            Computer _tempPC = (Computer) o;
            this.macAdress = _tempPC.getMacAdress();
        }
    }
    
    
    private char getNetworkClass(String oct){
        //gotta get cleaner
        
        int _oct = Integer.parseInt(oct);
        if(Utilities.intInRange(_oct, 0, 127)){return 'A';}
        else if(Utilities.intInRange(_oct, 128, 191)){return 'B';}
        else if(Utilities.intInRange(_oct, 192, 223)){return 'C';}
        else if(Utilities.intInRange(_oct, 224, 239)){return 'D';}
        else {return 'E';}
    }

    public String getOct(int index){
        if(this.ip[index] != null){
            return this.ip[index];
        }
        return null;
    }


    public String getAdressString(){
        String _tempString = "";
        for(int i = 0; i < this.ip.length; i++){
            if(i != 3){
                _tempString += this.getOct(i) + '.';
            }
            else{
                _tempString += this.getOct(i);
            }
        }
        return _tempString;
    }

    public String[] getAdress() {
        return ip;
    }
    
    public char getNetwork_class() {
        return network_class;
    }

    public FiliusObject getBelongingTo() {
        return belongingTo;
    }

    public MacAdress getMacAdress() {
        return macAdress;
    }
    
    public void setMacAdress(MacAdress macAdress) {
        this.macAdress = macAdress;
    }
}
