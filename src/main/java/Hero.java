import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPower;
    private String weakness;

    private static ArrayList<Squad> mInstances = new ArrayList<>();

    //constructor
    public Hero(String name,int age,String specialPower,String weakness){
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
        mInstances.add(this);

    }



}
