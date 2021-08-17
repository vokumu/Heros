import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private Squad msquad;
    private int id;

    private static ArrayList<Hero> mInstances = new ArrayList<>();

    //constructor
    public Hero(String name,int age,String specialPower,String weakness,Squad squad){
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
        mInstances.add(this);
        msquad=squad;
        this.id = mInstances.size();

    }
    //get methods
    public String getName() {
        return name;
    }
    public int getAge() { return age;}
    public String getSpecialPower(){ return specialPower;}
    public String getWeakness(){ return weakness;}
    public Squad getMsquad(){ return msquad;}
    public static ArrayList<Hero> getAll() {
        return mInstances;
    }
    public static void clearAllHero(){
        mInstances.clear();
    }
    public int getId() {
        return id;
    }
    }



