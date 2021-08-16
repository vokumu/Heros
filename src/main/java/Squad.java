import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int maxSize;
    private String name;
    private String fightingCause;

    public Squad(int maxSize,String name,String fightingCause){
        this.maxSize=maxSize;
        this.name=name;
        this.fightingCause=fightingCause;
        instances.add(this);

    }
    //get methods
    public String getName() {
        return name;
    }
    public int getMaxSize() { return maxSize;}
    public String getFightingCause(){ return fightingCause;}
    public static ArrayList<Squad> getAll() {
        return instances;
    }
    public static void clearAllSquad(){
        instances.clear();
    }

}
