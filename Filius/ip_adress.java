package Filius;


public class ip_adress {
    private String[] ip;
    private String network_class;


    private boolean intInRange(int val, int min, int max){
        return (val >= min) && (val <= max);
    }

    private String getNetworkClass(String oct){
        //gotta get cleaner
        int _oct = Integer.parseInt(oct);
        if(intInRange(_oct, 0, 127)){return "A";}
        else if(intInRange(_oct, 128, 191)){return "B";}
        else if(intInRange(_oct, 192, 223)){return "C";}
        else if(intInRange(_oct, 224, 239)){return "D";}
        else {return "E";}
    }


    public ip_adress(String adress){
        String[] split_adr = adress.split("\\.");
        if(split_adr.length == 4){
           for(int i = 0; i < 4; i++){
               if(i == 0){
                   this.network_class = getNetworkClass(split_adr[i]);
               }
               this.ip[i] = split_adr[i]; 
           }
        }
    }

    public String getOct(int index){
        if(this.ip[index] != null){
            return this.ip[index];
        }
        return null;
    }


    public String[] getIp() {
        return ip;
    }
    
    public String getNetwork_class() {
        return network_class;
    }
}
