package Filius;

public class demo {
    
    public static void main(String[] args) {
        ip_adress ip1 = new ip_adress("255.128.127.0");


        for(int val : ip1.get_adress()){
            if(val < 0){
                System.out.println(256 + val);
            }
            else System.out.println(val);
        }
        for(int i = 0; i < 4; i++){
            System.out.println(ip1.getOct(i).;
        }
        ip_adress ip2 = new ip_adress("192.168.110.129");
        ip_adress snm = new ip_adress("255.255.255.192");
        System.out.println(network_switch.verify_network(ip1, snm, ip2, snm));
    }
}
