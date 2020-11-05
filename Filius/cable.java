package Filius;

public class cable {
    Class<?>[] allowed_classes = {computer.class, network_switch.class};
    Object[] connnected_to = new Object[2];


    private boolean array_contains(Class<?>[] array, Object o){
        for(Class<?> c : array){
            if(c.getClass() == o.getClass()){
                return true;
            }
        }
        return false;
    }

    public cable(Object o1, Object o2){
        if(array_contains(allowed_classes, o1) && array_contains(allowed_classes, o2)){
            this.connnected_to[0] = o1;
            this.connnected_to[1] = o2;
        }
    }

    public Object[] getConnnections() {
        return connnected_to;
    }
}
