import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int maxSize;
    private String name;
    private String fightingCause;
    private int id;

    public Squad(int maxSize,String name,String fightingCause){
        this.maxSize=maxSize;
        this.name=name;
        this.fightingCause=fightingCause;
        instances.add(this);
        this.id = instances.size();

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
    public int getId() {
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }

}
