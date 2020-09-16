package sample;

public class Robots {
    private String name;
    private int value;

    public Robots(String name, int value){
        this.name = name;
        this.value = value;
    }

    public void changeValue(int value ){
        this.value = value;
        System.out.println("My value was changed to "+value);
    }

    public int getValue(){
        return value;
    }
}

