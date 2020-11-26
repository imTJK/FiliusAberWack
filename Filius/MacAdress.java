package Filius;

import java.util.Random;

public class MacAdress {
    private Random rd = new Random();
    
    private FiliusObject belongingTo;
    
    private IpAdress ip;

    private String[] herstellerkennung = {"c1", "c6", "74"};
    private String[] geraetekennung = new String[3];



    public MacAdress(FiliusObject o, IpAdress ip){
        this.belongingTo = o;
        this.ip = ip;
        for(int i = 0; i < 3; i++){
            geraetekennung[i] = Integer.toHexString(rd.nextInt(256));
        }
    }



    public String macAdressToString(){
        String _tempAdress = "";
        for(int i = 0; i < 3; i++){
            if(i < 3){
                _tempAdress += this.herstellerkennung[i] + ".";
            }
            else{
                _tempAdress += this.herstellerkennung[i];
            }
        }
        for(int i = 0; i < 3; i++){
            if(i < 3){
            _tempAdress += this.geraetekennung[i] + ".";
            }
            else{
                _tempAdress += this.geraetekennung[i];
            }
        }
        return _tempAdress;
    }
    
    public FiliusObject getBelongingTo() {
        return belongingTo;
    }
    
}