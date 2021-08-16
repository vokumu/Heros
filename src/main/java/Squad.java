import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> mInstances = new ArrayList<>();
    private int maxSize;
    private String name;
    private String fightingCause;

    public Squad(int maxSize,String name,String fightingCause){
        this.maxSize=maxSize;
        this.name=name;
        this.fightingCause=fightingCause;
        mInstances.add(this);

    }
    //get methods
    public String getName() {
        return name;
    }
    public int getMaxSize() { return maxSize;}
    public String getFightingCause(){ return fightingCause;}
    public static ArrayList<Squad> getAll() {
        return mInstances;
    }
    public static void clearAllSquad(){
        mInstances.clear();
    }

}
