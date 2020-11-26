package Filius;

public class Frame {
    private MacAdress source;
    private MacAdress target;
    private byte[] data;
    private byte[] padding;
    
    //min-size 64 byte
    //max-size 1522 byte

    //"thats deep" - Diver that found the Mariana Trench, probably

    public Frame(MacAdress source, MacAdress target, byte[] data){
            this.source = source;
            this.target = target;
            if(data.length < 46){
                this.padding = new byte[64 - data.length];
            }
            this.data = data;
    }


    public byte[] getData() {
        return data;
    }
    public byte[] getPadding() {
        return padding;
    }
    public MacAdress getSource() {
        return source;
    }
    public MacAdress getTarget() {
        return target;
    }
}
