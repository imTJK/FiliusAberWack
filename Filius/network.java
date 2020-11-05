package Filius;

import java.util.ArrayList;
import java.util.Map;

public class network {
    private ArrayList<computer> participants;
    private ArrayList<network_switch> switches; 


    private void getType(Object o){
        try {
            computer user = (computer) o;
            this.participants.add(user);
        } catch (Exception error_one) {
          try {
            network_switch n_switch = (network_switch) o;
            this.switches.add(n_switch);
          }  
          catch (Exception error_two){
            throw new Error("Object is neither Computer nor Network-Switch");
          }
        }
    }

    public void addObject(Object o){
       
    }

    public void removeObject(Object o){
        
    }



}
